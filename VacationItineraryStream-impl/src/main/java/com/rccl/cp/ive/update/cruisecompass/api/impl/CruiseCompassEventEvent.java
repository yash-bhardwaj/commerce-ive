package com.rccl.cp.ive.update.cruisecompass.api.impl;

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
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage;

public interface CruiseCompassEventEvent extends
    AggregateEvent<CruiseCompassEventEvent>, Jsonable {

    Logger LOGGER = LoggerFactory.getLogger(
        CruiseCompassEventEvent.class);
    AggregateEventTag<CruiseCompassEventEvent> CRUISE_COMPASS_EVENT_TAG =
        AggregateEventTag.of(CruiseCompassEventEvent.class);
    AggregateEventShards<CruiseCompassEventEvent> SHARDED_TAG =
        new AggregateEventShards<CruiseCompassEventEvent>(
            CruiseCompassEventEvent.class, "CRUISE_COMPASS_EVENT",
            CommonConfigurations.NUM_SHARDS);

    Optional<CruiseCompassEventMessage> message();

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
    default AggregateEventTag<CruiseCompassEventEvent> aggregateTag() {
        LOGGER.info("aggregateTag() Create aggregating shard for event {}",
            getEntityId());
        return SHARDED_TAG.forEntityId(getEntityId());
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableCruiseCompassEventUpdated.class)
    @JsonDeserialize(as = ImmutableCruiseCompassEventUpdated.class)
    interface CruiseCompassEventUpdated extends CruiseCompassEventEvent {
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableCruiseCompassEventRemoved.class)
    @JsonDeserialize(as = ImmutableCruiseCompassEventRemoved.class)
    interface CruiseCompassEventRemoved extends CruiseCompassEventEvent {
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
