package com.rccl.cp.ive.update.cruisecompass.api.impl;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
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
import com.rccl.cp.ive.update.common.ImmutableEventSourceDetail;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassUpdateService;
import com.rccl.cp.ive.update.cruisecompass.api.ImmutableCruiseCompassEventMessage;
import com.rccl.cp.ive.update.validation.DeleteRequestValidator;
import com.rccl.cp.ive.update.validation.UpdateRequestValidator;

import akka.Done;
import akka.NotUsed;
import akka.japi.Pair;
import akka.stream.Materializer;

public class CruiseCompassUpdateServiceImpl implements
    CruiseCompassUpdateService {

    private final PersistentEntityRegistry persistentEntityRegistry;
    @SuppressWarnings("unused")
    private final CassandraSession cassandraSession;
    @SuppressWarnings("unused")
    private final Materializer materializer;
    private Logger logger = LoggerFactory.getLogger(
        CruiseCompassUpdateServiceImpl.class);

    @Inject
    public CruiseCompassUpdateServiceImpl(
        final PersistentEntityRegistry persistentEntityReg,
        final CassandraSession cassandraSess,
        final Materializer materializr, ReadSide readside) {
        this.persistentEntityRegistry = persistentEntityReg;
        this.persistentEntityRegistry.register(CruiseCompassEventEntity.class);
        this.cassandraSession = cassandraSess;
        this.materializer = materializr;
        logger.info("CruiseCompassUpdateServiceImpl() INJECTED CASSANDRA "
            + "SESSION {}", cassandraSess);
        logger.info("CruiseCompassUpdateServiceImpl() INJECTED AKKA "
            + "MATERIALIZER {}", materializr);
        readside.register(CruiseCompassEventProcessor.class);
    }

    @Override
    public final HeaderServiceCall<CruiseCompassEventMessage, Done>
        updateCruiseCompassEvents(final String shipSailDate) {
        return (requestHeader, request) -> {

            Optional<String> apiKey = requestHeader.getHeader(Constant.HEADER_API_KEY);

            if (!apiKey.isPresent()) {
                throw Constant.BR_UNAUTHORIZED;
            }

            ImmutableCruiseCompassEventMessage requestWithResID =
                ImmutableCruiseCompassEventMessage.builder()
                    .from(request).build();
            if (request.sourceDetail().sourceSystemReservationID().equals("0") ||
                StringUtils.isBlank(request.sourceDetail().sourceSystemReservationID())) {
                requestWithResID = ImmutableCruiseCompassEventMessage.builder()
                    .from(request)
                    .sourceDetail(ImmutableEventSourceDetail.builder()
                        .from(request.sourceDetail())
                        .sourceSystemReservationID(UUID.randomUUID().toString())
                        .build())
                    .build();
            }

            Profiler timer = new Profiler("CruiseCompassUpdateService.updateCruiseCompassEvents");
            timer.setLogger(logger);
            //UpdateRequestValidator.validateDbTable(cassandraSession);
            UpdateRequestValidator.validateRequest(requestWithResID, shipSailDate);
            CompositeEventID id = new CompositeEventID(shipSailDate,
                requestWithResID.guestID(),
                requestWithResID.sourceDetail().sourceSystemApplicationID(),
                requestWithResID.sourceDetail().sourceSystemOfferingID());
            PersistentEntityRef<CruiseCompassEventCommand> ref =
                persistentEntityRegistry
                    .refFor(CruiseCompassEventEntity.class, id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            CompletionStage<Done> asked = ref.ask(ImmutableUpdateCruiseCompassEventCommand.builder()
                .message(requestWithResID).build());
            timer.stop();
            if (logger.isDebugEnabled()) {
                timer.log();
            }
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }

    @Override
    public final HeaderServiceCall<NotUsed, Done> removeCruiseCompassEvents(
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

            //DeleteRequestValidator.validateDbTable(cassandraSession);
            DeleteRequestValidator.validateRequest(shipSailDate, guestID,
                ownerGuestID, sourceSystemApplicationID, sourcesystemOfferingID);
            CompositeEventID id = new CompositeEventID(shipSailDate, guestID,
                sourceSystemApplicationID, sourcesystemOfferingID);
            PersistentEntityRef<CruiseCompassEventCommand> ref =
                persistentEntityRegistry
                    .refFor(CruiseCompassEventEntity.class, id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            CompletionStage<Done> asked = ref.ask(ImmutableRemoveCruiseCompassEventCommand.builder()
                .shipSailDate(shipSailDate)
                .guestID(guestID)
                .ownerGuestID(ownerGuestID)
                .ownerReservationID(ownerReservationID)
                .sourceSystemApplicationID(sourceSystemApplicationID)
                .sourceSystemOfferingID(sourcesystemOfferingID)
                .eventType("CRUISECOMPASS")
                .build());
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }

    @Override
    public final HeaderServiceCall<CruiseCompassEventMessage, Done>
        updateSelfEvents(final String shipSailDate) {
        return (requestHeader, request) -> {

            Optional<String> apiKey = requestHeader.getHeader(Constant.HEADER_API_KEY);

            if (!apiKey.isPresent()) {
                throw Constant.BR_UNAUTHORIZED;
            }

            ImmutableCruiseCompassEventMessage requestWithResID =
                ImmutableCruiseCompassEventMessage.builder()
                    .from(request).build();
            if (request.sourceDetail().sourceSystemReservationID().equals("0") ||
                StringUtils.isBlank(request.sourceDetail().sourceSystemReservationID())) {
                requestWithResID = ImmutableCruiseCompassEventMessage.builder()
                    .from(request)
                    .sourceDetail(ImmutableEventSourceDetail.builder()
                        .from(request.sourceDetail())
                        .sourceSystemReservationID(UUID.randomUUID().toString())
                        .sourceSystemOfferingID(UUID.randomUUID().toString())
                        .build())
                    .build();
            }

            Profiler timer = new Profiler("CruiseCompassUpdateService.updateSelfEvents");
            timer.setLogger(logger);
            //UpdateRequestValidator.validateDbTable(cassandraSession);
            UpdateRequestValidator.validateRequest(requestWithResID, shipSailDate);
            CompositeEventID id = new CompositeEventID(shipSailDate,
                requestWithResID.guestID(),
                requestWithResID.sourceDetail().sourceSystemApplicationID(),
                requestWithResID.sourceDetail().sourceSystemOfferingID());
            PersistentEntityRef<CruiseCompassEventCommand> ref =
                persistentEntityRegistry
                    .refFor(CruiseCompassEventEntity.class, id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            CompletionStage<Done> asked = ref.ask(ImmutableUpdateCruiseCompassEventCommand.builder()
                .message(requestWithResID).build());
            timer.stop();
            if (logger.isDebugEnabled()) {
                timer.log();
            }
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }

    @Override
    public final HeaderServiceCall<NotUsed, Done> removeSelfEvents(
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

            //DeleteRequestValidator.validateDbTable(cassandraSession);
            DeleteRequestValidator.validateRequest(shipSailDate, guestID,
                ownerGuestID, sourceSystemApplicationID, sourcesystemOfferingID);
            CompositeEventID id = new CompositeEventID(shipSailDate, guestID,
                sourceSystemApplicationID, sourcesystemOfferingID);
            PersistentEntityRef<CruiseCompassEventCommand> ref =
                persistentEntityRegistry
                    .refFor(CruiseCompassEventEntity.class, id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            System.out.println(ownerReservationID);
            CompletionStage<Done> asked = ref.ask(ImmutableRemoveCruiseCompassEventCommand.builder()
                .shipSailDate(shipSailDate)
                .guestID(guestID)
                .ownerGuestID(ownerGuestID)
                .ownerReservationID(ownerReservationID)
                .sourceSystemApplicationID(sourceSystemApplicationID)
                .sourceSystemOfferingID(sourcesystemOfferingID)
                .eventType("SELF")
                .build());
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }
}
