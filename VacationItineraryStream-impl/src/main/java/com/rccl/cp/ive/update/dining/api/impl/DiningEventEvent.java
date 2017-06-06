package com.rccl.cp.ive.update.dining.api.impl;

import java.util.Optional;

import org.immutables.value.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lightbend.lagom.javadsl.persistence.AggregateEvent;
import com.lightbend.lagom.javadsl.persistence.AggregateEventShards;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.serialization.Jsonable;
import com.rccl.cp.ive.update.common.CommonConfigurations;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;

public interface DiningEventEvent extends AggregateEvent<DiningEventEvent>,
    Jsonable {

    Logger LOGGER = LoggerFactory.getLogger(DiningEventEvent.class);

    AggregateEventTag<DiningEventEvent> DINING_EVENT_TAG = AggregateEventTag
        .of(DiningEventEvent.class);

    AggregateEventShards<DiningEventEvent> SHARDED_TAG =
        new AggregateEventShards<DiningEventEvent>(DiningEventEvent.class,
            "DINING_EVENT", CommonConfigurations.NUM_SHARDS);

    Optional<DiningEventMessage> message();

    default String getEntityId() {
        if (message().isPresent()) {
            StringBuilder sb = new StringBuilder("/");
            sb
                .append(message().get().shipSailDate())
                .append("/")
                .append(message().get().guestID())
                .append("/")
                .append(message().get().sourceDetail().sourceSystemApplicationID())
                .append("/")
                .append(message().get().sourceDetail().sourceSystemOfferingID());
            return sb.toString();
        } else {
            throw new IllegalStateException(
                "message is empty for update event");
        }
    }

    @Override
    default AggregateEventTag<DiningEventEvent> aggregateTag() {
        LOGGER.info("aggregateTag() Create aggregating shard for event {}",
            getEntityId());

        return SHARDED_TAG.forEntityId(getEntityId());
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableDiningEventUpdated.class)
    @JsonDeserialize(as = ImmutableDiningEventUpdated.class)
    interface DiningEventUpdated extends DiningEventEvent {

    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableDiningEventRemoved.class)
    @JsonDeserialize(as = ImmutableDiningEventRemoved.class)
    interface DiningEventRemoved extends DiningEventEvent {
        String shipSailDate();
        String guestID();
        String ownerGuestID();
        String ownerReservationID();
        String sourceSystemApplicationID();
        String sourceSystemOfferingID();
        String eventType();

        @Override
        default String getEntityId() {
            StringBuilder sb = new StringBuilder("/");
            sb
                .append(shipSailDate())
                .append("/")
                .append(guestID())
                .append("/")
                .append(ownerGuestID())
                .append("/")
                .append(ownerReservationID())
                .append("/")
                .append(sourceSystemApplicationID())
                .append("/")
                .append(sourceSystemOfferingID());
            return sb.toString();
        }
    }
}
