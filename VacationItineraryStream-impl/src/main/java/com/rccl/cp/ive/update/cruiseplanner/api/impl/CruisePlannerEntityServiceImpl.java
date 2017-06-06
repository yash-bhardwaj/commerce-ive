package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.api.transport.ResponseHeader;
import com.lightbend.lagom.javadsl.persistence.AggregateEventShards;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.javadsl.persistence.Offset;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.lightbend.lagom.javadsl.server.HeaderServiceCall;
import com.rccl.cp.ive.update.common.CommonConfigurations;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEntityService;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;

import akka.NotUsed;
import akka.japi.Pair;
import akka.stream.Materializer;
import akka.stream.javadsl.Source;

public class CruisePlannerEntityServiceImpl implements
    CruisePlannerEntityService {
    private Logger logger = LoggerFactory.getLogger(
        CruisePlannerEntityServiceImpl.class);

    private PersistentEntityRegistry persistentEntityRegistry;
    @SuppressWarnings("unused")
    private Materializer materializer;

    @Inject
    public CruisePlannerEntityServiceImpl(
        final PersistentEntityRegistry persistentEntityRgistry,
        final Materializer materializr) {
        this.persistentEntityRegistry = persistentEntityRgistry;
        this.materializer = materializr;
    }

    @Override
    public final HeaderServiceCall<String, Source<CruisePlannerEventMessage, NotUsed>>
        getCruisePlannerEventStates(final String entityId) {
        return (requestHeader, request) -> {
            if (logger.isDebugEnabled()) {
                logger.debug("Retrieving entity "
                    + createEntityIdFromURLParam(entityId));
            }
            ResponseHeader responseHeader = ResponseHeader.OK
                .withHeader("Access-Control-Allow-Origin", "*");
            AggregateEventTag<CruisePlannerEventEvent> cpEventTag =
                aggregateTag(createEntityIdFromURLParam(entityId));
            logger.debug("" + cpEventTag.eventType() + " " + cpEventTag.tag() + " " + cpEventTag);
            Source<Pair<CruisePlannerEventEvent, Offset>, NotUsed> eventSource =
                persistentEntityRegistry.eventStream(cpEventTag,
                    Offset.NONE);
            Source<CruisePlannerEventMessage, NotUsed> mappedSource =
                eventSource.map(p -> p.first().message().get());
            return CompletableFuture.completedFuture(Pair.create(responseHeader, mappedSource));
        };
    }

    private AggregateEventTag<CruisePlannerEventEvent> aggregateTag(
        final String entityId) {
        logger.info("aggregateTag() Create aggregating shard for event {}",
            entityId);
        AggregateEventShards<CruisePlannerEventEvent> shardedTag =
            new AggregateEventShards<CruisePlannerEventEvent>(
                CruisePlannerEventEvent.class, "CRUISE_PLANNER_EVENT",
                CommonConfigurations.NUM_SHARDS);
        // return shardedTag.forEntityId(entityId);
        return shardedTag.forEntityId(entityId);
    }

    public static String createEntityIdFromURLParam(final String urlParam) {
        String[] params = urlParam.split("_");
        final int numParams = 4;
        if (params.length != numParams) {
            throw new IllegalArgumentException(
                "Must be in saling_guest_app_offering format");
        }
        return String.format("/%s/%s/%s/%s", params[0], params[1], params[2],
            params[numParams - 1]);
    }
}
