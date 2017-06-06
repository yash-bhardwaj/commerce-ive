package com.rccl.cp.ive.update.cruiseplanner.api.impl;

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
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;
import com.rccl.cp.ive.update.readside.po.RemoveGuestCalendarEventCommand;
import com.rccl.cp.ive.update.readside.po.UpdateGuestCalendarEventCommand;

import akka.Done;

public class CruisePlannerEventProcessor extends ReadSideProcessor<CruisePlannerEventEvent> {
    private Logger logger = LoggerFactory.getLogger(CruisePlannerEventProcessor.class);

    private CassandraReadSide readside;
    private CassandraSession cassandraSession;
    private ReadsideGuestCalendarPersistor readsideCalendarPersistor;
    private static final int MIN_EVENT_ID_SIZE = 5;

    @Inject
    public CruisePlannerEventProcessor(CassandraReadSide readside, CassandraSession cassandraSession,
        ReadsideGuestCalendarPersistor persistor) {
        super();
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@
        // cruisePlannerEventProcessor constructor ");
        this.readside = readside;
        this.cassandraSession = cassandraSession;
        this.readsideCalendarPersistor = persistor;
    }

    @Override
    public PSequence<AggregateEventTag<CruisePlannerEventEvent>> aggregateTags() {
        return CruisePlannerEventEvent.SHARDED_TAG.allTags();
    }

    @Override
    public com.lightbend.lagom.javadsl.persistence.ReadSideProcessor.ReadSideHandler<CruisePlannerEventEvent>
        buildHandler() {
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@ buildHandler ");
        CassandraReadSide.ReadSideHandlerBuilder<CruisePlannerEventEvent> builder =
            readside.builder("cruisePlannerEventOffset");
        builder.setEventHandler(ImmutableCruisePlannerEventUpdated.class, this::processCruisePlannerEventUpdated);
        builder.setEventHandler(ImmutableCruisePlannerEventRemoved.class, this::processCruisePlannerEventRemoved);
        builder.setPrepare(tag -> prepareShard(tag));
        ReadSideHandler<CruisePlannerEventEvent> handler = builder.build();
        return handler;
    }

    private CompletionStage<Done> prepareShard(AggregateEventTag<CruisePlannerEventEvent> tag) {
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@@@@@@@@@@@@@@
        // prepareShard " + tag);
        CompletableFuture<Done> future = new CompletableFuture<>();
        future.complete(Done.getInstance());
        return future;
    }

    private CompletionStage<List<BoundStatement>>
        processCruisePlannerEventUpdated(CruisePlannerEventEvent.CruisePlannerEventUpdated event) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ processCruisePlannerEventUpdated");
        }
        CruisePlannerEventMessage m = event.message().get();

        UpdateGuestCalendarEventCommand command =
            new UpdateGuestCalendarEventCommand(
                cassandraSession, m, readsideCalendarPersistor);
        command.execute();

        CompletableFuture<List<BoundStatement>> future = new CompletableFuture<>();
        future.complete(new ArrayList<BoundStatement>());
        return future;
    }

    private CompletionStage<List<BoundStatement>>
        processCruisePlannerEventRemoved(CruisePlannerEventEvent.CruisePlannerEventRemoved evt) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ processCruisePlannerEventRemoved");
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
