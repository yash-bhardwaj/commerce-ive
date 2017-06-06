package com.rccl.cp.ive.update.cruisecompass.api.impl;

import org.immutables.value.Value;

import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.Jsonable;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage;

import akka.Done;

public interface CruiseCompassEventCommand extends Jsonable {
    @Value.Immutable
    interface UpdateCruiseCompassEventCommand extends
        CruiseCompassEventCommand, PersistentEntity.ReplyType<Done> {
        CruiseCompassEventMessage message();
    }

    @Value.Immutable
    interface RemoveCruiseCompassEventCommand extends
        CruiseCompassEventCommand, PersistentEntity.ReplyType<Done> {
        String shipSailDate();
        String guestID();
        String ownerGuestID();
        String ownerReservationID();
        String sourceSystemApplicationID();
        String sourceSystemOfferingID();
        String eventType();
    }

}
