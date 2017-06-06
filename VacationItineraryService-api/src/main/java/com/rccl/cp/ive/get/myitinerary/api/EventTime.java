package com.rccl.cp.ive.get.myitinerary.api;

import java.util.Optional;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableEventTime.class)
@JsonDeserialize(as = ImmutableEventTime.class)
public interface EventTime {
    String eventDate();
    String eventTime();
    Optional<String> eventTimeZone();
}
