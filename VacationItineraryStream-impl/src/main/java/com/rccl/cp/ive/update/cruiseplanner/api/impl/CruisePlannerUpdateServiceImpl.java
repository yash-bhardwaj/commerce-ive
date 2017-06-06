package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.api.transport.ResponseHeader;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.lightbend.lagom.javadsl.persistence.ReadSide;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.lightbend.lagom.javadsl.server.HeaderServiceCall;
import com.rccl.cp.ive.update.common.Constant;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerUpdateService;
import com.rccl.cp.ive.update.validation.DeleteRequestValidator;
import com.rccl.cp.ive.update.validation.UpdateRequestValidator;

import akka.Done;
import akka.NotUsed;
import akka.japi.Pair;
import akka.stream.Materializer;

public class CruisePlannerUpdateServiceImpl implements
    CruisePlannerUpdateService {

    private final PersistentEntityRegistry persistentEntityRegistry;
    @SuppressWarnings("unused")
    private final CassandraSession cassandraSession;
    @SuppressWarnings("unused")
    private final Materializer materializer;
    private Logger logger = LoggerFactory.getLogger(
        CruisePlannerUpdateServiceImpl.class);

    @Inject
    public CruisePlannerUpdateServiceImpl(final PersistentEntityRegistry persistentEntityRgistry,
        final CassandraSession cassandraSessn,
        final Materializer materializr, ReadSide readside) {
        this.persistentEntityRegistry = persistentEntityRgistry;
        this.persistentEntityRegistry.register(CruisePlannerEventEntity.class);
        this.cassandraSession = cassandraSessn;
        this.materializer = materializr;
        logger.info("CruisePlannerUpdateServiceImpl() INJECTED CASSANDRA "
            + "SESSION {}", cassandraSessn);
        logger.info("CruisePlannerUpdateServiceImpl() INJECTED AKKA "
            + "MATERIALIZER {}", materializr);
        readside.register(CruisePlannerEventProcessor.class);
    }

    @Override
    public final HeaderServiceCall<CruisePlannerEventMessage, Done>
        updateCruisePlannerEvents(final String shipSailDate) {
        return (requestHeader, request) -> {

            Optional<String> apiKey = requestHeader.getHeader(Constant.HEADER_API_KEY);

            if (!apiKey.isPresent()) {
                throw Constant.BR_UNAUTHORIZED;
            }

            Profiler timer = new Profiler("CruisePlannerUpdateService.updateCruisePlannerEvents");
            timer.setLogger(logger);
            //UpdateRequestValidator.validateDbTable(cassandraSession);
            UpdateRequestValidator.validateRequest(request, shipSailDate);
            CompositeEventID id = new CompositeEventID(shipSailDate,
                request.guestID(),
                request.sourceDetail().sourceSystemApplicationID(),
                request.sourceDetail().sourceSystemOfferingID());
            PersistentEntityRef<CruisePlannerEventCommand> ref =
                persistentEntityRegistry
                    .refFor(CruisePlannerEventEntity.class, id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            CompletionStage<Done> asked = ref.ask(ImmutableUpdateCruisePlannerEventCommand.builder()
                .message(request).build());
            timer.stop();
            if (logger.isDebugEnabled()) {
                timer.log();
            }
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }

    @Override
    public final HeaderServiceCall<NotUsed, Done> removeCruisePlannerEvents(
        final String shipSailDate,
        final String guestID,
        final String ownerGuestID,
        final String ownerReservationID,
        final String sourceSystemApplicationID,
        final String sourcesystemOfferingID) {
        return (requestHeader, request) -> {

            Optional<String> apiKey = requestHeader.getHeader(Constant.HEADER_API_KEY);

            if (!apiKey.isPresent()) {
                throw Constant.BR_UNAUTHORIZED;
            }

            DeleteRequestValidator.validateDbTable(cassandraSession);
            DeleteRequestValidator.validateRequest(shipSailDate, guestID,
                ownerGuestID, sourceSystemApplicationID, sourcesystemOfferingID);
            CompositeEventID id = new CompositeEventID(shipSailDate, guestID,
                sourceSystemApplicationID, sourcesystemOfferingID);
            PersistentEntityRef<CruisePlannerEventCommand> ref =
                persistentEntityRegistry
                    .refFor(CruisePlannerEventEntity.class, id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            CompletionStage<Done> asked = ref.ask(ImmutableRemoveCruisePlannerEventCommand.builder()
                .shipSailDate(shipSailDate)
                .guestID(guestID)
                .ownerGuestID(ownerGuestID)
                .ownerReservationID(ownerReservationID)
                .sourceSystemApplicationID(sourceSystemApplicationID)
                .sourceSystemOfferingID(sourcesystemOfferingID)
                .eventType("COMMERCE")
                .build());
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }
}
