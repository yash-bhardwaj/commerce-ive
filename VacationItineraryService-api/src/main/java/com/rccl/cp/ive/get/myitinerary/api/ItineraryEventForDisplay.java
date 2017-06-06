package com.rccl.cp.ive.get.myitinerary.api;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableItineraryEventForDisplay.class)
@JsonDeserialize(as = ImmutableItineraryEventForDisplay.class)
public interface ItineraryEventForDisplay {
    String eventType();
    String eventName();
    String eventLocale();
    String eventOwnerGuestID();
    EventLocation eventLocation();
    EventTime eventStartTime();
    EventTime eventEndTime();
    EventSourceDetail sourceDetail();
    List<EventAttendee> attendees();
    List<ItineraryLink> links();
}
