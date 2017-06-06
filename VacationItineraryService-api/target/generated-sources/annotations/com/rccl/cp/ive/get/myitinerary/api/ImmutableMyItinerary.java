package com.rccl.cp.ive.get.myitinerary.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link MyItinerary}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableMyItinerary.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "MyItinerary"})
@Immutable
public final class ImmutableMyItinerary implements MyItinerary {
  private final BigInteger cruiseReservationID;
  private final BigInteger guestID;
  private final String sailingID;
  private final String firstName;
  private final String lastName;
  private final ImmutableList<ItineraryEventGroup> itineraryEventGroups;

  private ImmutableMyItinerary(
      BigInteger cruiseReservationID,
      BigInteger guestID,
      String sailingID,
      String firstName,
      String lastName,
      ImmutableList<ItineraryEventGroup> itineraryEventGroups) {
    this.cruiseReservationID = cruiseReservationID;
    this.guestID = guestID;
    this.sailingID = sailingID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.itineraryEventGroups = itineraryEventGroups;
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
   * @return The value of the {@code itineraryEventGroups} attribute
   */
  @JsonProperty("itineraryEventGroups")
  @Override
  public ImmutableList<ItineraryEventGroup> itineraryEventGroups() {
    return itineraryEventGroups;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MyItinerary#cruiseReservationID() cruiseReservationID} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for cruiseReservationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMyItinerary withCruiseReservationID(BigInteger value) {
    if (this.cruiseReservationID == value) return this;
    BigInteger newValue = Preconditions.checkNotNull(value, "cruiseReservationID");
    return new ImmutableMyItinerary(
        newValue,
        this.guestID,
        this.sailingID,
        this.firstName,
        this.lastName,
        this.itineraryEventGroups);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MyItinerary#guestID() guestID} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for guestID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMyItinerary withGuestID(BigInteger value) {
    if (this.guestID == value) return this;
    BigInteger newValue = Preconditions.checkNotNull(value, "guestID");
    return new ImmutableMyItinerary(
        this.cruiseReservationID,
        newValue,
        this.sailingID,
        this.firstName,
        this.lastName,
        this.itineraryEventGroups);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MyItinerary#sailingID() sailingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sailingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMyItinerary withSailingID(String value) {
    if (this.sailingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sailingID");
    return new ImmutableMyItinerary(
        this.cruiseReservationID,
        this.guestID,
        newValue,
        this.firstName,
        this.lastName,
        this.itineraryEventGroups);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MyItinerary#firstName() firstName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for firstName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMyItinerary withFirstName(String value) {
    if (this.firstName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "firstName");
    return new ImmutableMyItinerary(
        this.cruiseReservationID,
        this.guestID,
        this.sailingID,
        newValue,
        this.lastName,
        this.itineraryEventGroups);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MyItinerary#lastName() lastName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for lastName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMyItinerary withLastName(String value) {
    if (this.lastName.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "lastName");
    return new ImmutableMyItinerary(
        this.cruiseReservationID,
        this.guestID,
        this.sailingID,
        this.firstName,
        newValue,
        this.itineraryEventGroups);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MyItinerary#itineraryEventGroups() itineraryEventGroups}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMyItinerary withItineraryEventGroups(ItineraryEventGroup... elements) {
    ImmutableList<ItineraryEventGroup> newValue = ImmutableList.copyOf(elements);
    return new ImmutableMyItinerary(this.cruiseReservationID, this.guestID, this.sailingID, this.firstName, this.lastName, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MyItinerary#itineraryEventGroups() itineraryEventGroups}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of itineraryEventGroups elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMyItinerary withItineraryEventGroups(Iterable<? extends ItineraryEventGroup> elements) {
    if (this.itineraryEventGroups == elements) return this;
    ImmutableList<ItineraryEventGroup> newValue = ImmutableList.copyOf(elements);
    return new ImmutableMyItinerary(this.cruiseReservationID, this.guestID, this.sailingID, this.firstName, this.lastName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableMyItinerary} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableMyItinerary
        && equalTo((ImmutableMyItinerary) another);
  }

  private boolean equalTo(ImmutableMyItinerary another) {
    return cruiseReservationID.equals(another.cruiseReservationID)
        && guestID.equals(another.guestID)
        && sailingID.equals(another.sailingID)
        && firstName.equals(another.firstName)
        && lastName.equals(another.lastName)
        && itineraryEventGroups.equals(another.itineraryEventGroups);
  }

  /**
   * Computes a hash code from attributes: {@code cruiseReservationID}, {@code guestID}, {@code sailingID}, {@code firstName}, {@code lastName}, {@code itineraryEventGroups}.
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
    h += (h << 5) + itineraryEventGroups.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code MyItinerary} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("MyItinerary")
        .omitNullValues()
        .add("cruiseReservationID", cruiseReservationID)
        .add("guestID", guestID)
        .add("sailingID", sailingID)
        .add("firstName", firstName)
        .add("lastName", lastName)
        .add("itineraryEventGroups", itineraryEventGroups)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements MyItinerary {
    @Nullable BigInteger cruiseReservationID;
    @Nullable BigInteger guestID;
    @Nullable String sailingID;
    @Nullable String firstName;
    @Nullable String lastName;
    List<ItineraryEventGroup> itineraryEventGroups = ImmutableList.of();
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
    @JsonProperty("itineraryEventGroups")
    public void setItineraryEventGroups(List<ItineraryEventGroup> itineraryEventGroups) {
      this.itineraryEventGroups = itineraryEventGroups;
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
    @Override
    public List<ItineraryEventGroup> itineraryEventGroups() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableMyItinerary fromJson(Json json) {
    ImmutableMyItinerary.Builder builder = ImmutableMyItinerary.builder();
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
    if (json.itineraryEventGroups != null) {
      builder.addAllItineraryEventGroups(json.itineraryEventGroups);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link MyItinerary} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable MyItinerary instance
   */
  public static ImmutableMyItinerary copyOf(MyItinerary instance) {
    if (instance instanceof ImmutableMyItinerary) {
      return (ImmutableMyItinerary) instance;
    }
    return ImmutableMyItinerary.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableMyItinerary ImmutableMyItinerary}.
   * @return A new ImmutableMyItinerary builder
   */
  public static ImmutableMyItinerary.Builder builder() {
    return new ImmutableMyItinerary.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableMyItinerary ImmutableMyItinerary}.
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
    private ImmutableList.Builder<ItineraryEventGroup> itineraryEventGroups = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code MyItinerary} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(MyItinerary instance) {
      Preconditions.checkNotNull(instance, "instance");
      cruiseReservationID(instance.cruiseReservationID());
      guestID(instance.guestID());
      sailingID(instance.sailingID());
      firstName(instance.firstName());
      lastName(instance.lastName());
      addAllItineraryEventGroups(instance.itineraryEventGroups());
      return this;
    }

    /**
     * Initializes the value for the {@link MyItinerary#cruiseReservationID() cruiseReservationID} attribute.
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
     * Initializes the value for the {@link MyItinerary#guestID() guestID} attribute.
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
     * Initializes the value for the {@link MyItinerary#sailingID() sailingID} attribute.
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
     * Initializes the value for the {@link MyItinerary#firstName() firstName} attribute.
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
     * Initializes the value for the {@link MyItinerary#lastName() lastName} attribute.
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
     * Adds one element to {@link MyItinerary#itineraryEventGroups() itineraryEventGroups} list.
     * @param element A itineraryEventGroups element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addItineraryEventGroups(ItineraryEventGroup element) {
      this.itineraryEventGroups.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MyItinerary#itineraryEventGroups() itineraryEventGroups} list.
     * @param elements An array of itineraryEventGroups elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addItineraryEventGroups(ItineraryEventGroup... elements) {
      this.itineraryEventGroups.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link MyItinerary#itineraryEventGroups() itineraryEventGroups} list.
     * @param elements An iterable of itineraryEventGroups elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("itineraryEventGroups")
    public final Builder itineraryEventGroups(Iterable<? extends ItineraryEventGroup> elements) {
      this.itineraryEventGroups = ImmutableList.builder();
      return addAllItineraryEventGroups(elements);
    }

    /**
     * Adds elements to {@link MyItinerary#itineraryEventGroups() itineraryEventGroups} list.
     * @param elements An iterable of itineraryEventGroups elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllItineraryEventGroups(Iterable<? extends ItineraryEventGroup> elements) {
      this.itineraryEventGroups.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableMyItinerary ImmutableMyItinerary}.
     * @return An immutable instance of MyItinerary
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableMyItinerary build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableMyItinerary(cruiseReservationID, guestID, sailingID, firstName, lastName, itineraryEventGroups.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CRUISE_RESERVATION_I_D) != 0) attributes.add("cruiseReservationID");
      if ((initBits & INIT_BIT_GUEST_I_D) != 0) attributes.add("guestID");
      if ((initBits & INIT_BIT_SAILING_I_D) != 0) attributes.add("sailingID");
      if ((initBits & INIT_BIT_FIRST_NAME) != 0) attributes.add("firstName");
      if ((initBits & INIT_BIT_LAST_NAME) != 0) attributes.add("lastName");
      return "Cannot build MyItinerary, some of required attributes are not set " + attributes;
    }
  }
}
