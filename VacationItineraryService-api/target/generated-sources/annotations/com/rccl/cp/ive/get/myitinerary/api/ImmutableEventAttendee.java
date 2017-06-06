package com.rccl.cp.ive.get.myitinerary.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link EventAttendee}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEventAttendee.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "EventAttendee"})
@Immutable
public final class ImmutableEventAttendee implements EventAttendee {
  private final BigInteger cruiseReservationID;
  private final BigInteger guestID;
  private final String sailingID;
  private final String firstName;
  private final String lastName;

  private ImmutableEventAttendee(
      BigInteger cruiseReservationID,
      BigInteger guestID,
      String sailingID,
      String firstName,
      String lastName) {
    this.cruiseReservationID = cruiseReservationID;
    this.guestID = guestID;
    this.sailingID = sailingID;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * @return The value of the {@code cruiseReservationID} attribute
   */
  @JsonProperty("cruiseReservationID")
  @Override
  public BigInteger cruiseReservationID() {
    return cruiseReservationID;
  }

  /**
   * @return The value of the {@code guestID} attribute
   */
  @JsonProperty("guestID")
  @Override
  public BigInteger guestID() {
    return guestID;
  }

  /**
   * @return The value of the {@code sailingID} attribute
   */
  @JsonProperty("sailingID")
  @Override
  public String sailingID() {
    return sailingID;
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
   * Copy the current immutable object by setting a value for the {@link EventAttendee#cruiseReservationID() cruiseReservationID} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for cruiseReservationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventAttendee withCruiseReservationID(BigInteger value) {
    if (this.cruiseReservationID == value) return this;
    BigInteger newValue = Preconditions.checkNotNull(value, "cruiseReservationID");
    return new ImmutableEventAttendee(newValue, this.guestID, this.sailingID, this.firstName, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventAttendee#guestID() guestID} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventAttendee withGuestID(BigInteger value) {
    if (this.guestID == value) return this;
    BigInteger newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableEventAttendee(this.cruiseReservationID, newValue, this.sailingID, this.firstName, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventAttendee#sailingID() sailingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sailingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventAttendee withSailingID(String value) {
    if (this.sailingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sailingID");
    return new ImmutableEventAttendee(this.cruiseReservationID, this.guestID, newValue, this.firstName, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventAttendee#firstName() firstName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for firstName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventAttendee withFirstName(String value) {
    if (this.firstName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "firstName");
    return new ImmutableEventAttendee(this.cruiseReservationID, this.guestID, this.sailingID, newValue, this.lastName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventAttendee#lastName() lastName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lastName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventAttendee withLastName(String value) {
    if (this.lastName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "lastName");
    return new ImmutableEventAttendee(this.cruiseReservationID, this.guestID, this.sailingID, this.firstName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEventAttendee} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEventAttendee
        && equalTo((ImmutableEventAttendee) another);
  }

  private boolean equalTo(ImmutableEventAttendee another) {
    return cruiseReservationID.equals(another.cruiseReservationID)
        && guestID.equals(another.guestID)
        && sailingID.equals(another.sailingID)
        && firstName.equals(another.firstName)
        && lastName.equals(another.lastName);
  }

  /**
   * Computes a hash code from attributes: {@code cruiseReservationID}, {@code guestID}, {@code sailingID}, {@code firstName}, {@code lastName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + cruiseReservationID.hashCode();
    h += (h << 5) + guestID.hashCode();
    h += (h << 5) + sailingID.hashCode();
    h += (h << 5) + firstName.hashCode();
    h += (h << 5) + lastName.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code EventAttendee} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("EventAttendee")
        .omitNullValues()
        .add("cruiseReservationID", cruiseReservationID)
        .add("guestID", guestID)
        .add("sailingID", sailingID)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements EventAttendee {
    @Nullable BigInteger cruiseReservationID;
    @Nullable BigInteger guestID;
    @Nullable String sailingID;
    @Nullable String firstName;
    @Nullable String lastName;
    @JsonProperty("cruiseReservationID")
    public void setCruiseReservationID(BigInteger cruiseReservationID) {
      this.cruiseReservationID = cruiseReservationID;
    }
    @JsonProperty("guestID")
    public void setGuestID(BigInteger guestID) {
      this.guestID = guestID;
    }
    @JsonProperty("sailingID")
    public void setSailingID(String sailingID) {
      this.sailingID = sailingID;
    }
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    @Override
    public BigInteger cruiseReservationID() { throw new UnsupportedOperationException(); }
    @Override
    public BigInteger guestID() { throw new UnsupportedOperationException(); }
    @Override
    public String sailingID() { throw new UnsupportedOperationException(); }
    @Override
    public String firstName() { throw new UnsupportedOperationException(); }
    @Override
    public String lastName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEventAttendee fromJson(Json json) {
    ImmutableEventAttendee.Builder builder = ImmutableEventAttendee.builder();
    if (json.cruiseReservationID != null) {
      builder.cruiseReservationID(json.cruiseReservationID);
    }
    if (json.guestID != null) {
      builder.guestID(json.guestID);
    }
    if (json.sailingID != null) {
      builder.sailingID(json.sailingID);
    }
    if (json.firstName != null) {
      builder.firstName(json.firstName);
    }
    if (json.lastName != null) {
      builder.lastName(json.lastName);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EventAttendee} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EventAttendee instance
   */
  public static ImmutableEventAttendee copyOf(EventAttendee instance) {
    if (instance instanceof ImmutableEventAttendee) {
      return (ImmutableEventAttendee) instance;
    }
    return ImmutableEventAttendee.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEventAttendee ImmutableEventAttendee}.
   * @return A new ImmutableEventAttendee builder
   */
  public static ImmutableEventAttendee.Builder builder() {
    return new ImmutableEventAttendee.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEventAttendee ImmutableEventAttendee}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CRUISE_RESERVATION_I_D = 0x1L;
    private static final long INIT_BIT_GUEST_I_D = 0x2L;
    private static final long INIT_BIT_SAILING_I_D = 0x4L;
    private static final long INIT_BIT_FIRST_NAME = 0x8L;
    private static final long INIT_BIT_LAST_NAME = 0x10L;
    private long initBits = 0x1fL;

    private @Nullable BigInteger cruiseReservationID;
    private @Nullable BigInteger guestID;
    private @Nullable String sailingID;
    private @Nullable String firstName;
    private @Nullable String lastName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EventAttendee} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EventAttendee instance) {
      Preconditions.checkNotNull(instance, "instance");
      cruiseReservationID(instance.cruiseReservationID());
      guestID(instance.guestID());
      sailingID(instance.sailingID());
      firstName(instance.firstName());
      lastName(instance.lastName());
      return this;
    }

    /**
     * Initializes the value for the {@link EventAttendee#cruiseReservationID() cruiseReservationID} attribute.
     * @param cruiseReservationID The value for cruiseReservationID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("cruiseReservationID")
    public final Builder cruiseReservationID(BigInteger cruiseReservationID) {
      this.cruiseReservationID = Preconditions.checkNotNull(cruiseReservationID, "cruiseReservationID");
      initBits &= ~INIT_BIT_CRUISE_RESERVATION_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link EventAttendee#guestID() guestID} attribute.
     * @param guestID The value for guestID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("guestID")
    public final Builder guestID(BigInteger guestID) {
      this.guestID = Preconditions.checkNotNull(guestID, "guestID");
      initBits &= ~INIT_BIT_GUEST_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link EventAttendee#sailingID() sailingID} attribute.
     * @param sailingID The value for sailingID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sailingID")
    public final Builder sailingID(String sailingID) {
      this.sailingID = Preconditions.checkNotNull(sailingID, "sailingID");
      initBits &= ~INIT_BIT_SAILING_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link EventAttendee#firstName() firstName} attribute.
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
     * Initializes the value for the {@link EventAttendee#lastName() lastName} attribute.
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
     * Builds a new {@link ImmutableEventAttendee ImmutableEventAttendee}.
     * @return An immutable instance of EventAttendee
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEventAttendee build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEventAttendee(cruiseReservationID, guestID, sailingID, firstName, lastName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CRUISE_RESERVATION_I_D) != 0) attributes.add("cruiseReservationID");
      if ((initBits & INIT_BIT_GUEST_I_D) != 0) attributes.add("guestID");
      if ((initBits & INIT_BIT_SAILING_I_D) != 0) attributes.add("sailingID");
      if ((initBits & INIT_BIT_FIRST_NAME) != 0) attributes.add("firstName");
      if ((initBits & INIT_BIT_LAST_NAME) != 0) attributes.add("lastName");
      return "Cannot build EventAttendee, some of required attributes are not set " + attributes;
    }
  }
}
