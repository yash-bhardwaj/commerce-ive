package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CruisePlannerEventEvent.CruisePlannerEventRemoved}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCruisePlannerEventRemoved.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "CruisePlannerEventEvent.CruisePlannerEventRemoved"})
@Immutable
public final class ImmutableCruisePlannerEventRemoved
    implements CruisePlannerEventEvent.CruisePlannerEventRemoved {
  private final String shipSailDate;
  private final String guestID;
  private final String ownerGuestID;
  private final String ownerReservationID;
  private final String sourceSystemApplicationID;
  private final String sourceSystemOfferingID;
  private final String eventType;
  private final @Nullable CruisePlannerEventMessage message;

  private ImmutableCruisePlannerEventRemoved(
      String shipSailDate,
      String guestID,
      String ownerGuestID,
      String ownerReservationID,
      String sourceSystemApplicationID,
      String sourceSystemOfferingID,
      String eventType,
      @Nullable CruisePlannerEventMessage message) {
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
  public Optional<CruisePlannerEventMessage> message() {
    return Optional.ofNullable(message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#shipSailDate() shipSailDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shipSailDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withShipSailDate(String value) {
    if (this.shipSailDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "shipSailDate");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#guestID() guestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withGuestID(String value) {
    if (this.guestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#ownerGuestID() ownerGuestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for ownerGuestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withOwnerGuestID(String value) {
    if (this.ownerGuestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "ownerGuestID");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#ownerReservationID() ownerReservationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for ownerReservationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withOwnerReservationID(String value) {
    if (this.ownerReservationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "ownerReservationID");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemApplicationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withSourceSystemApplicationID(String value) {
    if (this.sourceSystemApplicationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemApplicationID");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemOfferingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withSourceSystemOfferingID(String value) {
    if (this.sourceSystemOfferingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemOfferingID");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#eventType() eventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withEventType(String value) {
    if (this.eventType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventType");
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#message() message} attribute.
   * @param value The value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withMessage(CruisePlannerEventMessage value) {
    @Nullable CruisePlannerEventMessage newValue = Preconditions.checkNotNull(value, "message");
    if (this.message == newValue) return this;
    return new ImmutableCruisePlannerEventRemoved(
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
   * Copy the current immutable object by setting an optional value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#message() message} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for message
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCruisePlannerEventRemoved withMessage(Optional<? extends CruisePlannerEventMessage> optional) {
    @Nullable CruisePlannerEventMessage value = optional.orElse(null);
    if (this.message == value) return this;
    return new ImmutableCruisePlannerEventRemoved(
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
   * This instance is equal to all instances of {@code ImmutableCruisePlannerEventRemoved} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCruisePlannerEventRemoved
        && equalTo((ImmutableCruisePlannerEventRemoved) another);
  }

  private boolean equalTo(ImmutableCruisePlannerEventRemoved another) {
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
   * Prints the immutable value {@code CruisePlannerEventRemoved} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CruisePlannerEventRemoved")
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
      implements CruisePlannerEventEvent.CruisePlannerEventRemoved {
    @Nullable String shipSailDate;
    @Nullable String guestID;
    @Nullable String ownerGuestID;
    @Nullable String ownerReservationID;
    @Nullable String sourceSystemApplicationID;
    @Nullable String sourceSystemOfferingID;
    @Nullable String eventType;
    Optional<CruisePlannerEventMessage> message = Optional.empty();
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
    public void setMessage(Optional<CruisePlannerEventMessage> message) {
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
    public Optional<CruisePlannerEventMessage> message() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableCruisePlannerEventRemoved fromJson(Json json) {
    ImmutableCruisePlannerEventRemoved.Builder builder = ImmutableCruisePlannerEventRemoved.builder();
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
   * Creates an immutable copy of a {@link CruisePlannerEventEvent.CruisePlannerEventRemoved} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CruisePlannerEventRemoved instance
   */
  public static ImmutableCruisePlannerEventRemoved copyOf(CruisePlannerEventEvent.CruisePlannerEventRemoved instance) {
    if (instance instanceof ImmutableCruisePlannerEventRemoved) {
      return (ImmutableCruisePlannerEventRemoved) instance;
    }
    return ImmutableCruisePlannerEventRemoved.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCruisePlannerEventRemoved ImmutableCruisePlannerEventRemoved}.
   * @return A new ImmutableCruisePlannerEventRemoved builder
   */
  public static ImmutableCruisePlannerEventRemoved.Builder builder() {
    return new ImmutableCruisePlannerEventRemoved.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCruisePlannerEventRemoved ImmutableCruisePlannerEventRemoved}.
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
    private @Nullable CruisePlannerEventMessage message;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.cruiseplanner.api.impl.CruisePlannerEventEvent.CruisePlannerEventRemoved} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruisePlannerEventEvent.CruisePlannerEventRemoved instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.rccl.cp.ive.update.cruiseplanner.api.impl.CruisePlannerEventEvent} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruisePlannerEventEvent instance) {
      Preconditions.checkNotNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof CruisePlannerEventEvent.CruisePlannerEventRemoved) {
        CruisePlannerEventEvent.CruisePlannerEventRemoved instance = (CruisePlannerEventEvent.CruisePlannerEventRemoved) object;
        ownerGuestID(instance.ownerGuestID());
        sourceSystemApplicationID(instance.sourceSystemApplicationID());
        shipSailDate(instance.shipSailDate());
        ownerReservationID(instance.ownerReservationID());
        sourceSystemOfferingID(instance.sourceSystemOfferingID());
        eventType(instance.eventType());
        guestID(instance.guestID());
      }
      if (object instanceof CruisePlannerEventEvent) {
        CruisePlannerEventEvent instance = (CruisePlannerEventEvent) object;
        Optional<CruisePlannerEventMessage> messageOptional = instance.message();
        if (messageOptional.isPresent()) {
          message(messageOptional);
        }
      }
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#shipSailDate() shipSailDate} attribute.
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
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#guestID() guestID} attribute.
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
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#ownerGuestID() ownerGuestID} attribute.
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
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#ownerReservationID() ownerReservationID} attribute.
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
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
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
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
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
     * Initializes the value for the {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#eventType() eventType} attribute.
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
     * Initializes the optional value {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for chained invocation
     */
    public final Builder message(CruisePlannerEventMessage message) {
      this.message = Preconditions.checkNotNull(message, "message");
      return this;
    }

    /**
     * Initializes the optional value {@link CruisePlannerEventEvent.CruisePlannerEventRemoved#message() message} to message.
     * @param message The value for message
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("message")
    public final Builder message(Optional<? extends CruisePlannerEventMessage> message) {
      this.message = message.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCruisePlannerEventRemoved ImmutableCruisePlannerEventRemoved}.
     * @return An immutable instance of CruisePlannerEventRemoved
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCruisePlannerEventRemoved build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCruisePlannerEventRemoved(
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
      return "Cannot build CruisePlannerEventRemoved, some of required attributes are not set " + attributes;
    }
  }
}
