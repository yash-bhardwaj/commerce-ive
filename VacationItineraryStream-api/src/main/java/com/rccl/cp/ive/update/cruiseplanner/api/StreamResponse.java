package com.rccl.cp.ive.update.cruiseplanner.api;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableStreamResponse.class)
@JsonDeserialize(as = ImmutableStreamResponse.class)
public interface StreamResponse {
    int code();
    String message();
    String streamStatusCode();
    String statusStatusMessage();
    long count();
}
