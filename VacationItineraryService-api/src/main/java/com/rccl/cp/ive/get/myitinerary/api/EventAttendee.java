package com.rccl.cp.ive.get.myitinerary.api;

import java.math.BigInteger;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableEventAttendee.class)
@JsonDeserialize(as = ImmutableEventAttendee.class)
public interface EventAttendee {
    BigInteger cruiseReservationID();
    BigInteger guestID();
    String sailingID();
    String firstName();
    String lastName();
}
