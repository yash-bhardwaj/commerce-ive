package com.rccl.cp.ive.update.common;

import java.util.Optional;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableEventSourceDetail.class)
@JsonDeserialize(as = ImmutableEventSourceDetail.class)
public interface EventSourceDetail {
    String sourceSystemReservationID();
    String sourceSystemApplicationID();
    String sourceSystemOfferingID();
    Optional<String> sourceSystemOrderID();
    Optional<String> sourceSystemExternalOrderID();
    Optional<String> sourceSystemProductID();
    Optional<String> sourceSystemProductName();
}
