package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.rccl.cp.ive.update.common.EventAttendee;
import com.rccl.cp.ive.update.common.EventLocation;
import com.rccl.cp.ive.update.common.EventSourceDetail;
import com.rccl.cp.ive.update.common.EventTime;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CruisePlannerEventState}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCruisePlannerEventState.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "CruisePlannerEventState"})
@Immutable
public final class ImmutableCruisePlannerEventState
    implements CruisePlannerEventState {
  private final boolean isDeleted;
  private final String shipSailDate;
  private final String cruiseBookingID;
  private final String guestID;
  private final String eventType;
  private final @Nullable String eventLocale;
  private final @Nullable String eventName;
  private final EventLocation eventLocation;
  private final EventTime eventStartTime;
  private final EventTime eventEndTime;
  private final @Nullable EventSourceDetail sourceDetail;
  private final ImmutableList<EventAttendee> attendees;

  private ImmutableCruisePlannerEventState(ImmutableCruisePlannerEventState.Builder builder) {
    this.shipSailDate = builder.shipSailDate;
    this.cruiseBookingID = builder.cruiseBookingID;
    this.guestID = builder.guestID;
    this.eventType = builder.eventType;
    this.eventLocale = builder.eventLocale;
    this.eventName = builder.eventName;
    this.eventLocation = builder.eventLocation;
    this.eventStartTime = builder.eventStartTime;
    this.eventEndTime = builder.eventEndTime;
    this.sourceDetail = builder.sourceDetail;
    this.attendees = builder.attendees.build();
    this.isDeleted = builder.isDeletedIsSet()
        ? builder.isDeleted
        : CruisePlannerEventState.super.isDeleted();
  }

  private ImmutableCruisePlannerEventState(
      boolean isDeleted,
      String shipSailDate,
      String cruiseBookingID,
      String guestID,
      String eventType,
      @Nullable String eventLocale,
      @Nullable String eventName,
      EventLocation eventLocation,
      EventTime eventStartTime,
      EventTime eventEndTime,
      @Nullable EventSourceDetail sourceDetail,
      ImmutableList<EventAttendee> attendees) {
    this.isDeleted = isDeleted;
    this.shipSailDate = shipSailDate;
    this.cruiseBookingID = cruiseBookingID;
    this.guestID = guestID;
    this.eventType = eventType;
    this.eventLocale = eventLocale;
    this.eventName = eventName;
    this.eventLocation = eventLocation;
    this.eventStartTime = eventStartTime;
    this.eventEndTime = eventEndTime;
    this.sourceDetail = sourceDetail;
    this.attendees = attendees;
  }

  /**
   * @return The value of the {@code isDeleted} attribute
   */
  @JsonProperty("isDeleted")
  @Override
  public boolean isDeleted() {
    return isDeleted;
  }

  /**
   * @return The value of the {@code shipSailDate} attribute
   */
  @JsonProperty("shipSailDate")
  @Override
  public String shipSailDate() {
    return shipSailDate;
  }

  /**
   * @return The value of the {@code cruiseBookingID} attribute
   */
  @JsonProperty("cruiseBookingID")
  @Override
  public String cruiseBookingID() {
    return cruiseBookingID;
  }

  /**
   * @return The value of the {@code guestID} attribute
   */
  @JsonProperty("guestID")
  @Override
  public String guestID() {
    return guestID;
  }

  /**
   * @return The value of the {@code eventType} attribute
   */
  @JsonProperty("eventType")
  @Override
  public String eventType() {
    return eventType;
  }

  /**
   * @return The value of the {@code eventLocale} attribute
   */
  @JsonProperty("eventLocale")
  @Override
  public Optional<String> eventLocale() {
    return Optional.ofNullable(eventLocale);
  }

  /**
   * @return The value of the {@code eventName} attribute
   */
  @JsonProperty("eventName")
  @Override
  public Optional<String> eventName() {
    return Optional.ofNullable(eventName);
  }

  /**
   * @return The value of the {@code eventLocation} attribute
   */
  @JsonProperty("eventLocation")
  @Override
  public EventLocation eventLocation() {
    return eventLocation;
  }

  /**
   * @return The value of the {@code eventStartTime} attribute
   */
  @JsonProperty("eventStartTime")
  @Override
  public EventTime eventStartTime() {
    return eventStartTime;
  }

  /**
   * @return The value of the {@code eventEndTime} attribute
   */
  @JsonProperty("eventEndTime")
  @Override
  public EventTime eventEndTime() {
    return eventEndTime;
  }

  /**
   * @return The value of the {@code sourceDetail} attribute
   */
  @JsonProperty("sourceDetail")
  @Override
  public Optional<EventSourceDetail> sourceDetail() {
    return Optional.ofNullable(sourceDetail);
  }

  /**
   * @return The value of the {@code attendees} attribute
   */
  @JsonProperty("attendees")
  @Override
  public ImmutableList<EventAttendee> attendees() {
    return attendees;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#isDeleted() isDeleted} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for isDeleted
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withIsDeleted(boolean value) {
    if (this.isDeleted == value) return this;
    return new ImmutableCruisePlannerEventState(
        value,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#shipSailDate() shipSailDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shipSailDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withShipSailDate(String value) {
    if (this.shipSailDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "shipSailDate");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        newValue,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#cruiseBookingID() cruiseBookingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for cruiseBookingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withCruiseBookingID(String value) {
    if (this.cruiseBookingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "cruiseBookingID");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        newValue,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#guestID() guestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withGuestID(String value) {
    if (this.guestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        newValue,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#eventType() eventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventType(String value) {
    if (this.eventType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventType");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        newValue,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruisePlannerEventState#eventLocale() eventLocale} attribute.
   * @param value The value for eventLocale
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventLocale(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "eventLocale");
    if (Objects.equal(this.eventLocale, newValue)) return this;
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        newValue,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CruisePlannerEventState#eventLocale() eventLocale} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for eventLocale
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventLocale(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.eventLocale, value)) return this;
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        value,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruisePlannerEventState#eventName() eventName} attribute.
   * @param value The value for eventName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "eventName");
    if (Objects.equal(this.eventName, newValue)) return this;
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        newValue,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CruisePlannerEventState#eventName() eventName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for eventName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.eventName, value)) return this;
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        value,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#eventLocation() eventLocation} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventLocation
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventLocation(EventLocation value) {
    if (this.eventLocation == value) return this;
    EventLocation newValue = Preconditions.checkNotNull(value, "eventLocation");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        newValue,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#eventStartTime() eventStartTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventStartTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventStartTime(EventTime value) {
    if (this.eventStartTime == value) return this;
    EventTime newValue = Preconditions.checkNotNull(value, "eventStartTime");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        newValue,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventState#eventEndTime() eventEndTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventEndTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventState withEventEndTime(EventTime value) {
    if (this.eventEndTime == value) return this;
    EventTime newValue = Preconditions.checkNotNull(value, "eventEndTime");
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        newValue,
        this.sourceDetail,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruisePlannerEventState#sourceDetail() sourceDetail} attribute.
   * @param value The value for sourceDetail
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withSourceDetail(EventSourceDetail value) {
    @Nullable EventSourceDetail newValue = Preconditions.checkNotNull(value, "sourceDetail");
    if (this.sourceDetail == newValue) return this;
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        newValue,
        this.attendees);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CruisePlannerEventState#sourceDetail() sourceDetail} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceDetail
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withSourceDetail(Optional<? extends EventSourceDetail> optional) {
    @Nullable EventSourceDetail value = optional.orElse(null);
    if (this.sourceDetail == value) return this;
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        value,
        this.attendees);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link CruisePlannerEventState#attendees() attendees}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withAttendees(EventAttendee... elements) {
    ImmutableList<EventAttendee> newValue = ImmutableList.copyOf(elements);
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link CruisePlannerEventState#attendees() attendees}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of attendees elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventState withAttendees(Iterable<? extends EventAttendee> elements) {
    if (this.attendees == elements) return this;
    ImmutableList<EventAttendee> newValue = ImmutableList.copyOf(elements);
    return new ImmutableCruisePlannerEventState(
        this.isDeleted,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCruisePlannerEventState} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCruisePlannerEventState
        && equalTo((ImmutableCruisePlannerEventState) another);
  }

  private boolean equalTo(ImmutableCruisePlannerEventState another) {
    return isDeleted == another.isDeleted
        && shipSailDate.equals(another.shipSailDate)
        && cruiseBookingID.equals(another.cruiseBookingID)
        && guestID.equals(another.guestID)
        && eventType.equals(another.eventType)
        && Objects.equal(eventLocale, another.eventLocale)
        && Objects.equal(eventName, another.eventName)
        && eventLocation.equals(another.eventLocation)
        && eventStartTime.equals(another.eventStartTime)
        && eventEndTime.equals(another.eventEndTime)
        && Objects.equal(sourceDetail, another.sourceDetail)
        && attendees.equals(another.attendees);
  }

  /**
   * Computes a hash code from attributes: {@code isDeleted}, {@code shipSailDate}, {@code cruiseBookingID}, {@code guestID}, {@code eventType}, {@code eventLocale}, {@code eventName}, {@code eventLocation}, {@code eventStartTime}, {@code eventEndTime}, {@code sourceDetail}, {@code attendees}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Booleans.hashCode(isDeleted);
    h += (h << 5) + shipSailDate.hashCode();
    h += (h << 5) + cruiseBookingID.hashCode();
    h += (h << 5) + guestID.hashCode();
    h += (h << 5) + eventType.hashCode();
    h += (h << 5) + Objects.hashCode(eventLocale);
    h += (h << 5) + Objects.hashCode(eventName);
    h += (h << 5) + eventLocation.hashCode();
    h += (h << 5) + eventStartTime.hashCode();
    h += (h << 5) + eventEndTime.hashCode();
    h += (h << 5) + Objects.hashCode(sourceDetail);
    h += (h << 5) + attendees.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CruisePlannerEventState} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CruisePlannerEventState")
        .omitNullValues()
        .add("isDeleted", isDeleted)
        .add("shipSailDate", shipSailDate)
        .add("cruiseBookingID", cruiseBookingID)
        .add("guestID", guestID)
        .add("eventType", eventType)
        .add("eventLocale", eventLocale)
        .add("eventName", eventName)
        .add("eventLocation", eventLocation)
        .add("eventStartTime", eventStartTime)
        .add("eventEndTime", eventEndTime)
        .add("sourceDetail", sourceDetail)
        .add("attendees", attendees)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements CruisePlannerEventState {
    boolean isDeleted;
    boolean isDeletedIsSet;
    @Nullable String shipSailDate;
    @Nullable String cruiseBookingID;
    @Nullable String guestID;
    @Nullable String eventType;
    Optional<String> eventLocale = Optional.empty();
    Optional<String> eventName = Optional.empty();
    @Nullable EventLocation eventLocation;
    @Nullable EventTime eventStartTime;
    @Nullable EventTime eventEndTime;
    Optional<EventSourceDetail> sourceDetail = Optional.empty();
    List<EventAttendee> attendees = ImmutableList.of();
    @JsonProperty("isDeleted")
    public void setIsDeleted(boolean isDeleted) {
      this.isDeleted = isDeleted;
      this.isDeletedIsSet = true;
    }
    @JsonProperty("shipSailDate")
    public void setShipSailDate(String shipSailDate) {
      this.shipSailDate = shipSailDate;
    }
    @JsonProperty("cruiseBookingID")
    public void setCruiseBookingID(String cruiseBookingID) {
      this.cruiseBookingID = cruiseBookingID;
    }
    @JsonProperty("guestID")
    public void setGuestID(String guestID) {
      this.guestID = guestID;
    }
    @JsonProperty("eventType")
    public void setEventType(String eventType) {
      this.eventType = eventType;
    }
    @JsonProperty("eventLocale")
    public void setEventLocale(Optional<String> eventLocale) {
      this.eventLocale = eventLocale;
    }
    @JsonProperty("eventName")
    public void setEventName(Optional<String> eventName) {
      this.eventName = eventName;
    }
    @JsonProperty("eventLocation")
    public void setEventLocation(EventLocation eventLocation) {
      this.eventLocation = eventLocation;
    }
    @JsonProperty("eventStartTime")
    public void setEventStartTime(EventTime eventStartTime) {
      this.eventStartTime = eventStartTime;
    }
    @JsonProperty("eventEndTime")
    public void setEventEndTime(EventTime eventEndTime) {
      this.eventEndTime = eventEndTime;
    }
    @JsonProperty("sourceDetail")
    public void setSourceDetail(Optional<EventSourceDetail> sourceDetail) {
      this.sourceDetail = sourceDetail;
    }
    @JsonProperty("attendees")
    public void setAttendees(List<EventAttendee> attendees) {
      this.attendees = attendees;
    }
    @Override
    public boolean isDeleted() { throw new UnsupportedOperationException(); }
    @Override
    public String shipSailDate() { throw new UnsupportedOperationException(); }
    @Override
    public String cruiseBookingID() { throw new UnsupportedOperationException(); }
    @Override
    public String guestID() { throw new UnsupportedOperationException(); }
    @Override
    public String eventType() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> eventLocale() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> eventName() { throw new UnsupportedOperationException(); }
    @Override
    public EventLocation eventLocation() { throw new UnsupportedOperationException(); }
    @Override
    public EventTime eventStartTime() { throw new UnsupportedOperationException(); }
    @Override
    public EventTime eventEndTime() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<EventSourceDetail> sourceDetail() { throw new UnsupportedOperationException(); }
    @Override
    public List<EventAttendee> attendees() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCruisePlannerEventState fromJson(Json json) {
    ImmutableCruisePlannerEventState.Builder builder = ImmutableCruisePlannerEventState.builder();
    if (json.isDeletedIsSet) {
      builder.isDeleted(json.isDeleted);
    }
    if (json.shipSailDate != null) {
      builder.shipSailDate(json.shipSailDate);
    }
    if (json.cruiseBookingID != null) {
      builder.cruiseBookingID(json.cruiseBookingID);
    }
    if (json.guestID != null) {
      builder.guestID(json.guestID);
    }
    if (json.eventType != null) {
      builder.eventType(json.eventType);
    }
    if (json.eventLocale != null) {
      builder.eventLocale(json.eventLocale);
    }
    if (json.eventName != null) {
      builder.eventName(json.eventName);
    }
    if (json.eventLocation != null) {
      builder.eventLocation(json.eventLocation);
    }
    if (json.eventStartTime != null) {
      builder.eventStartTime(json.eventStartTime);
    }
    if (json.eventEndTime != null) {
      builder.eventEndTime(json.eventEndTime);
    }
    if (json.sourceDetail != null) {
      builder.sourceDetail(json.sourceDetail);
    }
    if (json.attendees != null) {
      builder.addAllAttendees(json.attendees);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CruisePlannerEventState} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CruisePlannerEventState instance
   */
  public static ImmutableCruisePlannerEventState copyOf(CruisePlannerEventState instance) {
    if (instance instanceof ImmutableCruisePlannerEventState) {
      return (ImmutableCruisePlannerEventState) instance;
    }
    return ImmutableCruisePlannerEventState.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCruisePlannerEventState ImmutableCruisePlannerEventState}.
   * @return A new ImmutableCruisePlannerEventState builder
   */
  public static ImmutableCruisePlannerEventState.Builder builder() {
    return new ImmutableCruisePlannerEventState.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCruisePlannerEventState ImmutableCruisePlannerEventState}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SHIP_SAIL_DATE = 0x1L;
    private static final long INIT_BIT_CRUISE_BOOKING_I_D = 0x2L;
    private static final long INIT_BIT_GUEST_I_D = 0x4L;
    private static final long INIT_BIT_EVENT_TYPE = 0x8L;
    private static final long INIT_BIT_EVENT_LOCATION = 0x10L;
    private static final long INIT_BIT_EVENT_START_TIME = 0x20L;
    private static final long INIT_BIT_EVENT_END_TIME = 0x40L;
    private static final long OPT_BIT_IS_DELETED = 0x1L;
    private long initBits = 0x7fL;
    private long optBits;

    private boolean isDeleted;
    private @Nullable String shipSailDate;
    private @Nullable String cruiseBookingID;
    private @Nullable String guestID;
    private @Nullable String eventType;
    private @Nullable String eventLocale;
    private @Nullable String eventName;
    private @Nullable EventLocation eventLocation;
    private @Nullable EventTime eventStartTime;
    private @Nullable EventTime eventEndTime;
    private @Nullable EventSourceDetail sourceDetail;
    private ImmutableList.Builder<EventAttendee> attendees = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CruisePlannerEventState} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruisePlannerEventState instance) {
      Preconditions.checkNotNull(instance, "instance");
      isDeleted(instance.isDeleted());
      shipSailDate(instance.shipSailDate());
      cruiseBookingID(instance.cruiseBookingID());
      guestID(instance.guestID());
      eventType(instance.eventType());
      Optional<String> eventLocaleOptional = instance.eventLocale();
      if (eventLocaleOptional.isPresent()) {
        eventLocale(eventLocaleOptional);
      }
      Optional<String> eventNameOptional = instance.eventName();
      if (eventNameOptional.isPresent()) {
        eventName(eventNameOptional);
      }
      eventLocation(instance.eventLocation());
      eventStartTime(instance.eventStartTime());
      eventEndTime(instance.eventEndTime());
      Optional<EventSourceDetail> sourceDetailOptional = instance.sourceDetail();
      if (sourceDetailOptional.isPresent()) {
        sourceDetail(sourceDetailOptional);
      }
      addAllAttendees(instance.attendees());
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#isDeleted() isDeleted} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link CruisePlannerEventState#isDeleted() isDeleted}.</em>
     * @param isDeleted The value for isDeleted 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("isDeleted")
    public final Builder isDeleted(boolean isDeleted) {
      this.isDeleted = isDeleted;
      optBits |= OPT_BIT_IS_DELETED;
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#shipSailDate() shipSailDate} attribute.
     * @param shipSailDate The value for shipSailDate 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("shipSailDate")
    public final Builder shipSailDate(String shipSailDate) {
      this.shipSailDate = Preconditions.checkNotNull(shipSailDate, "shipSailDate");
      initBits &= ~INIT_BIT_SHIP_SAIL_DATE;
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#cruiseBookingID() cruiseBookingID} attribute.
     * @param cruiseBookingID The value for cruiseBookingID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("cruiseBookingID")
    public final Builder cruiseBookingID(String cruiseBookingID) {
      this.cruiseBookingID = Preconditions.checkNotNull(cruiseBookingID, "cruiseBookingID");
      initBits &= ~INIT_BIT_CRUISE_BOOKING_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#guestID() guestID} attribute.
     * @param guestID The value for guestID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("guestID")
    public final Builder guestID(String guestID) {
      this.guestID = Preconditions.checkNotNull(guestID, "guestID");
      initBits &= ~INIT_BIT_GUEST_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#eventType() eventType} attribute.
     * @param eventType The value for eventType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventType")
    public final Builder eventType(String eventType) {
      this.eventType = Preconditions.checkNotNull(eventType, "eventType");
      initBits &= ~INIT_BIT_EVENT_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventState#eventLocale() eventLocale} to eventLocale.
     * @param eventLocale The value for eventLocale
     * @return {@code this} builder for chained invocation
     */
    public final Builder eventLocale(String eventLocale) {
      this.eventLocale = Preconditions.checkNotNull(eventLocale, "eventLocale");
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventState#eventLocale() eventLocale} to eventLocale.
     * @param eventLocale The value for eventLocale
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventLocale")
    public final Builder eventLocale(Optional<String> eventLocale) {
      this.eventLocale = eventLocale.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventState#eventName() eventName} to eventName.
     * @param eventName The value for eventName
     * @return {@code this} builder for chained invocation
     */
    public final Builder eventName(String eventName) {
      this.eventName = Preconditions.checkNotNull(eventName, "eventName");
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventState#eventName() eventName} to eventName.
     * @param eventName The value for eventName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventName")
    public final Builder eventName(Optional<String> eventName) {
      this.eventName = eventName.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#eventLocation() eventLocation} attribute.
     * @param eventLocation The value for eventLocation 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventLocation")
    public final Builder eventLocation(EventLocation eventLocation) {
      this.eventLocation = Preconditions.checkNotNull(eventLocation, "eventLocation");
      initBits &= ~INIT_BIT_EVENT_LOCATION;
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#eventStartTime() eventStartTime} attribute.
     * @param eventStartTime The value for eventStartTime 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventStartTime")
    public final Builder eventStartTime(EventTime eventStartTime) {
      this.eventStartTime = Preconditions.checkNotNull(eventStartTime, "eventStartTime");
      initBits &= ~INIT_BIT_EVENT_START_TIME;
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventState#eventEndTime() eventEndTime} attribute.
     * @param eventEndTime The value for eventEndTime 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventEndTime")
    public final Builder eventEndTime(EventTime eventEndTime) {
      this.eventEndTime = Preconditions.checkNotNull(eventEndTime, "eventEndTime");
      initBits &= ~INIT_BIT_EVENT_END_TIME;
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventState#sourceDetail() sourceDetail} to sourceDetail.
     * @param sourceDetail The value for sourceDetail
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceDetail(EventSourceDetail sourceDetail) {
      this.sourceDetail = Preconditions.checkNotNull(sourceDetail, "sourceDetail");
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventState#sourceDetail() sourceDetail} to sourceDetail.
     * @param sourceDetail The value for sourceDetail
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceDetail")
    public final Builder sourceDetail(Optional<? extends EventSourceDetail> sourceDetail) {
      this.sourceDetail = sourceDetail.orElse(null);
      return this;
    }

    /**
     * Adds one element to {@link CruisePlannerEventState#attendees() attendees} list.
     * @param element A attendees element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAttendees(EventAttendee element) {
      this.attendees.add(element);
      return this;
    }

    /**
     * Adds elements to {@link CruisePlannerEventState#attendees() attendees} list.
     * @param elements An array of attendees elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAttendees(EventAttendee... elements) {
      this.attendees.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link CruisePlannerEventState#attendees() attendees} list.
     * @param elements An iterable of attendees elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("attendees")
    public final Builder attendees(Iterable<? extends EventAttendee> elements) {
      this.attendees = ImmutableList.builder();
      return addAllAttendees(elements);
    }

    /**
     * Adds elements to {@link CruisePlannerEventState#attendees() attendees} list.
     * @param elements An iterable of attendees elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllAttendees(Iterable<? extends EventAttendee> elements) {
      this.attendees.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCruisePlannerEventState ImmutableCruisePlannerEventState}.
     * @return An immutable instance of CruisePlannerEventState
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCruisePlannerEventState build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCruisePlannerEventState(this);
    }

    private boolean isDeletedIsSet() {
      return (optBits & OPT_BIT_IS_DELETED) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_SHIP_SAIL_DATE) != 0) attributes.add("shipSailDate");
      if ((initBits & INIT_BIT_CRUISE_BOOKING_I_D) != 0) attributes.add("cruiseBookingID");
      if ((initBits & INIT_BIT_GUEST_I_D) != 0) attributes.add("guestID");
      if ((initBits & INIT_BIT_EVENT_TYPE) != 0) attributes.add("eventType");
      if ((initBits & INIT_BIT_EVENT_LOCATION) != 0) attributes.add("eventLocation");
      if ((initBits & INIT_BIT_EVENT_START_TIME) != 0) attributes.add("eventStartTime");
      if ((initBits & INIT_BIT_EVENT_END_TIME) != 0) attributes.add("eventEndTime");
      return "Cannot build CruisePlannerEventState, some of required attributes are not set " + attributes;
    }
  }
}
