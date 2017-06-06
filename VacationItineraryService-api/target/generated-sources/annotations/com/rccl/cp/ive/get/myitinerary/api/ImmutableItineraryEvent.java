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
 * Immutable implementation of {@link ItineraryEvent}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableItineraryEvent.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ItineraryEvent"})
@Immutable
public final class ImmutableItineraryEvent implements ItineraryEvent {
  private final String eventType;
  private final String eventName;
  private final String eventLocale;
  private final String firstName;
  private final String lastName;
  private final String eventOwnerGuestID;
  private final String eventGroupType;
  private final String eventGroupDescription;
  private final EventLocation eventLocation;
  private final EventTime eventStartTime;
  private final EventTime eventEndTime;
  private final EventSourceDetail sourceDetail;
  private final ImmutableList<EventAttendee> attendees;
  private final ImmutableList<ItineraryLink> links;

  private ImmutableItineraryEvent(
      String eventType,
      String eventName,
      String eventLocale,
      String firstName,
      String lastName,
      String eventOwnerGuestID,
      String eventGroupType,
      String eventGroupDescription,
      EventLocation eventLocation,
      EventTime eventStartTime,
      EventTime eventEndTime,
      EventSourceDetail sourceDetail,
      ImmutableList<EventAttendee> attendees,
      ImmutableList<ItineraryLink> links) {
    this.eventType = eventType;
    this.eventName = eventName;
    this.eventLocale = eventLocale;
    this.firstName = firstName;
    this.lastName = lastName;
    this.eventOwnerGuestID = eventOwnerGuestID;
    this.eventGroupType = eventGroupType;
    this.eventGroupDescription = eventGroupDescription;
    this.eventLocation = eventLocation;
    this.eventStartTime = eventStartTime;
    this.eventEndTime = eventEndTime;
    this.sourceDetail = sourceDetail;
    this.attendees = attendees;
    this.links = links;
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
   * @return The value of the {@code eventName} attribute
   */
  @JsonProperty("eventName")
  @Override
  public String eventName() {
    return eventName;
  }

  /**
   * @return The value of the {@code eventLocale} attribute
   */
  @JsonProperty("eventLocale")
  @Override
  public String eventLocale() {
    return eventLocale;
  }

  /**
   * @return The value of the {@code firstName} attribute
   */
  @JsonProperty("firstName")
  @Override
  public String firstName() {
    return firstName;
  }

  /**
   * @return The value of the {@code lastName} attribute
   */
  @JsonProperty("lastName")
  @Override
  public String lastName() {
    return lastName;
  }

  /**
   * @return The value of the {@code eventOwnerGuestID} attribute
   */
  @JsonProperty("eventOwnerGuestID")
  @Override
  public String eventOwnerGuestID() {
    return eventOwnerGuestID;
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
  public ImmutableList<EventAttendee> attendees() {
    return attendees;
  }

  /**
   * @return The value of the {@code links} attribute
   */
  @JsonProperty("links")
  @Override
  public ImmutableList<ItineraryLink> links() {
    return links;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventType() eventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventType(String value) {
    if (this.eventType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventType");
    return new ImmutableItineraryEvent(
        newValue,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventName() eventName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventName(String value) {
    if (this.eventName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventName");
    return new ImmutableItineraryEvent(
        this.eventType,
        newValue,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventLocale() eventLocale} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventLocale
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventLocale(String value) {
    if (this.eventLocale.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventLocale");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        newValue,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#firstName() firstName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for firstName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withFirstName(String value) {
    if (this.firstName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "firstName");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        newValue,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#lastName() lastName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lastName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withLastName(String value) {
    if (this.lastName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "lastName");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        newValue,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventOwnerGuestID() eventOwnerGuestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventOwnerGuestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventOwnerGuestID(String value) {
    if (this.eventOwnerGuestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventOwnerGuestID");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        newValue,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventGroupType() eventGroupType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventGroupType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventGroupType(String value) {
    if (this.eventGroupType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventGroupType");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        newValue,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventGroupDescription() eventGroupDescription} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventGroupDescription
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventGroupDescription(String value) {
    if (this.eventGroupDescription.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventGroupDescription");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        newValue,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventLocation() eventLocation} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventLocation
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventLocation(EventLocation value) {
    if (this.eventLocation == value) return this;
    EventLocation newValue = Preconditions.checkNotNull(value, "eventLocation");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        newValue,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventStartTime() eventStartTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventStartTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventStartTime(EventTime value) {
    if (this.eventStartTime == value) return this;
    EventTime newValue = Preconditions.checkNotNull(value, "eventStartTime");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        newValue,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#eventEndTime() eventEndTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventEndTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withEventEndTime(EventTime value) {
    if (this.eventEndTime == value) return this;
    EventTime newValue = Preconditions.checkNotNull(value, "eventEndTime");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        newValue,
        this.sourceDetail,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryEvent#sourceDetail() sourceDetail} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceDetail
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryEvent withSourceDetail(EventSourceDetail value) {
    if (this.sourceDetail == value) return this;
    EventSourceDetail newValue = Preconditions.checkNotNull(value, "sourceDetail");
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        newValue,
        this.attendees,
        this.links);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ItineraryEvent#attendees() attendees}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItineraryEvent withAttendees(EventAttendee... elements) {
    ImmutableList<EventAttendee> newValue = ImmutableList.copyOf(elements);
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        newValue,
        this.links);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ItineraryEvent#attendees() attendees}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of attendees elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItineraryEvent withAttendees(Iterable<? extends EventAttendee> elements) {
    if (this.attendees == elements) return this;
    ImmutableList<EventAttendee> newValue = ImmutableList.copyOf(elements);
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        newValue,
        this.links);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ItineraryEvent#links() links}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItineraryEvent withLinks(ItineraryLink... elements) {
    ImmutableList<ItineraryLink> newValue = ImmutableList.copyOf(elements);
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ItineraryEvent#links() links}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of links elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableItineraryEvent withLinks(Iterable<? extends ItineraryLink> elements) {
    if (this.links == elements) return this;
    ImmutableList<ItineraryLink> newValue = ImmutableList.copyOf(elements);
    return new ImmutableItineraryEvent(
        this.eventType,
        this.eventName,
        this.eventLocale,
        this.firstName,
        this.lastName,
        this.eventOwnerGuestID,
        this.eventGroupType,
        this.eventGroupDescription,
        this.eventLocation,
        this.eventStartTime,
        this.eventEndTime,
        this.sourceDetail,
        this.attendees,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableItineraryEvent} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableItineraryEvent
        && equalTo((ImmutableItineraryEvent) another);
  }

  private boolean equalTo(ImmutableItineraryEvent another) {
    return eventType.equals(another.eventType)
        && eventName.equals(another.eventName)
        && eventLocale.equals(another.eventLocale)
        && firstName.equals(another.firstName)
        && lastName.equals(another.lastName)
        && eventOwnerGuestID.equals(another.eventOwnerGuestID)
        && eventGroupType.equals(another.eventGroupType)
        && eventGroupDescription.equals(another.eventGroupDescription)
        && eventLocation.equals(another.eventLocation)
        && eventStartTime.equals(another.eventStartTime)
        && eventEndTime.equals(another.eventEndTime)
        && sourceDetail.equals(another.sourceDetail)
        && attendees.equals(another.attendees)
        && links.equals(another.links);
  }

  /**
   * Computes a hash code from attributes: {@code eventType}, {@code eventName}, {@code eventLocale}, {@code firstName}, {@code lastName}, {@code eventOwnerGuestID}, {@code eventGroupType}, {@code eventGroupDescription}, {@code eventLocation}, {@code eventStartTime}, {@code eventEndTime}, {@code sourceDetail}, {@code attendees}, {@code links}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + eventType.hashCode();
    h += (h << 5) + eventName.hashCode();
    h += (h << 5) + eventLocale.hashCode();
    h += (h << 5) + firstName.hashCode();
    h += (h << 5) + lastName.hashCode();
    h += (h << 5) + eventOwnerGuestID.hashCode();
    h += (h << 5) + eventGroupType.hashCode();
    h += (h << 5) + eventGroupDescription.hashCode();
    h += (h << 5) + eventLocation.hashCode();
    h += (h << 5) + eventStartTime.hashCode();
    h += (h << 5) + eventEndTime.hashCode();
    h += (h << 5) + sourceDetail.hashCode();
    h += (h << 5) + attendees.hashCode();
    h += (h << 5) + links.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ItineraryEvent} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ItineraryEvent")
        .omitNullValues()
        .add("eventType", eventType)
        .add("eventName", eventName)
        .add("eventLocale", eventLocale)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .add("eventOwnerGuestID", eventOwnerGuestID)
        .add("eventGroupType", eventGroupType)
        .add("eventGroupDescription", eventGroupDescription)
        .add("eventLocation", eventLocation)
        .add("eventStartTime", eventStartTime)
        .add("eventEndTime", eventEndTime)
        .add("sourceDetail", sourceDetail)
        .add("attendees", attendees)
        .add("links", links)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ItineraryEvent {
    @Nullable String eventType;
    @Nullable String eventName;
    @Nullable String eventLocale;
    @Nullable String firstName;
    @Nullable String lastName;
    @Nullable String eventOwnerGuestID;
    @Nullable String eventGroupType;
    @Nullable String eventGroupDescription;
    @Nullable EventLocation eventLocation;
    @Nullable EventTime eventStartTime;
    @Nullable EventTime eventEndTime;
    @Nullable EventSourceDetail sourceDetail;
    List<EventAttendee> attendees = ImmutableList.of();
    List<ItineraryLink> links = ImmutableList.of();
    @JsonProperty("eventType")
    public void setEventType(String eventType) {
      this.eventType = eventType;
    }
    @JsonProperty("eventName")
    public void setEventName(String eventName) {
      this.eventName = eventName;
    }
    @JsonProperty("eventLocale")
    public void setEventLocale(String eventLocale) {
      this.eventLocale = eventLocale;
    }
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    @JsonProperty("eventOwnerGuestID")
    public void setEventOwnerGuestID(String eventOwnerGuestID) {
      this.eventOwnerGuestID = eventOwnerGuestID;
    }
    @JsonProperty("eventGroupType")
    public void setEventGroupType(String eventGroupType) {
      this.eventGroupType = eventGroupType;
    }
    @JsonProperty("eventGroupDescription")
    public void setEventGroupDescription(String eventGroupDescription) {
      this.eventGroupDescription = eventGroupDescription;
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
    public void setAttendees(List<EventAttendee> attendees) {
      this.attendees = attendees;
    }
    @JsonProperty("links")
    public void setLinks(List<ItineraryLink> links) {
      this.links = links;
    }
    @Override
    public String eventType() { throw new UnsupportedOperationException(); }
    @Override
    public String eventName() { throw new UnsupportedOperationException(); }
    @Override
    public String eventLocale() { throw new UnsupportedOperationException(); }
    @Override
    public String firstName() { throw new UnsupportedOperationException(); }
    @Override
    public String lastName() { throw new UnsupportedOperationException(); }
    @Override
    public String eventOwnerGuestID() { throw new UnsupportedOperationException(); }
    @Override
    public String eventGroupType() { throw new UnsupportedOperationException(); }
    @Override
    public String eventGroupDescription() { throw new UnsupportedOperationException(); }
    @Override
    public EventLocation eventLocation() { throw new UnsupportedOperationException(); }
    @Override
    public EventTime eventStartTime() { throw new UnsupportedOperationException(); }
    @Override
    public EventTime eventEndTime() { throw new UnsupportedOperationException(); }
    @Override
    public EventSourceDetail sourceDetail() { throw new UnsupportedOperationException(); }
    @Override
    public List<EventAttendee> attendees() { throw new UnsupportedOperationException(); }
    @Override
    public List<ItineraryLink> links() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableItineraryEvent fromJson(Json json) {
    ImmutableItineraryEvent.Builder builder = ImmutableItineraryEvent.builder();
    if (json.eventType != null) {
      builder.eventType(json.eventType);
    }
    if (json.eventName != null) {
      builder.eventName(json.eventName);
    }
    if (json.eventLocale != null) {
      builder.eventLocale(json.eventLocale);
    }
    if (json.firstName != null) {
      builder.firstName(json.firstName);
    }
    if (json.lastName != null) {
      builder.lastName(json.lastName);
    }
    if (json.eventOwnerGuestID != null) {
      builder.eventOwnerGuestID(json.eventOwnerGuestID);
    }
    if (json.eventGroupType != null) {
      builder.eventGroupType(json.eventGroupType);
    }
    if (json.eventGroupDescription != null) {
      builder.eventGroupDescription(json.eventGroupDescription);
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
    if (json.links != null) {
      builder.addAllLinks(json.links);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ItineraryEvent} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ItineraryEvent instance
   */
  public static ImmutableItineraryEvent copyOf(ItineraryEvent instance) {
    if (instance instanceof ImmutableItineraryEvent) {
      return (ImmutableItineraryEvent) instance;
    }
    return ImmutableItineraryEvent.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableItineraryEvent ImmutableItineraryEvent}.
   * @return A new ImmutableItineraryEvent builder
   */
  public static ImmutableItineraryEvent.Builder builder() {
    return new ImmutableItineraryEvent.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableItineraryEvent ImmutableItineraryEvent}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_EVENT_TYPE = 0x1L;
    private static final long INIT_BIT_EVENT_NAME = 0x2L;
    private static final long INIT_BIT_EVENT_LOCALE = 0x4L;
    private static final long INIT_BIT_FIRST_NAME = 0x8L;
    private static final long INIT_BIT_LAST_NAME = 0x10L;
    private static final long INIT_BIT_EVENT_OWNER_GUEST_I_D = 0x20L;
    private static final long INIT_BIT_EVENT_GROUP_TYPE = 0x40L;
    private static final long INIT_BIT_EVENT_GROUP_DESCRIPTION = 0x80L;
    private static final long INIT_BIT_EVENT_LOCATION = 0x100L;
    private static final long INIT_BIT_EVENT_START_TIME = 0x200L;
    private static final long INIT_BIT_EVENT_END_TIME = 0x400L;
    private static final long INIT_BIT_SOURCE_DETAIL = 0x800L;
    private long initBits = 0xfffL;

    private @Nullable String eventType;
    private @Nullable String eventName;
    private @Nullable String eventLocale;
    private @Nullable String firstName;
    private @Nullable String lastName;
    private @Nullable String eventOwnerGuestID;
    private @Nullable String eventGroupType;
    private @Nullable String eventGroupDescription;
    private @Nullable EventLocation eventLocation;
    private @Nullable EventTime eventStartTime;
    private @Nullable EventTime eventEndTime;
    private @Nullable EventSourceDetail sourceDetail;
    private ImmutableList.Builder<EventAttendee> attendees = ImmutableList.builder();
    private ImmutableList.Builder<ItineraryLink> links = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ItineraryEvent} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ItineraryEvent instance) {
      Preconditions.checkNotNull(instance, "instance");
      eventType(instance.eventType());
      eventName(instance.eventName());
      eventLocale(instance.eventLocale());
      firstName(instance.firstName());
      lastName(instance.lastName());
      eventOwnerGuestID(instance.eventOwnerGuestID());
      eventGroupType(instance.eventGroupType());
      eventGroupDescription(instance.eventGroupDescription());
      eventLocation(instance.eventLocation());
      eventStartTime(instance.eventStartTime());
      eventEndTime(instance.eventEndTime());
      sourceDetail(instance.sourceDetail());
      addAllAttendees(instance.attendees());
      addAllLinks(instance.links());
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEvent#eventType() eventType} attribute.
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
     * Initializes the value for the {@link ItineraryEvent#eventName() eventName} attribute.
     * @param eventName The value for eventName 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventName")
    public final Builder eventName(String eventName) {
      this.eventName = Preconditions.checkNotNull(eventName, "eventName");
      initBits &= ~INIT_BIT_EVENT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEvent#eventLocale() eventLocale} attribute.
     * @param eventLocale The value for eventLocale 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventLocale")
    public final Builder eventLocale(String eventLocale) {
      this.eventLocale = Preconditions.checkNotNull(eventLocale, "eventLocale");
      initBits &= ~INIT_BIT_EVENT_LOCALE;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEvent#firstName() firstName} attribute.
     * @param firstName The value for firstName 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("firstName")
    public final Builder firstName(String firstName) {
      this.firstName = Preconditions.checkNotNull(firstName, "firstName");
      initBits &= ~INIT_BIT_FIRST_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEvent#lastName() lastName} attribute.
     * @param lastName The value for lastName 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("lastName")
    public final Builder lastName(String lastName) {
      this.lastName = Preconditions.checkNotNull(lastName, "lastName");
      initBits &= ~INIT_BIT_LAST_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEvent#eventOwnerGuestID() eventOwnerGuestID} attribute.
     * @param eventOwnerGuestID The value for eventOwnerGuestID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("eventOwnerGuestID")
    public final Builder eventOwnerGuestID(String eventOwnerGuestID) {
      this.eventOwnerGuestID = Preconditions.checkNotNull(eventOwnerGuestID, "eventOwnerGuestID");
      initBits &= ~INIT_BIT_EVENT_OWNER_GUEST_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryEvent#eventGroupType() eventGroupType} attribute.
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
     * Initializes the value for the {@link ItineraryEvent#eventGroupDescription() eventGroupDescription} attribute.
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
     * Initializes the value for the {@link ItineraryEvent#eventLocation() eventLocation} attribute.
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
     * Initializes the value for the {@link ItineraryEvent#eventStartTime() eventStartTime} attribute.
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
     * Initializes the value for the {@link ItineraryEvent#eventEndTime() eventEndTime} attribute.
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
     * Initializes the value for the {@link ItineraryEvent#sourceDetail() sourceDetail} attribute.
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
     * Adds one element to {@link ItineraryEvent#attendees() attendees} list.
     * @param element A attendees element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAttendees(EventAttendee element) {
      this.attendees.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ItineraryEvent#attendees() attendees} list.
     * @param elements An array of attendees elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAttendees(EventAttendee... elements) {
      this.attendees.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ItineraryEvent#attendees() attendees} list.
     * @param elements An iterable of attendees elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("attendees")
    public final Builder attendees(Iterable<? extends EventAttendee> elements) {
      this.attendees = ImmutableList.builder();
      return addAllAttendees(elements);
    }

    /**
     * Adds elements to {@link ItineraryEvent#attendees() attendees} list.
     * @param elements An iterable of attendees elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllAttendees(Iterable<? extends EventAttendee> elements) {
      this.attendees.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ItineraryEvent#links() links} list.
     * @param element A links element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addLinks(ItineraryLink element) {
      this.links.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ItineraryEvent#links() links} list.
     * @param elements An array of links elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addLinks(ItineraryLink... elements) {
      this.links.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ItineraryEvent#links() links} list.
     * @param elements An iterable of links elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("links")
    public final Builder links(Iterable<? extends ItineraryLink> elements) {
      this.links = ImmutableList.builder();
      return addAllLinks(elements);
    }

    /**
     * Adds elements to {@link ItineraryEvent#links() links} list.
     * @param elements An iterable of links elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllLinks(Iterable<? extends ItineraryLink> elements) {
      this.links.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableItineraryEvent ImmutableItineraryEvent}.
     * @return An immutable instance of ItineraryEvent
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableItineraryEvent build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableItineraryEvent(
          eventType,
          eventName,
          eventLocale,
          firstName,
          lastName,
          eventOwnerGuestID,
          eventGroupType,
          eventGroupDescription,
          eventLocation,
          eventStartTime,
          eventEndTime,
          sourceDetail,
          attendees.build(),
          links.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_EVENT_TYPE) != 0) attributes.add("eventType");
      if ((initBits & INIT_BIT_EVENT_NAME) != 0) attributes.add("eventName");
      if ((initBits & INIT_BIT_EVENT_LOCALE) != 0) attributes.add("eventLocale");
      if ((initBits & INIT_BIT_FIRST_NAME) != 0) attributes.add("firstName");
      if ((initBits & INIT_BIT_LAST_NAME) != 0) attributes.add("lastName");
      if ((initBits & INIT_BIT_EVENT_OWNER_GUEST_I_D) != 0) attributes.add("eventOwnerGuestID");
      if ((initBits & INIT_BIT_EVENT_GROUP_TYPE) != 0) attributes.add("eventGroupType");
      if ((initBits & INIT_BIT_EVENT_GROUP_DESCRIPTION) != 0) attributes.add("eventGroupDescription");
      if ((initBits & INIT_BIT_EVENT_LOCATION) != 0) attributes.add("eventLocation");
      if ((initBits & INIT_BIT_EVENT_START_TIME) != 0) attributes.add("eventStartTime");
      if ((initBits & INIT_BIT_EVENT_END_TIME) != 0) attributes.add("eventEndTime");
      if ((initBits & INIT_BIT_SOURCE_DETAIL) != 0) attributes.add("sourceDetail");
      return "Cannot build ItineraryEvent, some of required attributes are not set " + attributes;
    }
  }
}
