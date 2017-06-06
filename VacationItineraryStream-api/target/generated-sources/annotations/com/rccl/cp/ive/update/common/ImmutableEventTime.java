package com.rccl.cp.ive.update.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link EventTime}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEventTime.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "EventTime"})
@Immutable
public final class ImmutableEventTime implements EventTime {
  private final String eventDate;
  private final String eventTime;
  private final @Nullable String eventTimeZone;

  private ImmutableEventTime(
      String eventDate,
      String eventTime,
      @Nullable String eventTimeZone) {
    this.eventDate = eventDate;
    this.eventTime = eventTime;
    this.eventTimeZone = eventTimeZone;
  }

  /**
   * @return The value of the {@code eventDate} attribute
   */
  @JsonProperty("eventDate")
  @Override
  public String eventDate() {
    return eventDate;
  }

  /**
   * @return The value of the {@code eventTime} attribute
   */
  @JsonProperty("eventTime")
  @Override
  public String eventTime() {
    return eventTime;
  }

  /**
   * @return The value of the {@code eventTimeZone} attribute
   */
  @JsonProperty("eventTimeZone")
  @Override
  public Optional<String> eventTimeZone() {
    return Optional.ofNullable(eventTimeZone);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventTime#eventDate() eventDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventTime withEventDate(String value) {
    if (this.eventDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventDate");
    return new ImmutableEventTime(newValue, this.eventTime, this.eventTimeZone);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventTime#eventTime() eventTime} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventTime withEventTime(String value) {
    if (this.eventTime.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventTime");
    return new ImmutableEventTime(this.eventDate, newValue, this.eventTimeZone);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link EventTime#eventTimeZone() eventTimeZone} attribute.
   * @param value The value for eventTimeZone
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventTime withEventTimeZone(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "eventTimeZone");
    if (Objects.equal(this.eventTimeZone, newValue)) return this;
    return new ImmutableEventTime(this.eventDate, this.eventTime, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link EventTime#eventTimeZone() eventTimeZone} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for eventTimeZone
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventTime withEventTimeZone(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.eventTimeZone, value)) return this;
    return new ImmutableEventTime(this.eventDate, this.eventTime, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEventTime} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEventTime
        && equalTo((ImmutableEventTime) another);
  }

  private boolean equalTo(ImmutableEventTime another) {
    return eventDate.equals(another.eventDate)
        && eventTime.equals(another.eventTime)
        && Objects.equal(eventTimeZone, another.eventTimeZone);
  }

  /**
   * Computes a hash code from attributes: {@code eventDate}, {@code eventTime}, {@code eventTimeZone}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + eventDate.hashCode();
    h += (h << 5) + eventTime.hashCode();
    h += (h << 5) + Objects.hashCode(eventTimeZone);
    return h;
  }

  /**
   * Prints the immutable value {@code EventTime} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("EventTime")
        .omitNullValues()
        .add("eventDate", eventDate)
        .add("eventTime", eventTime)
        .add("eventTimeZone", eventTimeZone)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements EventTime {
    @Nullable String eventDate;
    @Nullable String eventTime;
    Optional<String> eventTimeZone = Optional.empty();
    @JsonProperty("eventDate")
    public void setEventDate(String eventDate) {
      this.eventDate = eventDate;
    }
    @JsonProperty("eventTime")
    public void setEventTime(String eventTime) {
      this.eventTime = eventTime;
    }
    @JsonProperty("eventTimeZone")
    public void setEventTimeZone(Optional<String> eventTimeZone) {
      this.eventTimeZone = eventTimeZone;
    }
    @Override
    public String eventDate() { throw new UnsupportedOperationException(); }
    @Override
    public String eventTime() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> eventTimeZone() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEventTime fromJson(Json json) {
    ImmutableEventTime.Builder builder = ImmutableEventTime.builder();
    if (json.eventDate != null) {
      builder.eventDate(json.eventDate);
    }
    if (json.eventTime != null) {
      builder.eventTime(json.eventTime);
    }
    if (json.eventTimeZone != null) {
      builder.eventTimeZone(json.eventTimeZone);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EventTime} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EventTime instance
   */
  public static ImmutableEventTime copyOf(EventTime instance) {
    if (instance instanceof ImmutableEventTime) {
      return (ImmutableEventTime) instance;
    }
    return ImmutableEventTime.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEventTime ImmutableEventTime}.
   * @return A new ImmutableEventTime builder
   */
  public static ImmutableEventTime.Builder builder() {
    return new ImmutableEventTime.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEventTime ImmutableEventTime}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_EVENT_DATE = 0x1L;
    private static final long INIT_BIT_EVENT_TIME = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String eventDate;
    private @Nullable String eventTime;
    private @Nullable String eventTimeZone;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EventTime} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EventTime instance) {
      Preconditions.checkNotNull(instance, "instance");
      eventDate(instance.eventDate());
      eventTime(instance.eventTime());
      Optional<String> eventTimeZoneOptional = instance.eventTimeZone();
      if (eventTimeZoneOptional.isPresent()) {
        eventTimeZone(eventTimeZoneOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link EventTime#eventDate() eventDate} attribute.
     * @param eventDate The value for eventDate 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventDate")
    public final Builder eventDate(String eventDate) {
      this.eventDate = Preconditions.checkNotNull(eventDate, "eventDate");
      initBits &= ~INIT_BIT_EVENT_DATE;
      return this;
    }

    /**
     * Initializes the value for the {@link EventTime#eventTime() eventTime} attribute.
     * @param eventTime The value for eventTime 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventTime")
    public final Builder eventTime(String eventTime) {
      this.eventTime = Preconditions.checkNotNull(eventTime, "eventTime");
      initBits &= ~INIT_BIT_EVENT_TIME;
      return this;
    }

    /**
     * Initializes the optional value {@link EventTime#eventTimeZone() eventTimeZone} to eventTimeZone.
     * @param eventTimeZone The value for eventTimeZone
     * @return {@code this} builder for chained invocation
     */
    public final Builder eventTimeZone(String eventTimeZone) {
      this.eventTimeZone = Preconditions.checkNotNull(eventTimeZone, "eventTimeZone");
      return this;
    }

    /**
     * Initializes the optional value {@link EventTime#eventTimeZone() eventTimeZone} to eventTimeZone.
     * @param eventTimeZone The value for eventTimeZone
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventTimeZone")
    public final Builder eventTimeZone(Optional<String> eventTimeZone) {
      this.eventTimeZone = eventTimeZone.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableEventTime ImmutableEventTime}.
     * @return An immutable instance of EventTime
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEventTime build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEventTime(eventDate, eventTime, eventTimeZone);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_EVENT_DATE) != 0) attributes.add("eventDate");
      if ((initBits & INIT_BIT_EVENT_TIME) != 0) attributes.add("eventTime");
      return "Cannot build EventTime, some of required attributes are not set " + attributes;
    }
  }
}
