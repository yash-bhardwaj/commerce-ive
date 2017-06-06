package com.rccl.cp.ive.get.myitinerary.api;

import java.math.BigInteger;
import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableMyItinerary.class)
@JsonDeserialize(as = ImmutableMyItinerary.class)
public interface MyItinerary {
    BigInteger cruiseReservationID();
    BigInteger guestID();
    String sailingID();
    String firstName();
    String lastName();
    List<ItineraryEventGroup> itineraryEventGroups();
}
