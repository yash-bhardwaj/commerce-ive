package com.rccl.cp.ive.update.dining.api.impl;

import org.immutables.value.Value;

import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.Jsonable;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;

import akka.Done;

public interface DiningEventCommand extends Jsonable {

    @Value.Immutable
    interface UpdateDiningEventCommand extends DiningEventCommand,
        PersistentEntity.ReplyType<Done> {
        DiningEventMessage message();
    }

    @Value.Immutable
    interface RemoveDiningEventCommand extends DiningEventCommand,
        PersistentEntity.ReplyType<Done> {
        String shipSailDate();
        String guestID();
        String ownerGuestID();
        String ownerReservationID();
        String sourceSystemApplicationID();
        String sourceSystemOfferingID();
        String eventType();
    }
}
