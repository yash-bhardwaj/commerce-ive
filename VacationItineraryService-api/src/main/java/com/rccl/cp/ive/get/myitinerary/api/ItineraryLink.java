package com.rccl.cp.ive.get.myitinerary.api;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableItineraryLink.class)
@JsonDeserialize(as = ImmutableItineraryLink.class)
public interface ItineraryLink {
    String rel();
    String href();
}
