package com.rccl.cp.ive.update.cruisecompass.api.impl;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRemoveCruiseCompassEventCommand.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "CruiseCompassEventCommand.RemoveCruiseCompassEventCommand"})
@Immutable
public final class ImmutableRemoveCruiseCompassEventCommand
    implements CruiseCompassEventCommand.RemoveCruiseCompassEventCommand {
  private final String shipSailDate;
  private final String guestID;
  private final String ownerGuestID;
  private final String ownerReservationID;
  private final String sourceSystemApplicationID;
  private final String sourceSystemOfferingID;
  private final String eventType;

  private ImmutableRemoveCruiseCompassEventCommand(
      String shipSailDate,
      String guestID,
      String ownerGuestID,
      String ownerReservationID,
      String sourceSystemApplicationID,
      String sourceSystemOfferingID,
      String eventType) {
    this.shipSailDate = shipSailDate;
    this.guestID = guestID;
    this.ownerGuestID = ownerGuestID;
    this.ownerReservationID = ownerReservationID;
    this.sourceSystemApplicationID = sourceSystemApplicationID;
    this.sourceSystemOfferingID = sourceSystemOfferingID;
    this.eventType = eventType;
  }

  /**
   * @return The value of the {@code shipSailDate} attribute
   */
  @Override
  public String shipSailDate() {
    return shipSailDate;
  }

  /**
   * @return The value of the {@code guestID} attribute
   */
  @Override
  public String guestID() {
    return guestID;
  }

  /**
   * @return The value of the {@code ownerGuestID} attribute
   */
  @Override
  public String ownerGuestID() {
    return ownerGuestID;
  }

  /**
   * @return The value of the {@code ownerReservationID} attribute
   */
  @Override
  public String ownerReservationID() {
    return ownerReservationID;
  }

  /**
   * @return The value of the {@code sourceSystemApplicationID} attribute
   */
  @Override
  public String sourceSystemApplicationID() {
    return sourceSystemApplicationID;
  }

  /**
   * @return The value of the {@code sourceSystemOfferingID} attribute
   */
  @Override
  public String sourceSystemOfferingID() {
    return sourceSystemOfferingID;
  }

  /**
   * @return The value of the {@code eventType} attribute
   */
  @Override
  public String eventType() {
    return eventType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#shipSailDate() shipSailDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shipSailDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withShipSailDate(String value) {
    if (this.shipSailDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "shipSailDate");
    return new ImmutableRemoveCruiseCompassEventCommand(
        newValue,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#guestID() guestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withGuestID(String value) {
    if (this.guestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableRemoveCruiseCompassEventCommand(
        this.shipSailDate,
        newValue,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#ownerGuestID() ownerGuestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for ownerGuestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withOwnerGuestID(String value) {
    if (this.ownerGuestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "ownerGuestID");
    return new ImmutableRemoveCruiseCompassEventCommand(
        this.shipSailDate,
        this.guestID,
        newValue,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#ownerReservationID() ownerReservationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for ownerReservationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withOwnerReservationID(String value) {
    if (this.ownerReservationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "ownerReservationID");
    return new ImmutableRemoveCruiseCompassEventCommand(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        newValue,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.eventType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemApplicationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withSourceSystemApplicationID(String value) {
    if (this.sourceSystemApplicationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemApplicationID");
    return new ImmutableRemoveCruiseCompassEventCommand(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        newValue,
        this.sourceSystemOfferingID,
        this.eventType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemOfferingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withSourceSystemOfferingID(String value) {
    if (this.sourceSystemOfferingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemOfferingID");
    return new ImmutableRemoveCruiseCompassEventCommand(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        newValue,
        this.eventType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#eventType() eventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRemoveCruiseCompassEventCommand withEventType(String value) {
    if (this.eventType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "eventType");
    return new ImmutableRemoveCruiseCompassEventCommand(
        this.shipSailDate,
        this.guestID,
        this.ownerGuestID,
        this.ownerReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRemoveCruiseCompassEventCommand} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRemoveCruiseCompassEventCommand
        && equalTo((ImmutableRemoveCruiseCompassEventCommand) another);
  }

  private boolean equalTo(ImmutableRemoveCruiseCompassEventCommand another) {
    return shipSailDate.equals(another.shipSailDate)
        && guestID.equals(another.guestID)
        && ownerGuestID.equals(another.ownerGuestID)
        && ownerReservationID.equals(another.ownerReservationID)
        && sourceSystemApplicationID.equals(another.sourceSystemApplicationID)
        && sourceSystemOfferingID.equals(another.sourceSystemOfferingID)
        && eventType.equals(another.eventType);
  }

  /**
   * Computes a hash code from attributes: {@code shipSailDate}, {@code guestID}, {@code ownerGuestID}, {@code ownerReservationID}, {@code sourceSystemApplicationID}, {@code sourceSystemOfferingID}, {@code eventType}.
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
    return h;
  }

  /**
   * Prints the immutable value {@code RemoveCruiseCompassEventCommand} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("RemoveCruiseCompassEventCommand")
        .omitNullValues()
        .add("shipSailDate", shipSailDate)
        .add("guestID", guestID)
        .add("ownerGuestID", ownerGuestID)
        .add("ownerReservationID", ownerReservationID)
        .add("sourceSystemApplicationID", sourceSystemApplicationID)
        .add("sourceSystemOfferingID", sourceSystemOfferingID)
        .add("eventType", eventType)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RemoveCruiseCompassEventCommand instance
   */
  public static ImmutableRemoveCruiseCompassEventCommand copyOf(CruiseCompassEventCommand.RemoveCruiseCompassEventCommand instance) {
    if (instance instanceof ImmutableRemoveCruiseCompassEventCommand) {
      return (ImmutableRemoveCruiseCompassEventCommand) instance;
    }
    return ImmutableRemoveCruiseCompassEventCommand.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRemoveCruiseCompassEventCommand ImmutableRemoveCruiseCompassEventCommand}.
   * @return A new ImmutableRemoveCruiseCompassEventCommand builder
   */
  public static ImmutableRemoveCruiseCompassEventCommand.Builder builder() {
    return new ImmutableRemoveCruiseCompassEventCommand.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRemoveCruiseCompassEventCommand ImmutableRemoveCruiseCompassEventCommand}.
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

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RemoveCruiseCompassEventCommand} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruiseCompassEventCommand.RemoveCruiseCompassEventCommand instance) {
      Preconditions.checkNotNull(instance, "instance");
      shipSailDate(instance.shipSailDate());
      guestID(instance.guestID());
      ownerGuestID(instance.ownerGuestID());
      ownerReservationID(instance.ownerReservationID());
      sourceSystemApplicationID(instance.sourceSystemApplicationID());
      sourceSystemOfferingID(instance.sourceSystemOfferingID());
      eventType(instance.eventType());
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#shipSailDate() shipSailDate} attribute.
     * @param shipSailDate The value for shipSailDate 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder shipSailDate(String shipSailDate) {
      this.shipSailDate = Preconditions.checkNotNull(shipSailDate, "shipSailDate");
      initBits &= ~INIT_BIT_SHIP_SAIL_DATE;
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#guestID() guestID} attribute.
     * @param guestID The value for guestID 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder guestID(String guestID) {
      this.guestID = Preconditions.checkNotNull(guestID, "guestID");
      initBits &= ~INIT_BIT_GUEST_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#ownerGuestID() ownerGuestID} attribute.
     * @param ownerGuestID The value for ownerGuestID 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder ownerGuestID(String ownerGuestID) {
      this.ownerGuestID = Preconditions.checkNotNull(ownerGuestID, "ownerGuestID");
      initBits &= ~INIT_BIT_OWNER_GUEST_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#ownerReservationID() ownerReservationID} attribute.
     * @param ownerReservationID The value for ownerReservationID 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder ownerReservationID(String ownerReservationID) {
      this.ownerReservationID = Preconditions.checkNotNull(ownerReservationID, "ownerReservationID");
      initBits &= ~INIT_BIT_OWNER_RESERVATION_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
     * @param sourceSystemApplicationID The value for sourceSystemApplicationID 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sourceSystemApplicationID(String sourceSystemApplicationID) {
      this.sourceSystemApplicationID = Preconditions.checkNotNull(sourceSystemApplicationID, "sourceSystemApplicationID");
      initBits &= ~INIT_BIT_SOURCE_SYSTEM_APPLICATION_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
     * @param sourceSystemOfferingID The value for sourceSystemOfferingID 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sourceSystemOfferingID(String sourceSystemOfferingID) {
      this.sourceSystemOfferingID = Preconditions.checkNotNull(sourceSystemOfferingID, "sourceSystemOfferingID");
      initBits &= ~INIT_BIT_SOURCE_SYSTEM_OFFERING_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link CruiseCompassEventCommand.RemoveCruiseCompassEventCommand#eventType() eventType} attribute.
     * @param eventType The value for eventType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder eventType(String eventType) {
      this.eventType = Preconditions.checkNotNull(eventType, "eventType");
      initBits &= ~INIT_BIT_EVENT_TYPE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableRemoveCruiseCompassEventCommand ImmutableRemoveCruiseCompassEventCommand}.
     * @return An immutable instance of RemoveCruiseCompassEventCommand
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRemoveCruiseCompassEventCommand build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRemoveCruiseCompassEventCommand(
          shipSailDate,
          guestID,
          ownerGuestID,
          ownerReservationID,
          sourceSystemApplicationID,
          sourceSystemOfferingID,
          eventType);
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
      return "Cannot build RemoveCruiseCompassEventCommand, some of required attributes are not set " + attributes;
    }
  }
}
