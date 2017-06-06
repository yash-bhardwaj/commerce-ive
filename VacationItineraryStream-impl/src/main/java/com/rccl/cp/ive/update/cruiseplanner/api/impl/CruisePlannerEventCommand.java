package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import org.immutables.value.Value;

import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.Jsonable;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;

import akka.Done;

public interface CruisePlannerEventCommand extends Jsonable {

    @Value.Immutable
    interface UpdateCruisePlannerEventCommand
        extends CruisePlannerEventCommand, PersistentEntity.ReplyType<Done> {
        CruisePlannerEventMessage message();
    }

    @Value.Immutable
    interface RemoveCruisePlannerEventCommand
        extends CruisePlannerEventCommand, PersistentEntity.ReplyType<Done> {
        String shipSailDate();
        String guestID();
        String ownerGuestID();
        String ownerReservationID();
        String sourceSystemApplicationID();
        String sourceSystemOfferingID();
        String eventType();
    }
}
