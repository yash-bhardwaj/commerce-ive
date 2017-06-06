package com.rccl.cp.ive.update.cruisecompass.api.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CruiseCompassEventEvent.CruiseCompassEventUpdated}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCruiseCompassEventUpdated.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "CruiseCompassEventEvent.CruiseCompassEventUpdated"})
@Immutable
public final class ImmutableCruiseCompassEventUpdated
    implements CruiseCompassEventEvent.CruiseCompassEventUpdated {
  private final @Nullable CruiseCompassEventMessage message;

  private ImmutableCruiseCompassEventUpdated(
      @Nullable CruiseCompassEventMessage message) {
    this.message = message;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("message")
  @Override
  public Optional<CruiseCompassEventMessage> message() {
    return Optional.ofNullable(message);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventEvent.CruiseCompassEventUpdated#message() message} attribute.
   * @param value The value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventUpdated withMessage(CruiseCompassEventMessage value) {
    @Nullable CruiseCompassEventMessage newValue = Preconditions.checkNotNull(value, "message");
    if (this.message == newValue) return this;
    return new ImmutableCruiseCompassEventUpdated(newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventEvent.CruiseCompassEventUpdated#message() message} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventUpdated withMessage(Optional<? extends CruiseCompassEventMessage> optional) {
    @Nullable CruiseCompassEventMessage value = optional.orElse(null);
    if (this.message == value) return this;
    return new ImmutableCruiseCompassEventUpdated(value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCruiseCompassEventUpdated} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCruiseCompassEventUpdated
        && equalTo((ImmutableCruiseCompassEventUpdated) another);
  }

  private boolean equalTo(ImmutableCruiseCompassEventUpdated another) {
    return Objects.equal(message, another.message);
  }

  /**
   * Computes a hash code from attributes: {@code message}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(message);
    return h;
  }

  /**
   * Prints the immutable value {@code CruiseCompassEventUpdated} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CruiseCompassEventUpdated")
        .omitNullValues()
        .add("message", message)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements CruiseCompassEventEvent.CruiseCompassEventUpdated {
    Optional<CruiseCompassEventMessage> message = Optional.empty();
    @JsonProperty("message")
    public void setMessage(Optional<CruiseCompassEventMessage> message) {
      this.message = message;
    }
    @Override
    public Optional<CruiseCompassEventMessage> message() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCruiseCompassEventUpdated fromJson(Json json) {
    ImmutableCruiseCompassEventUpdated.Builder builder = ImmutableCruiseCompassEventUpdated.builder();
    if (json.message != null) {
      builder.message(json.message);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CruiseCompassEventEvent.CruiseCompassEventUpdated} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CruiseCompassEventUpdated instance
   */
  public static ImmutableCruiseCompassEventUpdated copyOf(CruiseCompassEventEvent.CruiseCompassEventUpdated instance) {
    if (instance instanceof ImmutableCruiseCompassEventUpdated) {
      return (ImmutableCruiseCompassEventUpdated) instance;
    }
    return ImmutableCruiseCompassEventUpdated.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCruiseCompassEventUpdated ImmutableCruiseCompassEventUpdated}.
   * @return A new ImmutableCruiseCompassEventUpdated builder
   */
  public static ImmutableCruiseCompassEventUpdated.Builder builder() {
    return new ImmutableCruiseCompassEventUpdated.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCruiseCompassEventUpdated ImmutableCruiseCompassEventUpdated}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable CruiseCompassEventMessage message;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.cruisecompass.api.impl.CruiseCompassEventEvent} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruiseCompassEventEvent instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.cruisecompass.api.impl.CruiseCompassEventEvent.CruiseCompassEventUpdated} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruiseCompassEventEvent.CruiseCompassEventUpdated instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof CruiseCompassEventEvent) {
        CruiseCompassEventEvent instance = (CruiseCompassEventEvent) object;
        Optional<CruiseCompassEventMessage> messageOptional = instance.message();
        if (messageOptional.isPresent()) {
          message(messageOptional);
        }
      }
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventEvent.CruiseCompassEventUpdated#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for chained invocation
     */
    public final Builder message(CruiseCompassEventMessage message) {
      this.message = Preconditions.checkNotNull(message, "message");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventEvent.CruiseCompassEventUpdated#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("message")
    public final Builder message(Optional<? extends CruiseCompassEventMessage> message) {
      this.message = message.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCruiseCompassEventUpdated ImmutableCruiseCompassEventUpdated}.
     * @return An immutable instance of CruiseCompassEventUpdated
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCruiseCompassEventUpdated build() {
      return new ImmutableCruiseCompassEventUpdated(message);
    }
  }
}
