package com.rccl.cp.ive.update.readside.po;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.pcollections.PSequence;

import com.google.inject.Singleton;
import com.lightbend.lagom.javadsl.persistence.AggregateEvent;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTagger;
import com.lightbend.lagom.javadsl.persistence.Offset;
import com.lightbend.lagom.javadsl.persistence.ReadSide;
import com.lightbend.lagom.javadsl.persistence.ReadSideProcessor;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.readside.utils.CompletionStageUtils;

import akka.Done;
import akka.japi.Pair;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

@Singleton
public class DiningReadSideTestDriver implements ReadSide {
    private final play.api.inject.Injector injector;
    private final Materializer materializer;

    private ConcurrentMap<Class<?>, List<Pair<ReadSideProcessor.ReadSideHandler<?>, Offset>>> processors =
        new ConcurrentHashMap<>();
    private CassandraSession stolenLeakingCassandraSession;

    @Inject
    public DiningReadSideTestDriver(play.api.inject.Injector injector, Materializer materializer) {
        this.injector = injector;
        this.materializer = materializer;
    }

    @Override
    public <DiningEventEvent extends AggregateEvent<DiningEventEvent>> void register(
        Class<? extends ReadSideProcessor<DiningEventEvent>> processorClass) {
        ReadSideProcessor<DiningEventEvent> processor = (ReadSideProcessor<DiningEventEvent>) injector
            .instanceOf(processorClass);
        stolenLeakingCassandraSession = stealCassandraSessionFromOneProcessor(processor);
        PSequence<AggregateEventTag<DiningEventEvent>> eventTags = processor.aggregateTags();

        CompletionStage<Done> processorInit = processor.buildHandler().globalPrepare().thenCompose(x -> {
            AggregateEventTag<DiningEventEvent> tag = eventTags.get(0);
            ReadSideProcessor.ReadSideHandler<DiningEventEvent> handler = processor.buildHandler();
            return handler.prepare(tag).thenApply(offset -> {
                List<Pair<ReadSideProcessor.ReadSideHandler<?>, Offset>> currentHandlers = processors
                    .computeIfAbsent(tag.eventType(), (z) -> new ArrayList<>());
                currentHandlers.add(Pair.create(handler, offset));
                return Done.getInstance();
            });
        });

        try {
            processorInit.toCompletableFuture().get(30, SECONDS);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't register the processor on the testkit.", e);
        }

    }

    /**
     * Get cassandra session using reflection forcefully. Wow this is bad. Why
     * would someone want to lock down read-side from unit testing?
     *
     * @return
     */
    private CassandraSession stealCassandraSessionFromOneProcessor(Object processor) {
        Field f;
        try {
            f = processor.getClass().getDeclaredField("cassandraSession");
            f.setAccessible(true);
            CassandraSession iWantThis = (CassandraSession) f.get(processor); // IllegalAccessException
            return iWantThis;
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CassandraSession getCassandraSessionIfExist() {
        return stolenLeakingCassandraSession;
    }

    public <Event extends AggregateEvent<Event>> CompletionStage<Done> feed(Event e, Offset offset) {
        AggregateEventTagger<Event> tag = e.aggregateTag();

        List<Pair<ReadSideProcessor.ReadSideHandler<?>, Offset>> list = processors.get(tag.eventType());

        if (list == null) {
            throw new RuntimeException("No processor registered for Event " + tag.eventType().getCanonicalName());
        }

        List<CompletionStage<Done>> stages = list.stream().map(pHandlerOffset -> {
            Flow<Pair<Event, Offset>, Done, ?> flow = ((ReadSideProcessor.ReadSideHandler<Event>) pHandlerOffset
                .first()).handle();
            return Source.single(Pair.create(e, offset)).via(flow).runWith(Sink.ignore(), materializer);
        }).collect(Collectors.toList());
        return CompletionStageUtils.doAll(stages);
    }

}
