package com.rccl.cp.ive.get.myitinerary.api;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableItineraryEvent.class)
@JsonDeserialize(as = ImmutableItineraryEvent.class)
public interface ItineraryEvent {
    String eventType();
    String eventName();
    String eventLocale();
    String firstName();
    String lastName();
    String eventOwnerGuestID();
    String eventGroupType();
    String eventGroupDescription();
    EventLocation eventLocation();
    EventTime eventStartTime();
    EventTime eventEndTime();
    EventSourceDetail sourceDetail();
    List<EventAttendee> attendees();
    List<ItineraryLink> links();
}
