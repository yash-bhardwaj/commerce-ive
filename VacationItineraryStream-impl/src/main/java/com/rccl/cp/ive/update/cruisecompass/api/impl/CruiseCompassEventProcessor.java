package com.rccl.cp.ive.update.cruisecompass.api.impl;

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
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;
import com.rccl.cp.ive.update.readside.po.RemoveGuestCalendarEventCommand;
import com.rccl.cp.ive.update.readside.po.UpdateGuestCalendarEventCommand;

import akka.Done;

public class CruiseCompassEventProcessor extends ReadSideProcessor<CruiseCompassEventEvent> {
    private Logger logger = LoggerFactory.getLogger(CruiseCompassEventProcessor.class);
    private CassandraReadSide readside;
    private CassandraSession cassandraSession;
    private ReadsideGuestCalendarPersistor readsideCalendarPersistor;
    private static final int MIN_EVENT_ID_SIZE = 5;

    @Inject
    public CruiseCompassEventProcessor(CassandraReadSide readside, CassandraSession cassandraSession,
        ReadsideGuestCalendarPersistor persistor) {
        super();
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@
        // CruiseCompassEventProcessor constructor ");
        this.readside = readside;
        this.cassandraSession = cassandraSession;
        this.readsideCalendarPersistor = persistor;
    }

    @Override
    public PSequence<AggregateEventTag<CruiseCompassEventEvent>> aggregateTags() {
        return CruiseCompassEventEvent.SHARDED_TAG.allTags();
    }

    @Override
    public com.lightbend.lagom.javadsl.persistence.ReadSideProcessor.ReadSideHandler<CruiseCompassEventEvent>
        buildHandler() {
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@ buildHandler ");
        CassandraReadSide.ReadSideHandlerBuilder<CruiseCompassEventEvent> builder =
            readside.builder("CruiseCompassEventOffset");
        builder.setEventHandler(ImmutableCruiseCompassEventUpdated.class, this::processCruiseCompassEventUpdated);
        builder.setEventHandler(ImmutableCruiseCompassEventRemoved.class, this::processCruiseCompassEventRemoved);
        builder.setPrepare(tag -> prepareShard(tag));
        ReadSideHandler<CruiseCompassEventEvent> handler = builder.build();
        return handler;
    }

    private CompletionStage<Done> prepareShard(AggregateEventTag<CruiseCompassEventEvent> tag) {
        // if (logger.isDebugEnabled()) logger.debug("@@@@@@@@@@@@@@@@@@@@@
        // prepareShard " + tag);
        CompletableFuture<Done> future = new CompletableFuture<>();
        future.complete(Done.getInstance());
        return future;
    }

    private CompletionStage<List<BoundStatement>>
        processCruiseCompassEventUpdated(CruiseCompassEventEvent.CruiseCompassEventUpdated event) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ processCruiseCompassEventUpdated");
        }
        CruiseCompassEventMessage m = event.message().get();

        UpdateGuestCalendarEventCommand command =
            new UpdateGuestCalendarEventCommand(
                cassandraSession, m, readsideCalendarPersistor);
        command.execute();

        CompletableFuture<List<BoundStatement>> future = new CompletableFuture<>();
        future.complete(new ArrayList<BoundStatement>());
        return future;
    }

    private CompletionStage<List<BoundStatement>>
        processCruiseCompassEventRemoved(CruiseCompassEventEvent.CruiseCompassEventRemoved evt) {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ processCruiseCompassEventRemoved");
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
