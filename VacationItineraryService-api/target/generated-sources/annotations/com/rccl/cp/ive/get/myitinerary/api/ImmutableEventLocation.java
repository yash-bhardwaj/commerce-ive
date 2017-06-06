package com.rccl.cp.ive.get.myitinerary.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link EventLocation}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEventLocation.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "EventLocation"})
@Immutable
public final class ImmutableEventLocation implements EventLocation {
  private final String locationCode;
  private final String locationType;
  private final @Nullable String locationName;

  private ImmutableEventLocation(
      String locationCode,
      String locationType,
      @Nullable String locationName) {
    this.locationCode = locationCode;
    this.locationType = locationType;
    this.locationName = locationName;
  }

  /**
   * @return The value of the {@code locationCode} attribute
   */
  @JsonProperty("locationCode")
  @Override
  public String locationCode() {
    return locationCode;
  }

  /**
   * @return The value of the {@code locationType} attribute
   */
  @JsonProperty("locationType")
  @Override
  public String locationType() {
    return locationType;
  }

  /**
   * @return The value of the {@code locationName} attribute
   */
  @JsonProperty("locationName")
  @Override
  public Optional<String> locationName() {
    return Optional.ofNullable(locationName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventLocation#locationCode() locationCode} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for locationCode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventLocation withLocationCode(String value) {
    if (this.locationCode.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "locationCode");
    return new ImmutableEventLocation(newValue, this.locationType, this.locationName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventLocation#locationType() locationType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for locationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventLocation withLocationType(String value) {
    if (this.locationType.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "locationType");
    return new ImmutableEventLocation(this.locationCode, newValue, this.locationName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link EventLocation#locationName() locationName} attribute.
   * @param value The value for locationName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventLocation withLocationName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "locationName");
    if (Objects.equal(this.locationName, newValue)) return this;
    return new ImmutableEventLocation(this.locationCode, this.locationType, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link EventLocation#locationName() locationName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for locationName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventLocation withLocationName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.locationName, value)) return this;
    return new ImmutableEventLocation(this.locationCode, this.locationType, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEventLocation} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEventLocation
        && equalTo((ImmutableEventLocation) another);
  }

  private boolean equalTo(ImmutableEventLocation another) {
    return locationCode.equals(another.locationCode)
        && locationType.equals(another.locationType)
        && Objects.equal(locationName, another.locationName);
  }

  /**
   * Computes a hash code from attributes: {@code locationCode}, {@code locationType}, {@code locationName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + locationCode.hashCode();
    h += (h << 5) + locationType.hashCode();
    h += (h << 5) + Objects.hashCode(locationName);
    return h;
  }

  /**
   * Prints the immutable value {@code EventLocation} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("EventLocation")
        .omitNullValues()
        .add("locationCode", locationCode)
        .add("locationType", locationType)
        .add("locationName", locationName)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements EventLocation {
    @Nullable String locationCode;
    @Nullable String locationType;
    Optional<String> locationName = Optional.empty();
    @JsonProperty("locationCode")
    public void setLocationCode(String locationCode) {
      this.locationCode = locationCode;
    }
    @JsonProperty("locationType")
    public void setLocationType(String locationType) {
      this.locationType = locationType;
    }
    @JsonProperty("locationName")
    public void setLocationName(Optional<String> locationName) {
      this.locationName = locationName;
    }
    @Override
    public String locationCode() { throw new UnsupportedOperationException(); }
    @Override
    public String locationType() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> locationName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEventLocation fromJson(Json json) {
    ImmutableEventLocation.Builder builder = ImmutableEventLocation.builder();
    if (json.locationCode != null) {
      builder.locationCode(json.locationCode);
    }
    if (json.locationType != null) {
      builder.locationType(json.locationType);
    }
    if (json.locationName != null) {
      builder.locationName(json.locationName);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EventLocation} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EventLocation instance
   */
  public static ImmutableEventLocation copyOf(EventLocation instance) {
    if (instance instanceof ImmutableEventLocation) {
      return (ImmutableEventLocation) instance;
    }
    return ImmutableEventLocation.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEventLocation ImmutableEventLocation}.
   * @return A new ImmutableEventLocation builder
   */
  public static ImmutableEventLocation.Builder builder() {
    return new ImmutableEventLocation.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEventLocation ImmutableEventLocation}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_LOCATION_CODE = 0x1L;
    private static final long INIT_BIT_LOCATION_TYPE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String locationCode;
    private @Nullable String locationType;
    private @Nullable String locationName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EventLocation} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EventLocation instance) {
      Preconditions.checkNotNull(instance, "instance");
      locationCode(instance.locationCode());
      locationType(instance.locationType());
      Optional<String> locationNameOptional = instance.locationName();
      if (locationNameOptional.isPresent()) {
        locationName(locationNameOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link EventLocation#locationCode() locationCode} attribute.
     * @param locationCode The value for locationCode 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("locationCode")
    public final Builder locationCode(String locationCode) {
      this.locationCode = Preconditions.checkNotNull(locationCode, "locationCode");
      initBits &= ~INIT_BIT_LOCATION_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link EventLocation#locationType() locationType} attribute.
     * @param locationType The value for locationType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("locationType")
    public final Builder locationType(String locationType) {
      this.locationType = Preconditions.checkNotNull(locationType, "locationType");
      initBits &= ~INIT_BIT_LOCATION_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link EventLocation#locationName() locationName} to locationName.
     * @param locationName The value for locationName
     * @return {@code this} builder for chained invocation
     */
    public final Builder locationName(String locationName) {
      this.locationName = Preconditions.checkNotNull(locationName, "locationName");
      return this;
    }

    /**
     * Initializes the optional value {@link EventLocation#locationName() locationName} to locationName.
     * @param locationName The value for locationName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("locationName")
    public final Builder locationName(Optional<String> locationName) {
      this.locationName = locationName.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableEventLocation ImmutableEventLocation}.
     * @return An immutable instance of EventLocation
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEventLocation build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEventLocation(locationCode, locationType, locationName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_LOCATION_CODE) != 0) attributes.add("locationCode");
      if ((initBits & INIT_BIT_LOCATION_TYPE) != 0) attributes.add("locationType");
      return "Cannot build EventLocation, some of required attributes are not set " + attributes;
    }
  }
}
