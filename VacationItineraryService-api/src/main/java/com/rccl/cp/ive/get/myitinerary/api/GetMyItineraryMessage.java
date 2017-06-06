package com.rccl.cp.ive.get.myitinerary.api;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableGetMyItineraryMessage.class)
@JsonDeserialize(as = ImmutableGetMyItineraryMessage.class)
public interface GetMyItineraryMessage {
    String shipSailDate();
    String cruiseBookingID();
    String guestID();
}
