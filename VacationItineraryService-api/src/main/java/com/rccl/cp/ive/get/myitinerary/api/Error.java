package com.rccl.cp.ive.get.myitinerary.api;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableError.class)
@JsonDeserialize(as = ImmutableError.class)
@SuppressWarnings("NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION")
public interface Error {
    Integer code();
    String message();
    String fields();
}
