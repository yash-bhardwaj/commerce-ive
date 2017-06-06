package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerStreamService;
import com.rccl.cp.ive.update.cruiseplanner.api.ImmutableStreamResponse;
import com.rccl.cp.ive.update.cruiseplanner.api.StreamResponse;

import akka.NotUsed;
import akka.japi.function.Function2;
import akka.stream.Materializer;
import akka.stream.javadsl.Source;

public class CruisePlannerStreamServiceImpl
    implements CruisePlannerStreamService {
    private final PersistentEntityRegistry persistentEntityRegistry;
    private final Materializer materializer;
    private final CompletionStageStreamResponse responseStream = new CompletionStageStreamResponse();
    private static final int ERROR_CODE_OK = 200;
    private static final StreamResponse END_OF_STREAM_RESPONSE =
        ImmutableStreamResponse.builder()
            .code(ERROR_CODE_OK)
            .message("COMPLETE")
            .streamStatusCode("NORMAL")
            .statusStatusMessage("End of Stream from client")
            .count(-1)
            .build();

    private static final StreamResponse NOT_STARTED_YET_RESPONSE =
        ImmutableStreamResponse.builder()
            .code(0)
            .message("START")
            .streamStatusCode("NORMAL")
            .statusStatusMessage("Beginning Stream from client")
            .count(0)
            .build();

    @Inject
    public CruisePlannerStreamServiceImpl(final PersistentEntityRegistry persistentEntityRegstry,
        final Materializer materializr) {
        super();
        this.persistentEntityRegistry = persistentEntityRegstry;
        this.materializer = materializr;
    }

    @SuppressWarnings("serial")
    @Override
    public final ServiceCall<Source<CruisePlannerEventMessage, NotUsed>,
        Source<StreamResponse, NotUsed>> streamCruisePlannerEvents() {
        return request -> {
            // http://www.programcreek.com/java-api-examples/index.php
            // ?api=akka.stream.javadsl.Source
            StreamResponse initialFoldResult = NOT_STARTED_YET_RESPONSE;
            request.runFold(initialFoldResult,
                new Function2<StreamResponse, CruisePlannerEventMessage,
                    StreamResponse>() {

                    @Override
                    public StreamResponse apply(
                        final StreamResponse previousFoldResult,
                        final CruisePlannerEventMessage message)
                        throws Exception {
                        System.out.println("streamCruisePlannerEvents "
                            + previousFoldResult + " RECEIVED: " + message);
                        if (message.method().isPresent()) {
                            String method = message.method().get();
                            if (method.equals("POST")) {
                                runAsPost(message);
                            } else if (method.contentEquals("DELETE")) {
                                runAsDelete(message);
                            } else if (method.equals(METHOD_END_OF_STREAM)) {
                                responseStream.add(END_OF_STREAM_RESPONSE);
                            }
                        } else {
                            runAsPost(message);
                        }
                        long previousCount = previousFoldResult.count();
                        return ImmutableStreamResponse.builder()
                            .from(previousFoldResult)
                            .count(previousCount + 1)
                            .build();
                    }

                },
                materializer);
            return getResponseStreamCompletionStage();
        };
    }

    private CompletableFuture<Source<StreamResponse, NotUsed>>
        getResponseStreamCompletionStage() {
        Source<StreamResponse, NotUsed> source = Source.fromCompletionStage(
            responseStream);
        CompletableFuture<Source<StreamResponse, NotUsed>> completionStage =
            CompletableFuture.supplyAsync(() -> source);
        return completionStage;
    }

    private void runAsPost(final CruisePlannerEventMessage message) {
        // copy and paste from POST service
        CompositeEventID id = new CompositeEventID(message.shipSailDate(),
            message.guestID(),
            message.sourceDetail().sourceSystemApplicationID(),
            message.sourceDetail().sourceSystemOfferingID());
        PersistentEntityRef<CruisePlannerEventCommand> ref =
            persistentEntityRegistry
                .refFor(CruisePlannerEventEntity.class, id.toString());
        ref.ask(ImmutableUpdateCruisePlannerEventCommand.builder()
            .message(message).build());
    }

    private void runAsDelete(final CruisePlannerEventMessage message) {
        // copy and paste from DELETE service
        CompositeEventID id = new CompositeEventID(message.shipSailDate(),
            message.guestID(),
            message.sourceDetail().sourceSystemApplicationID(),
            message.sourceDetail().sourceSystemOfferingID());
        PersistentEntityRef<CruisePlannerEventCommand> ref =
            persistentEntityRegistry
                .refFor(CruisePlannerEventEntity.class, id.toString());
        ref.ask(ImmutableRemoveCruisePlannerEventCommand.builder()
            .shipSailDate(message.shipSailDate())
            .guestID(message.guestID())
            .sourceSystemApplicationID(
                message.sourceDetail().sourceSystemApplicationID())
            .sourceSystemOfferingID(
                message.sourceDetail().sourceSystemOfferingID())
            .build());
    }

    // Not implemented yet
    static class CompletionStageStreamResponse extends
        CompletableFuture<StreamResponse> {
        private Queue<StreamResponse> queue = new LinkedList<StreamResponse>();

        CompletionStageStreamResponse(final StreamResponse initialValue) {
            super();
            queue.add(initialValue);
        }

        CompletionStageStreamResponse() {
            super();
        }

        public void add(final StreamResponse value) {
            queue.add(value);
            if (value.equals(END_OF_STREAM_RESPONSE)) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX END OF STREAM");
                queue.clear();
                complete(value);
            }
        }
    }
}
