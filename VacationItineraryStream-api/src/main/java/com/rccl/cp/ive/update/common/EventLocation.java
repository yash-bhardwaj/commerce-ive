package com.rccl.cp.ive.update.common;

import java.util.Optional;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableEventLocation.class)
@JsonDeserialize(as = ImmutableEventLocation.class)
public interface EventLocation {
    String locationCode();
    String locationType();
    Optional<String> locationName();
}
