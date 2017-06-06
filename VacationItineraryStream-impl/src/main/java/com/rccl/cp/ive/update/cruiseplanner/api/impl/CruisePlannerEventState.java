package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import java.util.List;
import java.util.Optional;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lightbend.lagom.serialization.CompressedJsonable;
import com.rccl.cp.ive.update.common.EventAttendee;
import com.rccl.cp.ive.update.common.EventLocation;
import com.rccl.cp.ive.update.common.EventSourceDetail;
import com.rccl.cp.ive.update.common.EventTime;

@Value.Immutable
@JsonSerialize(as = ImmutableCruisePlannerEventState.class)
@JsonDeserialize(as = ImmutableCruisePlannerEventState.class)
public interface CruisePlannerEventState extends CompressedJsonable {
    @Value.Default
    default boolean isDeleted() {
        return false;
    }
    String shipSailDate();
    String cruiseBookingID();
    String guestID();
    String eventType();
    Optional<String> eventLocale();
    Optional<String> eventName();
    EventLocation eventLocation();
    EventTime eventStartTime();
    EventTime eventEndTime();
    Optional<EventSourceDetail> sourceDetail();
    List<EventAttendee> attendees();
}
