package com.rccl.cp.ive.update.dining.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.pcollections.PSequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.BoundStatement;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.javadsl.persistence.ReadSideProcessor;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraReadSide;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;
import com.rccl.cp.ive.update.readside.po.RemoveGuestCalendarEventCommand;
import com.rccl.cp.ive.update.readside.po.UpdateGuestCalendarEventCommand;

import akka.Done;

public class DiningEventProcessor extends ReadSideProcessor<DiningEventEvent> {

    private Logger logger = LoggerFactory.getLogger(DiningEventProcessor.class);

    private CassandraReadSide readside;
    private CassandraSession cassandraSession;
    private ReadsideGuestCalendarPersistor readsideCalendarPersistor;
    private static final int MIN_EVENT_ID_SIZE = 5;

    @Inject
    public DiningEventProcessor(CassandraReadSide readside, CassandraSession cassandraSession,
        ReadsideGuestCalendarPersistor persistor) {
        super();
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@
        // DiningEventProcessor constructor ");
        this.readside = readside;
        this.cassandraSession = cassandraSession;
        this.readsideCalendarPersistor = persistor;
    }

    @Override
    public PSequence<AggregateEventTag<DiningEventEvent>> aggregateTags() {
        return DiningEventEvent.SHARDED_TAG.allTags();
    }

    @Override
    public com.lightbend.lagom.javadsl.persistence.ReadSideProcessor.ReadSideHandler<DiningEventEvent> buildHandler() {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@ buildHandler ");
        }
        CassandraReadSide.ReadSideHandlerBuilder<DiningEventEvent> builder =
            readside.builder("diningEventOffset");
        builder.setEventHandler(ImmutableDiningEventUpdated.class, this::processDiningEventUpdated);
        builder.setEventHandler(ImmutableDiningEventRemoved.class, this::processDiningEventRemoved);
        builder.setPrepare(tag -> prepareShard(tag));
        ReadSideHandler<DiningEventEvent> handler = builder.build();
        return handler;
    }

    private CompletionStage<Done> prepareShard(AggregateEventTag<DiningEventEvent> tag) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@ prepareShard " + tag);
        }
        CompletableFuture<Done> future = new CompletableFuture<>();
        future.complete(Done.getInstance());
        return future;
    }

    private CompletionStage<List<BoundStatement>> processDiningEventUpdated(DiningEventEvent.DiningEventUpdated event) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ processDiningEventUpdated");
        }
        DiningEventMessage m = event.message().get();

        UpdateGuestCalendarEventCommand command =
            new UpdateGuestCalendarEventCommand(
                cassandraSession, m, readsideCalendarPersistor);
        command.execute();

        CompletableFuture<List<BoundStatement>> future = new CompletableFuture<>();
        future.complete(new ArrayList<BoundStatement>());
        return future;
    }

    private CompletionStage<List<BoundStatement>> processDiningEventRemoved(DiningEventEvent.DiningEventRemoved evt) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ processDiningEventRemoved");
        }
        RemoveGuestCalendarEventCommand command = new RemoveGuestCalendarEventCommand(cassandraSession,
            evt.shipSailDate(), evt.ownerReservationID(), evt.ownerGuestID(),
            evt.sourceSystemApplicationID(), evt.sourceSystemOfferingID(),
            evt.guestID(), evt.eventType(), readsideCalendarPersistor);
        command.execute();
        CompletableFuture<List<BoundStatement>> future = new CompletableFuture<>();
        future.complete(new ArrayList<BoundStatement>());
        return future;
    }

}
