package com.rccl.cp.ive.update.dining.api.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link DiningEventEvent.DiningEventUpdated}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDiningEventUpdated.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "DiningEventEvent.DiningEventUpdated"})
@Immutable
public final class ImmutableDiningEventUpdated
    implements DiningEventEvent.DiningEventUpdated {
  private final @Nullable DiningEventMessage message;

  private ImmutableDiningEventUpdated(@Nullable DiningEventMessage message) {
    this.message = message;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("message")
  @Override
  public Optional<DiningEventMessage> message() {
    return Optional.ofNullable(message);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link DiningEventEvent.DiningEventUpdated#message() message} attribute.
   * @param value The value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDiningEventUpdated withMessage(DiningEventMessage value) {
    @Nullable DiningEventMessage newValue = Preconditions.checkNotNull(value, "message");
    if (this.message == newValue) return this;
    return new ImmutableDiningEventUpdated(newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link DiningEventEvent.DiningEventUpdated#message() message} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDiningEventUpdated withMessage(Optional<? extends DiningEventMessage> optional) {
    @Nullable DiningEventMessage value = optional.orElse(null);
    if (this.message == value) return this;
    return new ImmutableDiningEventUpdated(value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDiningEventUpdated} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDiningEventUpdated
        && equalTo((ImmutableDiningEventUpdated) another);
  }

  private boolean equalTo(ImmutableDiningEventUpdated another) {
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
   * Prints the immutable value {@code DiningEventUpdated} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("DiningEventUpdated")
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
      implements DiningEventEvent.DiningEventUpdated {
    Optional<DiningEventMessage> message = Optional.empty();
    @JsonProperty("message")
    public void setMessage(Optional<DiningEventMessage> message) {
      this.message = message;
    }
    @Override
    public Optional<DiningEventMessage> message() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableDiningEventUpdated fromJson(Json json) {
    ImmutableDiningEventUpdated.Builder builder = ImmutableDiningEventUpdated.builder();
    if (json.message != null) {
      builder.message(json.message);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DiningEventEvent.DiningEventUpdated} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DiningEventUpdated instance
   */
  public static ImmutableDiningEventUpdated copyOf(DiningEventEvent.DiningEventUpdated instance) {
    if (instance instanceof ImmutableDiningEventUpdated) {
      return (ImmutableDiningEventUpdated) instance;
    }
    return ImmutableDiningEventUpdated.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDiningEventUpdated ImmutableDiningEventUpdated}.
   * @return A new ImmutableDiningEventUpdated builder
   */
  public static ImmutableDiningEventUpdated.Builder builder() {
    return new ImmutableDiningEventUpdated.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDiningEventUpdated ImmutableDiningEventUpdated}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable DiningEventMessage message;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.dining.api.impl.DiningEventEvent} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DiningEventEvent instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.dining.api.impl.DiningEventEvent.DiningEventUpdated} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DiningEventEvent.DiningEventUpdated instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof DiningEventEvent) {
        DiningEventEvent instance = (DiningEventEvent) object;
        Optional<DiningEventMessage> messageOptional = instance.message();
        if (messageOptional.isPresent()) {
          message(messageOptional);
        }
      }
    }

    /**
     * Initializes the optional value {@link DiningEventEvent.DiningEventUpdated#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for chained invocation
     */
    public final Builder message(DiningEventMessage message) {
      this.message = Preconditions.checkNotNull(message, "message");
      return this;
    }

    /**
     * Initializes the optional value {@link DiningEventEvent.DiningEventUpdated#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("message")
    public final Builder message(Optional<? extends DiningEventMessage> message) {
      this.message = message.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableDiningEventUpdated ImmutableDiningEventUpdated}.
     * @return An immutable instance of DiningEventUpdated
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDiningEventUpdated build() {
      return new ImmutableDiningEventUpdated(message);
    }
  }
}
