package com.rccl.cp.ive.update.dining.api.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link DiningEventEvent.DiningEventRemoved}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDiningEventRemoved.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "DiningEventEvent.DiningEventRemoved"})
@Immutable
public final class ImmutableDiningEventRemoved
    implements DiningEventEvent.DiningEventRemoved {
  private final String shipSailDate;
  private final String guestID;
  private final String ownerGuestID;
  private final String ownerReservationID;
  private final String sourceSystemApplicationID;
  private final String sourceSystemOfferingID;
  private final String eventType;
  private final @Nullable DiningEventMessage message;

  private ImmutableDiningEventRemoved(
      String shipSailDate,
      String guestID,
      String ownerGuestID,
      String ownerReservationID,
      String sourceSystemApplicationID,
      String sourceSystemOfferingID,
      String eventType,
      @Nullable DiningEventMessage message) {
    this.shipSailDate = shipSailDate;
    this.guestID = guestID;
    this.ownerGuestID = ownerGuestID;
    this.ownerReservationID = ownerReservationID;
    this.sourceSystemApplicationID = sourceSystemApplicationID;
    this.sourceSystemOfferingID = sourceSystemOfferingID;
    this.eventType = eventType;
    this.message = message;
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
   * @return The value of the {@code guestID} attribute
   */
  @JsonProperty("guestID")
  @Override
  public String guestID() {
    return guestID;
  }

  /**
   * @return The value of the {@code ownerGuestID} attribute
   */
  @JsonProperty("ownerGuestID")
  @Override
  public String ownerGuestID() {
    return ownerGuestID;
  }

  /**
   * @return The value of the {@code ownerReservationID} attribute
   */
  @JsonProperty("ownerReservationID")
  @Override
  public String ownerReservationID() {
    return ownerReservationID;
  }

  /**
   * @return The value of the {@code sourceSystemApplicationID} attribute
   */
  @JsonProperty("sourceSystemApplicationID")
  @Override
  public String sourceSystemApplicationID() {
    return sourceSystemApplicationID;
  }

  /**
   * @return The value of the {@code sourceSystemOfferingID} attribute
   */
  @JsonProperty("sourceSystemOfferingID")
  @Override
  public String sourceSystemOfferingID() {
    return sourceSystemOfferingID;
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
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("message")
  @Override
  public Optional<DiningEventMessage> message() {
    return Optional.ofNullable(message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#shipSailDate() shipSailDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shipSailDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withShipSailDate(String value) {
    if (this.shipSailDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "shipSailDate");
    return new ImmutableDiningEventRemoved(
        newValue,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#guestID() guestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withGuestID(String value) {
    if (this.guestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        newValue,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#ownerGuestID() ownerGuestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for ownerGuestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withOwnerGuestID(String value) {
    if (this.ownerGuestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "ownerGuestID");
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        newValue,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#ownerReservationID() ownerReservationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for ownerReservationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withOwnerReservationID(String value) {
    if (this.ownerReservationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "ownerReservationID");
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        newValue,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemApplicationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withSourceSystemApplicationID(String value) {
    if (this.sourceSystemApplicationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemApplicationID");
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        newValue,
        this.sourceSystemOfferingID,
        this.eventType,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemOfferingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withSourceSystemOfferingID(String value) {
    if (this.sourceSystemOfferingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemOfferingID");
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        newValue,
        this.eventType,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventEvent.DiningEventRemoved#eventType() eventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDiningEventRemoved withEventType(String value) {
    if (this.eventType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventType");
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        newValue,
        this.message);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link DiningEventEvent.DiningEventRemoved#message() message} attribute.
   * @param value The value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDiningEventRemoved withMessage(DiningEventMessage value) {
    @Nullable DiningEventMessage newValue = Preconditions.checkNotNull(value, "message");
    if (this.message == newValue) return this;
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link DiningEventEvent.DiningEventRemoved#message() message} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableDiningEventRemoved withMessage(Optional<? extends DiningEventMessage> optional) {
    @Nullable DiningEventMessage value = optional.orElse(null);
    if (this.message == value) return this;
    return new ImmutableDiningEventRemoved(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDiningEventRemoved} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDiningEventRemoved
        && equalTo((ImmutableDiningEventRemoved) another);
  }

  private boolean equalTo(ImmutableDiningEventRemoved another) {
    return shipSailDate.equals(another.shipSailDate)
        && guestID.equals(another.guestID)
        && ownerGuestID.equals(another.ownerGuestID)
        && ownerReservationID.equals(another.ownerReservationID)
        && sourceSystemApplicationID.equals(another.sourceSystemApplicationID)
        && sourceSystemOfferingID.equals(another.sourceSystemOfferingID)
        && eventType.equals(another.eventType)
        && Objects.equal(message, another.message);
  }

  /**
   * Computes a hash code from attributes: {@code shipSailDate}, {@code guestID}, {@code ownerGuestID}, {@code ownerReservationID}, {@code sourceSystemApplicationID}, {@code sourceSystemOfferingID}, {@code eventType}, {@code message}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + shipSailDate.hashCode();
    h += (h << 5) + guestID.hashCode();
    h += (h << 5) + ownerGuestID.hashCode();
    h += (h << 5) + ownerReservationID.hashCode();
    h += (h << 5) + sourceSystemApplicationID.hashCode();
    h += (h << 5) + sourceSystemOfferingID.hashCode();
    h += (h << 5) + eventType.hashCode();
    h += (h << 5) + Objects.hashCode(message);
    return h;
  }

  /**
   * Prints the immutable value {@code DiningEventRemoved} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("DiningEventRemoved")
        .omitNullValues()
        .add("shipSailDate", shipSailDate)
        .add("guestID", guestID)
        .add("ownerGuestID", ownerGuestID)
        .add("ownerReservationID", ownerReservationID)
        .add("sourceSystemApplicationID", sourceSystemApplicationID)
        .add("sourceSystemOfferingID", sourceSystemOfferingID)
        .add("eventType", eventType)
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
      implements DiningEventEvent.DiningEventRemoved {
    @Nullable String shipSailDate;
    @Nullable String guestID;
    @Nullable String ownerGuestID;
    @Nullable String ownerReservationID;
    @Nullable String sourceSystemApplicationID;
    @Nullable String sourceSystemOfferingID;
    @Nullable String eventType;
    Optional<DiningEventMessage> message = Optional.empty();
    @JsonProperty("shipSailDate")
    public void setShipSailDate(String shipSailDate) {
      this.shipSailDate = shipSailDate;
    }
    @JsonProperty("guestID")
    public void setGuestID(String guestID) {
      this.guestID = guestID;
    }
    @JsonProperty("ownerGuestID")
    public void setOwnerGuestID(String ownerGuestID) {
      this.ownerGuestID = ownerGuestID;
    }
    @JsonProperty("ownerReservationID")
    public void setOwnerReservationID(String ownerReservationID) {
      this.ownerReservationID = ownerReservationID;
    }
    @JsonProperty("sourceSystemApplicationID")
    public void setSourceSystemApplicationID(String sourceSystemApplicationID) {
      this.sourceSystemApplicationID = sourceSystemApplicationID;
    }
    @JsonProperty("sourceSystemOfferingID")
    public void setSourceSystemOfferingID(String sourceSystemOfferingID) {
      this.sourceSystemOfferingID = sourceSystemOfferingID;
    }
    @JsonProperty("eventType")
    public void setEventType(String eventType) {
      this.eventType = eventType;
    }
    @JsonProperty("message")
    public void setMessage(Optional<DiningEventMessage> message) {
      this.message = message;
    }
    @Override
    public String shipSailDate() { throw new UnsupportedOperationException(); }
    @Override
    public String guestID() { throw new UnsupportedOperationException(); }
    @Override
    public String ownerGuestID() { throw new UnsupportedOperationException(); }
    @Override
    public String ownerReservationID() { throw new UnsupportedOperationException(); }
    @Override
    public String sourceSystemApplicationID() { throw new UnsupportedOperationException(); }
    @Override
    public String sourceSystemOfferingID() { throw new UnsupportedOperationException(); }
    @Override
    public String eventType() { throw new UnsupportedOperationException(); }
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
  static ImmutableDiningEventRemoved fromJson(Json json) {
    ImmutableDiningEventRemoved.Builder builder = ImmutableDiningEventRemoved.builder();
    if (json.shipSailDate != null) {
      builder.shipSailDate(json.shipSailDate);
    }
    if (json.guestID != null) {
      builder.guestID(json.guestID);
    }
    if (json.ownerGuestID != null) {
      builder.ownerGuestID(json.ownerGuestID);
    }
    if (json.ownerReservationID != null) {
      builder.ownerReservationID(json.ownerReservationID);
    }
    if (json.sourceSystemApplicationID != null) {
      builder.sourceSystemApplicationID(json.sourceSystemApplicationID);
    }
    if (json.sourceSystemOfferingID != null) {
      builder.sourceSystemOfferingID(json.sourceSystemOfferingID);
    }
    if (json.eventType != null) {
      builder.eventType(json.eventType);
    }
    if (json.message != null) {
      builder.message(json.message);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DiningEventEvent.DiningEventRemoved} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DiningEventRemoved instance
   */
  public static ImmutableDiningEventRemoved copyOf(DiningEventEvent.DiningEventRemoved instance) {
    if (instance instanceof ImmutableDiningEventRemoved) {
      return (ImmutableDiningEventRemoved) instance;
    }
    return ImmutableDiningEventRemoved.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDiningEventRemoved ImmutableDiningEventRemoved}.
   * @return A new ImmutableDiningEventRemoved builder
   */
  public static ImmutableDiningEventRemoved.Builder builder() {
    return new ImmutableDiningEventRemoved.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDiningEventRemoved ImmutableDiningEventRemoved}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SHIP_SAIL_DATE = 0x1L;
    private static final long INIT_BIT_GUEST_I_D = 0x2L;
    private static final long INIT_BIT_OWNER_GUEST_I_D = 0x4L;
    private static final long INIT_BIT_OWNER_RESERVATION_I_D = 0x8L;
    private static final long INIT_BIT_SOURCE_SYSTEM_APPLICATION_I_D = 0x10L;
    private static final long INIT_BIT_SOURCE_SYSTEM_OFFERING_I_D = 0x20L;
    private static final long INIT_BIT_EVENT_TYPE = 0x40L;
    private long initBits = 0x7fL;

    private @Nullable String shipSailDate;
    private @Nullable String guestID;
    private @Nullable String ownerGuestID;
    private @Nullable String ownerReservationID;
    private @Nullable String sourceSystemApplicationID;
    private @Nullable String sourceSystemOfferingID;
    private @Nullable String eventType;
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
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.dining.api.impl.DiningEventEvent.DiningEventRemoved} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DiningEventEvent.DiningEventRemoved instance) {
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
      if (object instanceof DiningEventEvent.DiningEventRemoved) {
        DiningEventEvent.DiningEventRemoved instance = (DiningEventEvent.DiningEventRemoved) object;
        ownerGuestID(instance.ownerGuestID());
        sourceSystemApplicationID(instance.sourceSystemApplicationID());
        shipSailDate(instance.shipSailDate());
        ownerReservationID(instance.ownerReservationID());
        sourceSystemOfferingID(instance.sourceSystemOfferingID());
        eventType(instance.eventType());
        guestID(instance.guestID());
      }
    }

    /**
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#shipSailDate() shipSailDate} attribute.
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
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#guestID() guestID} attribute.
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
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#ownerGuestID() ownerGuestID} attribute.
     * @param ownerGuestID The value for ownerGuestID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("ownerGuestID")
    public final Builder ownerGuestID(String ownerGuestID) {
      this.ownerGuestID = Preconditions.checkNotNull(ownerGuestID, "ownerGuestID");
      initBits &= ~INIT_BIT_OWNER_GUEST_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#ownerReservationID() ownerReservationID} attribute.
     * @param ownerReservationID The value for ownerReservationID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("ownerReservationID")
    public final Builder ownerReservationID(String ownerReservationID) {
      this.ownerReservationID = Preconditions.checkNotNull(ownerReservationID, "ownerReservationID");
      initBits &= ~INIT_BIT_OWNER_RESERVATION_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
     * @param sourceSystemApplicationID The value for sourceSystemApplicationID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemApplicationID")
    public final Builder sourceSystemApplicationID(String sourceSystemApplicationID) {
      this.sourceSystemApplicationID = Preconditions.checkNotNull(sourceSystemApplicationID, "sourceSystemApplicationID");
      initBits &= ~INIT_BIT_SOURCE_SYSTEM_APPLICATION_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
     * @param sourceSystemOfferingID The value for sourceSystemOfferingID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemOfferingID")
    public final Builder sourceSystemOfferingID(String sourceSystemOfferingID) {
      this.sourceSystemOfferingID = Preconditions.checkNotNull(sourceSystemOfferingID, "sourceSystemOfferingID");
      initBits &= ~INIT_BIT_SOURCE_SYSTEM_OFFERING_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link DiningEventEvent.DiningEventRemoved#eventType() eventType} attribute.
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
     * Initializes the optional value {@link DiningEventEvent.DiningEventRemoved#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for chained invocation
     */
    public final Builder message(DiningEventMessage message) {
      this.message = Preconditions.checkNotNull(message, "message");
      return this;
    }

    /**
     * Initializes the optional value {@link DiningEventEvent.DiningEventRemoved#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("message")
    public final Builder message(Optional<? extends DiningEventMessage> message) {
      this.message = message.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableDiningEventRemoved ImmutableDiningEventRemoved}.
     * @return An immutable instance of DiningEventRemoved
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDiningEventRemoved build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDiningEventRemoved(
          shipSailDate,
          guestID,
          ownerGuestID,
          ownerReservationID,
          sourceSystemApplicationID,
          sourceSystemOfferingID,
          eventType,
          message);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_SHIP_SAIL_DATE) != 0) attributes.add("shipSailDate");
      if ((initBits & INIT_BIT_GUEST_I_D) != 0) attributes.add("guestID");
      if ((initBits & INIT_BIT_OWNER_GUEST_I_D) != 0) attributes.add("ownerGuestID");
      if ((initBits & INIT_BIT_OWNER_RESERVATION_I_D) != 0) attributes.add("ownerReservationID");
      if ((initBits & INIT_BIT_SOURCE_SYSTEM_APPLICATION_I_D) != 0) attributes.add("sourceSystemApplicationID");
      if ((initBits & INIT_BIT_SOURCE_SYSTEM_OFFERING_I_D) != 0) attributes.add("sourceSystemOfferingID");
      if ((initBits & INIT_BIT_EVENT_TYPE) != 0) attributes.add("eventType");
      return "Cannot build DiningEventRemoved, some of required attributes are not set " + attributes;
    }
  }
}
