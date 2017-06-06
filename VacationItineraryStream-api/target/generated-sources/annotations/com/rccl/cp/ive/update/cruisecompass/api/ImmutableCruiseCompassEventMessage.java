package com.rccl.cp.ive.update.cruisecompass.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.rccl.cp.ive.update.common.BasicMessage;
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
 * Immutable implementation of {@link CruiseCompassEventMessage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCruiseCompassEventMessage.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "CruiseCompassEventMessage"})
@Immutable
public final class ImmutableCruiseCompassEventMessage
    implements CruiseCompassEventMessage {
  private final @Nullable String method;
  private final String shipSailDate;
  private final String cruiseBookingID;
  private final String guestID;
  private final @Nullable String firstName;
  private final @Nullable String lastName;
  private final String eventGroupType;
  private final String eventGroupDescription;
  private final String eventType;
  private final @Nullable String eventLocale;
  private final @Nullable String eventName;
  private final EventLocation eventLocation;
  private final EventTime eventStartTime;
  private final EventTime eventEndTime;
  private final EventSourceDetail sourceDetail;
  private final @Nullable List<EventAttendee> attendees;

  private ImmutableCruiseCompassEventMessage(
      @Nullable String method,
      String shipSailDate,
      String cruiseBookingID,
      String guestID,
      @Nullable String firstName,
      @Nullable String lastName,
      String eventGroupType,
      String eventGroupDescription,
      String eventType,
      @Nullable String eventLocale,
      @Nullable String eventName,
      EventLocation eventLocation,
      EventTime eventStartTime,
      EventTime eventEndTime,
      EventSourceDetail sourceDetail,
      @Nullable List<EventAttendee> attendees) {
    this.method = method;
    this.shipSailDate = shipSailDate;
    this.cruiseBookingID = cruiseBookingID;
    this.guestID = guestID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.eventGroupType = eventGroupType;
    this.eventGroupDescription = eventGroupDescription;
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
   * @return The value of the {@code method} attribute
   */
  @JsonProperty("method")
  @Override
  public Optional<String> method() {
    return Optional.ofNullable(method);
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
   * @return The value of the {@code firstName} attribute
   */
  @JsonProperty("firstName")
  @Override
  public Optional<String> firstName() {
    return Optional.ofNullable(firstName);
  }

  /**
   * @return The value of the {@code lastName} attribute
   */
  @JsonProperty("lastName")
  @Override
  public Optional<String> lastName() {
    return Optional.ofNullable(lastName);
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
  public EventSourceDetail sourceDetail() {
    return sourceDetail;
  }

  /**
   * @return The value of the {@code attendees} attribute
   */
  @JsonProperty("attendees")
  @Override
  public Optional<List<EventAttendee>> attendees() {
    return Optional.ofNullable(attendees);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventMessage#method() method} attribute.
   * @param value The value for method
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withMethod(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "method");
    if (Objects.equal(this.method, newValue)) return this;
    return new ImmutableCruiseCompassEventMessage(
        newValue,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventMessage#method() method} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for method
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withMethod(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.method, value)) return this;
    return new ImmutableCruiseCompassEventMessage(
        value,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#shipSailDate() shipSailDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shipSailDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withShipSailDate(String value) {
    if (this.shipSailDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "shipSailDate");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        newValue,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#cruiseBookingID() cruiseBookingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for cruiseBookingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withCruiseBookingID(String value) {
    if (this.cruiseBookingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "cruiseBookingID");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        newValue,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#guestID() guestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withGuestID(String value) {
    if (this.guestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        newValue,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventMessage#firstName() firstName} attribute.
   * @param value The value for firstName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withFirstName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "firstName");
    if (Objects.equal(this.firstName, newValue)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        newValue,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventMessage#firstName() firstName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for firstName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withFirstName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.firstName, value)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        value,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventMessage#lastName() lastName} attribute.
   * @param value The value for lastName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withLastName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "lastName");
    if (Objects.equal(this.lastName, newValue)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        newValue,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventMessage#lastName() lastName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for lastName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withLastName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.lastName, value)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        value,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#eventGroupType() eventGroupType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventGroupType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventGroupType(String value) {
    if (this.eventGroupType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventGroupType");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        newValue,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#eventGroupDescription() eventGroupDescription} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventGroupDescription
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventGroupDescription(String value) {
    if (this.eventGroupDescription.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventGroupDescription");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#eventType() eventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventType(String value) {
    if (this.eventType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventType");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventMessage#eventLocale() eventLocale} attribute.
   * @param value The value for eventLocale
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventLocale(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "eventLocale");
    if (Objects.equal(this.eventLocale, newValue)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventMessage#eventLocale() eventLocale} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for eventLocale
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventLocale(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.eventLocale, value)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventMessage#eventName() eventName} attribute.
   * @param value The value for eventName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "eventName");
    if (Objects.equal(this.eventName, newValue)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventMessage#eventName() eventName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for eventName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.eventName, value)) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#eventLocation() eventLocation} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventLocation
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventLocation(EventLocation value) {
    if (this.eventLocation == value) return this;
    EventLocation newValue = Preconditions.checkNotNull(value, "eventLocation");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#eventStartTime() eventStartTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventStartTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventStartTime(EventTime value) {
    if (this.eventStartTime == value) return this;
    EventTime newValue = Preconditions.checkNotNull(value, "eventStartTime");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#eventEndTime() eventEndTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventEndTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withEventEndTime(EventTime value) {
    if (this.eventEndTime == value) return this;
    EventTime newValue = Preconditions.checkNotNull(value, "eventEndTime");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventMessage#sourceDetail() sourceDetail} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceDetail
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withSourceDetail(EventSourceDetail value) {
    if (this.sourceDetail == value) return this;
    EventSourceDetail newValue = Preconditions.checkNotNull(value, "sourceDetail");
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruiseCompassEventMessage#attendees() attendees} attribute.
   * @param value The value for attendees
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withAttendees(List<EventAttendee> value) {
    @Nullable List<EventAttendee> newValue = Preconditions.checkNotNull(value, "attendees");
    if (this.attendees == newValue) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
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
   * Copy the current immutable object by setting an optional value for the {@link CruiseCompassEventMessage#attendees() attendees} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for attendees
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruiseCompassEventMessage withAttendees(Optional<? extends List<EventAttendee>> optional) {
    @Nullable List<EventAttendee> value = optional.orElse(null);
    if (this.attendees == value) return this;
    return new ImmutableCruiseCompassEventMessage(
        this.method,
        this.shipSailDate,
        this.cruiseBookingID,
        this.guestID,
        this.firstName,
        this.lastName,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventType,
        this.eventLocale,
        this.eventName,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCruiseCompassEventMessage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCruiseCompassEventMessage
        && equalTo((ImmutableCruiseCompassEventMessage) another);
  }

  private boolean equalTo(ImmutableCruiseCompassEventMessage another) {
    return Objects.equal(method, another.method)
        && shipSailDate.equals(another.shipSailDate)
        && cruiseBookingID.equals(another.cruiseBookingID)
        && guestID.equals(another.guestID)
        && Objects.equal(firstName, another.firstName)
        && Objects.equal(lastName, another.lastName)
        && eventGroupType.equals(another.eventGroupType)
        && eventGroupDescription.equals(another.eventGroupDescription)
        && eventType.equals(another.eventType)
        && Objects.equal(eventLocale, another.eventLocale)
        && Objects.equal(eventName, another.eventName)
        && eventLocation.equals(another.eventLocation)
        && eventStartTime.equals(another.eventStartTime)
        && eventEndTime.equals(another.eventEndTime)
        && sourceDetail.equals(another.sourceDetail)
        && Objects.equal(attendees, another.attendees);
  }

  /**
   * Computes a hash code from attributes: {@code method}, {@code shipSailDate}, {@code cruiseBookingID}, {@code guestID}, {@code firstName}, {@code lastName}, {@code eventGroupType}, {@code eventGroupDescription}, {@code eventType}, {@code eventLocale}, {@code eventName}, {@code eventLocation}, {@code eventStartTime}, {@code eventEndTime}, {@code sourceDetail}, {@code attendees}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(method);
    h += (h << 5) + shipSailDate.hashCode();
    h += (h << 5) + cruiseBookingID.hashCode();
    h += (h << 5) + guestID.hashCode();
    h += (h << 5) + Objects.hashCode(firstName);
    h += (h << 5) + Objects.hashCode(lastName);
    h += (h << 5) + eventGroupType.hashCode();
    h += (h << 5) + eventGroupDescription.hashCode();
    h += (h << 5) + eventType.hashCode();
    h += (h << 5) + Objects.hashCode(eventLocale);
    h += (h << 5) + Objects.hashCode(eventName);
    h += (h << 5) + eventLocation.hashCode();
    h += (h << 5) + eventStartTime.hashCode();
    h += (h << 5) + eventEndTime.hashCode();
    h += (h << 5) + sourceDetail.hashCode();
    h += (h << 5) + Objects.hashCode(attendees);
    return h;
  }

  /**
   * Prints the immutable value {@code CruiseCompassEventMessage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CruiseCompassEventMessage")
        .omitNullValues()
        .add("method", method)
        .add("shipSailDate", shipSailDate)
        .add("cruiseBookingID", cruiseBookingID)
        .add("guestID", guestID)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .add("eventGroupType", eventGroupType)
        .add("eventGroupDescription", eventGroupDescription)
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
  static final class Json implements CruiseCompassEventMessage {
    Optional<String> method = Optional.empty();
    @Nullable String shipSailDate;
    @Nullable String cruiseBookingID;
    @Nullable String guestID;
    Optional<String> firstName = Optional.empty();
    Optional<String> lastName = Optional.empty();
    @Nullable String eventGroupType;
    @Nullable String eventGroupDescription;
    @Nullable String eventType;
    Optional<String> eventLocale = Optional.empty();
    Optional<String> eventName = Optional.empty();
    @Nullable EventLocation eventLocation;
    @Nullable EventTime eventStartTime;
    @Nullable EventTime eventEndTime;
    @Nullable EventSourceDetail sourceDetail;
    Optional<List<EventAttendee>> attendees = Optional.empty();
    @JsonProperty("method")
    public void setMethod(Optional<String> method) {
      this.method = method;
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
    @JsonProperty("firstName")
    public void setFirstName(Optional<String> firstName) {
      this.firstName = firstName;
    }
    @JsonProperty("lastName")
    public void setLastName(Optional<String> lastName) {
      this.lastName = lastName;
    }
    @JsonProperty("eventGroupType")
    public void setEventGroupType(String eventGroupType) {
      this.eventGroupType = eventGroupType;
    }
    @JsonProperty("eventGroupDescription")
    public void setEventGroupDescription(String eventGroupDescription) {
      this.eventGroupDescription = eventGroupDescription;
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
    public void setSourceDetail(EventSourceDetail sourceDetail) {
      this.sourceDetail = sourceDetail;
    }
    @JsonProperty("attendees")
    public void setAttendees(Optional<List<EventAttendee>> attendees) {
      this.attendees = attendees;
    }
    @Override
    public Optional<String> method() { throw new UnsupportedOperationException(); }
    @Override
    public String shipSailDate() { throw new UnsupportedOperationException(); }
    @Override
    public String cruiseBookingID() { throw new UnsupportedOperationException(); }
    @Override
    public String guestID() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> firstName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> lastName() { throw new UnsupportedOperationException(); }
    @Override
    public String eventGroupType() { throw new UnsupportedOperationException(); }
    @Override
    public String eventGroupDescription() { throw new UnsupportedOperationException(); }
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
    public EventSourceDetail sourceDetail() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<List<EventAttendee>> attendees() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCruiseCompassEventMessage fromJson(Json json) {
    ImmutableCruiseCompassEventMessage.Builder builder = ImmutableCruiseCompassEventMessage.builder();
    if (json.method != null) {
      builder.method(json.method);
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
    if (json.firstName != null) {
      builder.firstName(json.firstName);
    }
    if (json.lastName != null) {
      builder.lastName(json.lastName);
    }
    if (json.eventGroupType != null) {
      builder.eventGroupType(json.eventGroupType);
    }
    if (json.eventGroupDescription != null) {
      builder.eventGroupDescription(json.eventGroupDescription);
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
      builder.attendees(json.attendees);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CruiseCompassEventMessage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CruiseCompassEventMessage instance
   */
  public static ImmutableCruiseCompassEventMessage copyOf(CruiseCompassEventMessage instance) {
    if (instance instanceof ImmutableCruiseCompassEventMessage) {
      return (ImmutableCruiseCompassEventMessage) instance;
    }
    return ImmutableCruiseCompassEventMessage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCruiseCompassEventMessage ImmutableCruiseCompassEventMessage}.
   * @return A new ImmutableCruiseCompassEventMessage builder
   */
  public static ImmutableCruiseCompassEventMessage.Builder builder() {
    return new ImmutableCruiseCompassEventMessage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCruiseCompassEventMessage ImmutableCruiseCompassEventMessage}.
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
    private static final long INIT_BIT_EVENT_GROUP_TYPE = 0x8L;
    private static final long INIT_BIT_EVENT_GROUP_DESCRIPTION = 0x10L;
    private static final long INIT_BIT_EVENT_TYPE = 0x20L;
    private static final long INIT_BIT_EVENT_LOCATION = 0x40L;
    private static final long INIT_BIT_EVENT_START_TIME = 0x80L;
    private static final long INIT_BIT_EVENT_END_TIME = 0x100L;
    private static final long INIT_BIT_SOURCE_DETAIL = 0x200L;
    private long initBits = 0x3ffL;

    private @Nullable String method;
    private @Nullable String shipSailDate;
    private @Nullable String cruiseBookingID;
    private @Nullable String guestID;
    private @Nullable String firstName;
    private @Nullable String lastName;
    private @Nullable String eventGroupType;
    private @Nullable String eventGroupDescription;
    private @Nullable String eventType;
    private @Nullable String eventLocale;
    private @Nullable String eventName;
    private @Nullable EventLocation eventLocation;
    private @Nullable EventTime eventStartTime;
    private @Nullable EventTime eventEndTime;
    private @Nullable EventSourceDetail sourceDetail;
    private @Nullable List<EventAttendee> attendees;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.common.BasicMessage} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(BasicMessage instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruiseCompassEventMessage instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      long bits = 0;
      if (object instanceof BasicMessage) {
        BasicMessage instance = (BasicMessage) object;
        if ((bits & 0x1L) == 0) {
          cruiseBookingID(instance.cruiseBookingID());
          bits |= 0x1L;
        }
        if ((bits & 0x2L) == 0) {
          Optional<String> lastNameOptional = instance.lastName();
          if (lastNameOptional.isPresent()) {
            lastName(lastNameOptional);
          }
          bits |= 0x2L;
        }
        if ((bits & 0x4L) == 0) {
          Optional<String> methodOptional = instance.method();
          if (methodOptional.isPresent()) {
            method(methodOptional);
          }
          bits |= 0x4L;
        }
        if ((bits & 0x8L) == 0) {
          eventLocation(instance.eventLocation());
          bits |= 0x8L;
        }
        if ((bits & 0x10L) == 0) {
          Optional<List<EventAttendee>> attendeesOptional = instance.attendees();
          if (attendeesOptional.isPresent()) {
            attendees(attendeesOptional);
          }
          bits |= 0x10L;
        }
        if ((bits & 0x20L) == 0) {
          eventGroupDescription(instance.eventGroupDescription());
          bits |= 0x20L;
        }
        if ((bits & 0x40L) == 0) {
          eventGroupType(instance.eventGroupType());
          bits |= 0x40L;
        }
        if ((bits & 0x80L) == 0) {
          eventType(instance.eventType());
          bits |= 0x80L;
        }
        if ((bits & 0x100L) == 0) {
          Optional<String> firstNameOptional = instance.firstName();
          if (firstNameOptional.isPresent()) {
            firstName(firstNameOptional);
          }
          bits |= 0x100L;
        }
        if ((bits & 0x200L) == 0) {
          sourceDetail(instance.sourceDetail());
          bits |= 0x200L;
        }
        if ((bits & 0x400L) == 0) {
          Optional<String> eventLocaleOptional = instance.eventLocale();
          if (eventLocaleOptional.isPresent()) {
            eventLocale(eventLocaleOptional);
          }
          bits |= 0x400L;
        }
        if ((bits & 0x800L) == 0) {
          shipSailDate(instance.shipSailDate());
          bits |= 0x800L;
        }
        if ((bits & 0x1000L) == 0) {
          eventEndTime(instance.eventEndTime());
          bits |= 0x1000L;
        }
        if ((bits & 0x2000L) == 0) {
          Optional<String> eventNameOptional = instance.eventName();
          if (eventNameOptional.isPresent()) {
            eventName(eventNameOptional);
          }
          bits |= 0x2000L;
        }
        if ((bits & 0x4000L) == 0) {
          eventStartTime(instance.eventStartTime());
          bits |= 0x4000L;
        }
        if ((bits & 0x8000L) == 0) {
          guestID(instance.guestID());
          bits |= 0x8000L;
        }
      }
      if (object instanceof CruiseCompassEventMessage) {
        CruiseCompassEventMessage instance = (CruiseCompassEventMessage) object;
        if ((bits & 0x1L) == 0) {
          cruiseBookingID(instance.cruiseBookingID());
          bits |= 0x1L;
        }
        if ((bits & 0x2L) == 0) {
          Optional<String> lastNameOptional = instance.lastName();
          if (lastNameOptional.isPresent()) {
            lastName(lastNameOptional);
          }
          bits |= 0x2L;
        }
        if ((bits & 0x4L) == 0) {
          Optional<String> methodOptional = instance.method();
          if (methodOptional.isPresent()) {
            method(methodOptional);
          }
          bits |= 0x4L;
        }
        if ((bits & 0x8L) == 0) {
          eventLocation(instance.eventLocation());
          bits |= 0x8L;
        }
        if ((bits & 0x10L) == 0) {
          Optional<List<EventAttendee>> attendeesOptional = instance.attendees();
          if (attendeesOptional.isPresent()) {
            attendees(attendeesOptional);
          }
          bits |= 0x10L;
        }
        if ((bits & 0x20L) == 0) {
          eventGroupDescription(instance.eventGroupDescription());
          bits |= 0x20L;
        }
        if ((bits & 0x40L) == 0) {
          eventGroupType(instance.eventGroupType());
          bits |= 0x40L;
        }
        if ((bits & 0x80L) == 0) {
          eventType(instance.eventType());
          bits |= 0x80L;
        }
        if ((bits & 0x100L) == 0) {
          Optional<String> firstNameOptional = instance.firstName();
          if (firstNameOptional.isPresent()) {
            firstName(firstNameOptional);
          }
          bits |= 0x100L;
        }
        if ((bits & 0x200L) == 0) {
          sourceDetail(instance.sourceDetail());
          bits |= 0x200L;
        }
        if ((bits & 0x400L) == 0) {
          Optional<String> eventLocaleOptional = instance.eventLocale();
          if (eventLocaleOptional.isPresent()) {
            eventLocale(eventLocaleOptional);
          }
          bits |= 0x400L;
        }
        if ((bits & 0x800L) == 0) {
          shipSailDate(instance.shipSailDate());
          bits |= 0x800L;
        }
        if ((bits & 0x1000L) == 0) {
          eventEndTime(instance.eventEndTime());
          bits |= 0x1000L;
        }
        if ((bits & 0x2000L) == 0) {
          Optional<String> eventNameOptional = instance.eventName();
          if (eventNameOptional.isPresent()) {
            eventName(eventNameOptional);
          }
          bits |= 0x2000L;
        }
        if ((bits & 0x4000L) == 0) {
          eventStartTime(instance.eventStartTime());
          bits |= 0x4000L;
        }
        if ((bits & 0x8000L) == 0) {
          guestID(instance.guestID());
          bits |= 0x8000L;
        }
      }
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#method() method} to method.
     * @param method The value for method
     * @return {@code this} builder for chained invocation
     */
    public final Builder method(String method) {
      this.method = Preconditions.checkNotNull(method, "method");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#method() method} to method.
     * @param method The value for method
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("method")
    public final Builder method(Optional<String> method) {
      this.method = method.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventMessage#shipSailDate() shipSailDate} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#cruiseBookingID() cruiseBookingID} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#guestID() guestID} attribute.
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
     * Initializes the optional value {@link CruiseCompassEventMessage#firstName() firstName} to firstName.
     * @param firstName The value for firstName
     * @return {@code this} builder for chained invocation
     */
    public final Builder firstName(String firstName) {
      this.firstName = Preconditions.checkNotNull(firstName, "firstName");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#firstName() firstName} to firstName.
     * @param firstName The value for firstName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("firstName")
    public final Builder firstName(Optional<String> firstName) {
      this.firstName = firstName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#lastName() lastName} to lastName.
     * @param lastName The value for lastName
     * @return {@code this} builder for chained invocation
     */
    public final Builder lastName(String lastName) {
      this.lastName = Preconditions.checkNotNull(lastName, "lastName");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#lastName() lastName} to lastName.
     * @param lastName The value for lastName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("lastName")
    public final Builder lastName(Optional<String> lastName) {
      this.lastName = lastName.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventMessage#eventGroupType() eventGroupType} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#eventGroupDescription() eventGroupDescription} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#eventType() eventType} attribute.
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
     * Initializes the optional value {@link CruiseCompassEventMessage#eventLocale() eventLocale} to eventLocale.
     * @param eventLocale The value for eventLocale
     * @return {@code this} builder for chained invocation
     */
    public final Builder eventLocale(String eventLocale) {
      this.eventLocale = Preconditions.checkNotNull(eventLocale, "eventLocale");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#eventLocale() eventLocale} to eventLocale.
     * @param eventLocale The value for eventLocale
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventLocale")
    public final Builder eventLocale(Optional<String> eventLocale) {
      this.eventLocale = eventLocale.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#eventName() eventName} to eventName.
     * @param eventName The value for eventName
     * @return {@code this} builder for chained invocation
     */
    public final Builder eventName(String eventName) {
      this.eventName = Preconditions.checkNotNull(eventName, "eventName");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#eventName() eventName} to eventName.
     * @param eventName The value for eventName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventName")
    public final Builder eventName(Optional<String> eventName) {
      this.eventName = eventName.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventMessage#eventLocation() eventLocation} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#eventStartTime() eventStartTime} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#eventEndTime() eventEndTime} attribute.
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
     * Initializes the value for the {@link CruiseCompassEventMessage#sourceDetail() sourceDetail} attribute.
     * @param sourceDetail The value for sourceDetail 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceDetail")
    public final Builder sourceDetail(EventSourceDetail sourceDetail) {
      this.sourceDetail = Preconditions.checkNotNull(sourceDetail, "sourceDetail");
      initBits &= ~INIT_BIT_SOURCE_DETAIL;
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#attendees() attendees} to attendees.
     * @param attendees The value for attendees
     * @return {@code this} builder for chained invocation
     */
    public final Builder attendees(List<EventAttendee> attendees) {
      this.attendees = Preconditions.checkNotNull(attendees, "attendees");
      return this;
    }

    /**
     * Initializes the optional value {@link CruiseCompassEventMessage#attendees() attendees} to attendees.
     * @param attendees The value for attendees
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("attendees")
    public final Builder attendees(Optional<? extends List<EventAttendee>> attendees) {
      this.attendees = attendees.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCruiseCompassEventMessage ImmutableCruiseCompassEventMessage}.
     * @return An immutable instance of CruiseCompassEventMessage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCruiseCompassEventMessage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCruiseCompassEventMessage(
          method,
          shipSailDate,
          cruiseBookingID,
          guestID,
          firstName,
          lastName,
          eventGroupType,
          eventGroupDescription,
          eventType,
          eventLocale,
          eventName,
          eventLocation,
          eventStartTime,
          eventEndTime,
          sourceDetail,
          attendees);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_SHIP_SAIL_DATE) != 0) attributes.add("shipSailDate");
      if ((initBits & INIT_BIT_CRUISE_BOOKING_I_D) != 0) attributes.add("cruiseBookingID");
      if ((initBits & INIT_BIT_GUEST_I_D) != 0) attributes.add("guestID");
      if ((initBits & INIT_BIT_EVENT_GROUP_TYPE) != 0) attributes.add("eventGroupType");
      if ((initBits & INIT_BIT_EVENT_GROUP_DESCRIPTION) != 0) attributes.add("eventGroupDescription");
      if ((initBits & INIT_BIT_EVENT_TYPE) != 0) attributes.add("eventType");
      if ((initBits & INIT_BIT_EVENT_LOCATION) != 0) attributes.add("eventLocation");
      if ((initBits & INIT_BIT_EVENT_START_TIME) != 0) attributes.add("eventStartTime");
      if ((initBits & INIT_BIT_EVENT_END_TIME) != 0) attributes.add("eventEndTime");
      if ((initBits & INIT_BIT_SOURCE_DETAIL) != 0) attributes.add("sourceDetail");
      return "Cannot build CruiseCompassEventMessage, some of required attributes are not set " + attributes;
    }
  }
}
