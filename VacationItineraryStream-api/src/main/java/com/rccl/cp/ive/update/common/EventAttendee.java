package com.rccl.cp.ive.update.common;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableEventAttendee.class)
@JsonDeserialize(as = ImmutableEventAttendee.class)
public interface EventAttendee {
    String cruiseReservationID();
    String guestID();
    String sailingID();
    String firstName();
    String lastName();
}
