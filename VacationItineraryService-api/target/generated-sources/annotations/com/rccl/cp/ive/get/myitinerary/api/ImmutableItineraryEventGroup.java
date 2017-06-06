package com.rccl.cp.ive.get.myitinerary.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ItineraryEventGroup}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableItineraryEventGroup.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ItineraryEventGroup"})
@Immutable
public final class ImmutableItineraryEventGroup
    implements ItineraryEventGroup {
  private final String eventGroupType;
  private final String eventGroupDescription;
  private final ImmutableList<ItineraryEventForDisplay> itineraryEvents;

  private ImmutableItineraryEventGroup(
      String eventGroupType,
      String eventGroupDescription,
      ImmutableList<ItineraryEventForDisplay> itineraryEvents) {
    this.eventGroupType = eventGroupType;
    this.eventGroupDescription = eventGroupDescription;
    this.itineraryEvents = itineraryEvents;
  }

  /**
   * @return The value of the {@code eventGroupType} attribute
   */
  @JsonProperty("eventGroupType")
  @Override
  public String eventGroupType() {
    return eventGroupType;
  }

  /**
   * @return The value of the {@code eventGroupDescription} attribute
   */
  @JsonProperty("eventGroupDescription")
  @Override
  public String eventGroupDescription() {
    return eventGroupDescription;
  }

  /**
   * @return The value of the {@code itineraryEvents} attribute
   */
  @JsonProperty("itineraryEvents")
  @Override
  public ImmutableList<ItineraryEventForDisplay> itineraryEvents() {
    return itineraryEvents;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEventGroup#eventGroupType() eventGroupType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventGroupType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEventGroup withEventGroupType(String value) {
    if (this.eventGroupType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventGroupType");
    return new ImmutableItineraryEventGroup(newValue, this.eventGroupDescription, this.itineraryEvents);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEventGroup#eventGroupDescription() eventGroupDescription} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventGroupDescription
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEventGroup withEventGroupDescription(String value) {
    if (this.eventGroupDescription.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventGroupDescription");
    return new ImmutableItineraryEventGroup(this.eventGroupType, newValue, this.itineraryEvents);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ItineraryEventGroup#itineraryEvents() itineraryEvents}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItineraryEventGroup withItineraryEvents(ItineraryEventForDisplay... elements) {
    ImmutableList<ItineraryEventForDisplay> newValue = ImmutableList.copyOf(elements);
    return new ImmutableItineraryEventGroup(this.eventGroupType, this.eventGroupDescription, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ItineraryEventGroup#itineraryEvents() itineraryEvents}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of itineraryEvents elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItineraryEventGroup withItineraryEvents(Iterable<? extends ItineraryEventForDisplay> elements) {
    if (this.itineraryEvents == elements) return this;
    ImmutableList<ItineraryEventForDisplay> newValue = ImmutableList.copyOf(elements);
    return new ImmutableItineraryEventGroup(this.eventGroupType, this.eventGroupDescription, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableItineraryEventGroup} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableItineraryEventGroup
        && equalTo((ImmutableItineraryEventGroup) another);
  }

  private boolean equalTo(ImmutableItineraryEventGroup another) {
    return eventGroupType.equals(another.eventGroupType)
        && eventGroupDescription.equals(another.eventGroupDescription)
        && itineraryEvents.equals(another.itineraryEvents);
  }

  /**
   * Computes a hash code from attributes: {@code eventGroupType}, {@code eventGroupDescription}, {@code itineraryEvents}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + eventGroupType.hashCode();
    h += (h << 5) + eventGroupDescription.hashCode();
    h += (h << 5) + itineraryEvents.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ItineraryEventGroup} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ItineraryEventGroup")
        .omitNullValues()
        .add("eventGroupType", eventGroupType)
        .add("eventGroupDescription", eventGroupDescription)
        .add("itineraryEvents", itineraryEvents)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ItineraryEventGroup {
    @Nullable String eventGroupType;
    @Nullable String eventGroupDescription;
    List<ItineraryEventForDisplay> itineraryEvents = ImmutableList.of();
    @JsonProperty("eventGroupType")
    public void setEventGroupType(String eventGroupType) {
      this.eventGroupType = eventGroupType;
    }
    @JsonProperty("eventGroupDescription")
    public void setEventGroupDescription(String eventGroupDescription) {
      this.eventGroupDescription = eventGroupDescription;
    }
    @JsonProperty("itineraryEvents")
    public void setItineraryEvents(List<ItineraryEventForDisplay> itineraryEvents) {
      this.itineraryEvents = itineraryEvents;
    }
    @Override
    public String eventGroupType() { throw new UnsupportedOperationException(); }
    @Override
    public String eventGroupDescription() { throw new UnsupportedOperationException(); }
    @Override
    public List<ItineraryEventForDisplay> itineraryEvents() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableItineraryEventGroup fromJson(Json json) {
    ImmutableItineraryEventGroup.Builder builder = ImmutableItineraryEventGroup.builder();
    if (json.eventGroupType != null) {
      builder.eventGroupType(json.eventGroupType);
    }
    if (json.eventGroupDescription != null) {
      builder.eventGroupDescription(json.eventGroupDescription);
    }
    if (json.itineraryEvents != null) {
      builder.addAllItineraryEvents(json.itineraryEvents);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ItineraryEventGroup} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ItineraryEventGroup instance
   */
  public static ImmutableItineraryEventGroup copyOf(ItineraryEventGroup instance) {
    if (instance instanceof ImmutableItineraryEventGroup) {
      return (ImmutableItineraryEventGroup) instance;
    }
    return ImmutableItineraryEventGroup.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableItineraryEventGroup ImmutableItineraryEventGroup}.
   * @return A new ImmutableItineraryEventGroup builder
   */
  public static ImmutableItineraryEventGroup.Builder builder() {
    return new ImmutableItineraryEventGroup.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableItineraryEventGroup ImmutableItineraryEventGroup}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_EVENT_GROUP_TYPE = 0x1L;
    private static final long INIT_BIT_EVENT_GROUP_DESCRIPTION = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String eventGroupType;
    private @Nullable String eventGroupDescription;
    private ImmutableList.Builder<ItineraryEventForDisplay> itineraryEvents = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ItineraryEventGroup} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ItineraryEventGroup instance) {
      Preconditions.checkNotNull(instance, "instance");
      eventGroupType(instance.eventGroupType());
      eventGroupDescription(instance.eventGroupDescription());
      addAllItineraryEvents(instance.itineraryEvents());
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEventGroup#eventGroupType() eventGroupType} attribute.
     * @param eventGroupType The value for eventGroupType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventGroupType")
    public final Builder eventGroupType(String eventGroupType) {
      this.eventGroupType = Preconditions.checkNotNull(eventGroupType, "eventGroupType");
      initBits &= ~INIT_BIT_EVENT_GROUP_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEventGroup#eventGroupDescription() eventGroupDescription} attribute.
     * @param eventGroupDescription The value for eventGroupDescription 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventGroupDescription")
    public final Builder eventGroupDescription(String eventGroupDescription) {
      this.eventGroupDescription = Preconditions.checkNotNull(eventGroupDescription, "eventGroupDescription");
      initBits &= ~INIT_BIT_EVENT_GROUP_DESCRIPTION;
      return this;
    }

    /**
     * Adds one element to {@link ItineraryEventGroup#itineraryEvents() itineraryEvents} list.
     * @param element A itineraryEvents element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addItineraryEvents(ItineraryEventForDisplay element) {
      this.itineraryEvents.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ItineraryEventGroup#itineraryEvents() itineraryEvents} list.
     * @param elements An array of itineraryEvents elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addItineraryEvents(ItineraryEventForDisplay... elements) {
      this.itineraryEvents.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ItineraryEventGroup#itineraryEvents() itineraryEvents} list.
     * @param elements An iterable of itineraryEvents elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("itineraryEvents")
    public final Builder itineraryEvents(Iterable<? extends ItineraryEventForDisplay> elements) {
      this.itineraryEvents = ImmutableList.builder();
      return addAllItineraryEvents(elements);
    }

    /**
     * Adds elements to {@link ItineraryEventGroup#itineraryEvents() itineraryEvents} list.
     * @param elements An iterable of itineraryEvents elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllItineraryEvents(Iterable<? extends ItineraryEventForDisplay> elements) {
      this.itineraryEvents.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableItineraryEventGroup ImmutableItineraryEventGroup}.
     * @return An immutable instance of ItineraryEventGroup
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableItineraryEventGroup build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableItineraryEventGroup(eventGroupType, eventGroupDescription, itineraryEvents.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_EVENT_GROUP_TYPE) != 0) attributes.add("eventGroupType");
      if ((initBits & INIT_BIT_EVENT_GROUP_DESCRIPTION) != 0) attributes.add("eventGroupDescription");
      return "Cannot build ItineraryEventGroup, some of required attributes are not set " + attributes;
    }
  }
}
