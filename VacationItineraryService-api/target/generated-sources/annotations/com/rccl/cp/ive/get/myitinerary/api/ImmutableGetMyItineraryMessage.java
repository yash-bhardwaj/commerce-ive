package com.rccl.cp.ive.get.myitinerary.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
 * Immutable implementation of {@link GetMyItineraryMessage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGetMyItineraryMessage.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "GetMyItineraryMessage"})
@Immutable
public final class ImmutableGetMyItineraryMessage
    implements GetMyItineraryMessage {
  private final String shipSailDate;
  private final String cruiseBookingID;
  private final String guestID;

  private ImmutableGetMyItineraryMessage(String shipSailDate, String cruiseBookingID, String guestID) {
    this.shipSailDate = shipSailDate;
    this.cruiseBookingID = cruiseBookingID;
    this.guestID = guestID;
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
   * Copy the current immutable object by setting a value for the {@link GetMyItineraryMessage#shipSailDate() shipSailDate} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for shipSailDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGetMyItineraryMessage withShipSailDate(String value) {
    if (this.shipSailDate.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "shipSailDate");
    return new ImmutableGetMyItineraryMessage(newValue, this.cruiseBookingID, this.guestID);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GetMyItineraryMessage#cruiseBookingID() cruiseBookingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for cruiseBookingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGetMyItineraryMessage withCruiseBookingID(String value) {
    if (this.cruiseBookingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "cruiseBookingID");
    return new ImmutableGetMyItineraryMessage(this.shipSailDate, newValue, this.guestID);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GetMyItineraryMessage#guestID() guestID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGetMyItineraryMessage withGuestID(String value) {
    if (this.guestID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableGetMyItineraryMessage(this.shipSailDate, this.cruiseBookingID, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGetMyItineraryMessage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGetMyItineraryMessage
        && equalTo((ImmutableGetMyItineraryMessage) another);
  }

  private boolean equalTo(ImmutableGetMyItineraryMessage another) {
    return shipSailDate.equals(another.shipSailDate)
        && cruiseBookingID.equals(another.cruiseBookingID)
        && guestID.equals(another.guestID);
  }

  /**
   * Computes a hash code from attributes: {@code shipSailDate}, {@code cruiseBookingID}, {@code guestID}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + shipSailDate.hashCode();
    h += (h << 5) + cruiseBookingID.hashCode();
    h += (h << 5) + guestID.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code GetMyItineraryMessage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("GetMyItineraryMessage")
        .omitNullValues()
        .add("shipSailDate", shipSailDate)
        .add("cruiseBookingID", cruiseBookingID)
        .add("guestID", guestID)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements GetMyItineraryMessage {
    @Nullable String shipSailDate;
    @Nullable String cruiseBookingID;
    @Nullable String guestID;
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
    @Override
    public String shipSailDate() { throw new UnsupportedOperationException(); }
    @Override
    public String cruiseBookingID() { throw new UnsupportedOperationException(); }
    @Override
    public String guestID() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableGetMyItineraryMessage fromJson(Json json) {
    ImmutableGetMyItineraryMessage.Builder builder = ImmutableGetMyItineraryMessage.builder();
    if (json.shipSailDate != null) {
      builder.shipSailDate(json.shipSailDate);
    }
    if (json.cruiseBookingID != null) {
      builder.cruiseBookingID(json.cruiseBookingID);
    }
    if (json.guestID != null) {
      builder.guestID(json.guestID);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link GetMyItineraryMessage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable GetMyItineraryMessage instance
   */
  public static ImmutableGetMyItineraryMessage copyOf(GetMyItineraryMessage instance) {
    if (instance instanceof ImmutableGetMyItineraryMessage) {
      return (ImmutableGetMyItineraryMessage) instance;
    }
    return ImmutableGetMyItineraryMessage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableGetMyItineraryMessage ImmutableGetMyItineraryMessage}.
   * @return A new ImmutableGetMyItineraryMessage builder
   */
  public static ImmutableGetMyItineraryMessage.Builder builder() {
    return new ImmutableGetMyItineraryMessage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGetMyItineraryMessage ImmutableGetMyItineraryMessage}.
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
    private long initBits = 0x7L;

    private @Nullable String shipSailDate;
    private @Nullable String cruiseBookingID;
    private @Nullable String guestID;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code GetMyItineraryMessage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(GetMyItineraryMessage instance) {
      Preconditions.checkNotNull(instance, "instance");
      shipSailDate(instance.shipSailDate());
      cruiseBookingID(instance.cruiseBookingID());
      guestID(instance.guestID());
      return this;
    }

    /**
     * Initializes the value for the {@link GetMyItineraryMessage#shipSailDate() shipSailDate} attribute.
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
     * Initializes the value for the {@link GetMyItineraryMessage#cruiseBookingID() cruiseBookingID} attribute.
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
     * Initializes the value for the {@link GetMyItineraryMessage#guestID() guestID} attribute.
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
     * Builds a new {@link ImmutableGetMyItineraryMessage ImmutableGetMyItineraryMessage}.
     * @return An immutable instance of GetMyItineraryMessage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGetMyItineraryMessage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGetMyItineraryMessage(shipSailDate, cruiseBookingID, guestID);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_SHIP_SAIL_DATE) != 0) attributes.add("shipSailDate");
      if ((initBits & INIT_BIT_CRUISE_BOOKING_I_D) != 0) attributes.add("cruiseBookingID");
      if ((initBits & INIT_BIT_GUEST_I_D) != 0) attributes.add("guestID");
      return "Cannot build GetMyItineraryMessage, some of required attributes are not set " + attributes;
    }
  }
}
