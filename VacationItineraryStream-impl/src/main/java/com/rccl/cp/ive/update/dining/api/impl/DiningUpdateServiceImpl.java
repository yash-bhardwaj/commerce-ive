package com.rccl.cp.ive.update.dining.api.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import com.lightbend.lagom.javadsl.api.deser.ExceptionMessage;
import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.api.transport.ResponseHeader;
import com.lightbend.lagom.javadsl.api.transport.TransportErrorCode;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.lightbend.lagom.javadsl.persistence.ReadSide;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.lightbend.lagom.javadsl.server.HeaderServiceCall;
import com.rccl.cp.ive.update.common.Constant;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import com.rccl.cp.ive.update.dining.api.DiningUpdateService;
import com.rccl.cp.ive.update.validation.DeleteRequestValidator;
import com.rccl.cp.ive.update.validation.UpdateRequestValidator;

import akka.Done;
import akka.NotUsed;
import akka.japi.Pair;

public class DiningUpdateServiceImpl implements DiningUpdateService {

    private final PersistentEntityRegistry persistentEntityRegistry;
    @SuppressWarnings("unused")
    private final CassandraSession cassandraSession;
    private Logger logger = LoggerFactory.getLogger(DiningUpdateServiceImpl.class);

    @Inject
    public DiningUpdateServiceImpl(final PersistentEntityRegistry registry,
        final CassandraSession session, ReadSide readside) {
        this.persistentEntityRegistry = registry;
        registry.register(DiningEventEntity.class);
        this.cassandraSession = session;
        if (logger.isDebugEnabled()) {
            logger.debug("register entity for dining service");
            logger.debug("injecting cassandra session");
        }
        readside.register(DiningEventProcessor.class);
    }

    @Override
    public final HeaderServiceCall<DiningEventMessage, Done> updateEvents(
        final String shipSailDate) {
        return (requestHeader, request) -> {

            Optional<String> apiKey = requestHeader.getHeader(Constant.HEADER_API_KEY);

            if (!apiKey.isPresent()) {
                throw Constant.BR_UNAUTHORIZED;
            }

            Profiler timer = new Profiler("DiningUpdateService.updateEvents");
            timer.setLogger(logger);
            //UpdateRequestValidator.validateDbTable(cassandraSession);
            UpdateRequestValidator.validateRequest(request, shipSailDate);
            CompositeEventID id = new CompositeEventID(shipSailDate,
                request.guestID(),
                request.sourceDetail().sourceSystemApplicationID(),
                request.sourceDetail().sourceSystemOfferingID());
            PersistentEntityRef<DiningEventCommand> ref =
                persistentEntityRegistry.refFor(DiningEventEntity.class,
                    id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            CompletionStage<Done> asked = ref.ask(ImmutableUpdateDiningEventCommand.builder()
                .message(request).build());
            try {
                asked.toCompletableFuture().get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e.toString());
            }
            timer.stop();
            if (logger.isDebugEnabled()) {
                timer.log();
            }
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }

    @Override
    public final HeaderServiceCall<NotUsed, Done> removeEvents(
        final String shipSailDate,
        final String guestID,
        final String ownerGuestID,
        final String ownerReservationID,
        final String sourceSystemApplicationID,
        final String sourcesystemOfferingID) {
        // To do Auto-generated method stub
        return (requestHeader, request) -> {

            Optional<String> apiKey = requestHeader.getHeader(Constant.HEADER_API_KEY);

            if (!apiKey.isPresent()) {
                throw Constant.BR_UNAUTHORIZED;
            }

            Profiler timer = new Profiler("DiningUpdateService.removeEvents");
            timer.setLogger(logger);

            DeleteRequestValidator.validateDbTable(cassandraSession);
            DeleteRequestValidator.validateRequest(shipSailDate, guestID, ownerGuestID,
                sourceSystemApplicationID, sourcesystemOfferingID);
            CompositeEventID id = new CompositeEventID(shipSailDate, guestID,
                sourceSystemApplicationID, sourcesystemOfferingID);
            PersistentEntityRef<DiningEventCommand> ref =
                persistentEntityRegistry.refFor(DiningEventEntity.class,
                    id.toString());
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");

            CompletionStage<Done> asked = ref.ask(ImmutableRemoveDiningEventCommand.builder()
                .shipSailDate(shipSailDate)
                .guestID(guestID)
                .ownerGuestID(ownerGuestID)
                .ownerReservationID(ownerReservationID)
                .sourceSystemApplicationID(sourceSystemApplicationID)
                .sourceSystemOfferingID(sourcesystemOfferingID)
                .eventType("DINING")
                .build());
            timer.stop();
            if (logger.isDebugEnabled()) {
                timer.log();
            }
            return CompletableFuture.supplyAsync(() -> Pair.create(responseHeader, Done.getInstance()));
        };
    }
}
