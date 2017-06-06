package com.rccl.cp.ive.get.myitinerary.api;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableItineraryEventGroup.class)
@JsonDeserialize(as = ImmutableItineraryEventGroup.class)
public interface ItineraryEventGroup {
    String eventGroupType();
    String eventGroupDescription();
    List<ItineraryEventForDisplay> itineraryEvents();
}
