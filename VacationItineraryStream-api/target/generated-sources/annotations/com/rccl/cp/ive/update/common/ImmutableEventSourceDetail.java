package com.rccl.cp.ive.update.common;

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
 * Immutable implementation of {@link EventSourceDetail}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEventSourceDetail.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "EventSourceDetail"})
@Immutable
public final class ImmutableEventSourceDetail implements EventSourceDetail {
  private final String sourceSystemReservationID;
  private final String sourceSystemApplicationID;
  private final String sourceSystemOfferingID;
  private final @Nullable String sourceSystemOrderID;
  private final @Nullable String sourceSystemExternalOrderID;
  private final @Nullable String sourceSystemProductID;
  private final @Nullable String sourceSystemProductName;

  private ImmutableEventSourceDetail(
      String sourceSystemReservationID,
      String sourceSystemApplicationID,
      String sourceSystemOfferingID,
      @Nullable String sourceSystemOrderID,
      @Nullable String sourceSystemExternalOrderID,
      @Nullable String sourceSystemProductID,
      @Nullable String sourceSystemProductName) {
    this.sourceSystemReservationID = sourceSystemReservationID;
    this.sourceSystemApplicationID = sourceSystemApplicationID;
    this.sourceSystemOfferingID = sourceSystemOfferingID;
    this.sourceSystemOrderID = sourceSystemOrderID;
    this.sourceSystemExternalOrderID = sourceSystemExternalOrderID;
    this.sourceSystemProductID = sourceSystemProductID;
    this.sourceSystemProductName = sourceSystemProductName;
  }

  /**
   * @return The value of the {@code sourceSystemReservationID} attribute
   */
  @JsonProperty("sourceSystemReservationID")
  @Override
  public String sourceSystemReservationID() {
    return sourceSystemReservationID;
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
   * @return The value of the {@code sourceSystemOrderID} attribute
   */
  @JsonProperty("sourceSystemOrderID")
  @Override
  public Optional<String> sourceSystemOrderID() {
    return Optional.ofNullable(sourceSystemOrderID);
  }

  /**
   * @return The value of the {@code sourceSystemExternalOrderID} attribute
   */
  @JsonProperty("sourceSystemExternalOrderID")
  @Override
  public Optional<String> sourceSystemExternalOrderID() {
    return Optional.ofNullable(sourceSystemExternalOrderID);
  }

  /**
   * @return The value of the {@code sourceSystemProductID} attribute
   */
  @JsonProperty("sourceSystemProductID")
  @Override
  public Optional<String> sourceSystemProductID() {
    return Optional.ofNullable(sourceSystemProductID);
  }

  /**
   * @return The value of the {@code sourceSystemProductName} attribute
   */
  @JsonProperty("sourceSystemProductName")
  @Override
  public Optional<String> sourceSystemProductName() {
    return Optional.ofNullable(sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventSourceDetail#sourceSystemReservationID() sourceSystemReservationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemReservationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemReservationID(String value) {
    if (this.sourceSystemReservationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemReservationID");
    return new ImmutableEventSourceDetail(
        newValue,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventSourceDetail#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemApplicationID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemApplicationID(String value) {
    if (this.sourceSystemApplicationID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemApplicationID");
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        newValue,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EventSourceDetail#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sourceSystemOfferingID
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemOfferingID(String value) {
    if (this.sourceSystemOfferingID.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "sourceSystemOfferingID");
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        newValue,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link EventSourceDetail#sourceSystemOrderID() sourceSystemOrderID} attribute.
   * @param value The value for sourceSystemOrderID
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemOrderID(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "sourceSystemOrderID");
    if (Objects.equal(this.sourceSystemOrderID, newValue)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        newValue,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link EventSourceDetail#sourceSystemOrderID() sourceSystemOrderID} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceSystemOrderID
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemOrderID(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.sourceSystemOrderID, value)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        value,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link EventSourceDetail#sourceSystemExternalOrderID() sourceSystemExternalOrderID} attribute.
   * @param value The value for sourceSystemExternalOrderID
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemExternalOrderID(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "sourceSystemExternalOrderID");
    if (Objects.equal(this.sourceSystemExternalOrderID, newValue)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        newValue,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link EventSourceDetail#sourceSystemExternalOrderID() sourceSystemExternalOrderID} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceSystemExternalOrderID
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemExternalOrderID(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.sourceSystemExternalOrderID, value)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        value,
        this.sourceSystemProductID,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link EventSourceDetail#sourceSystemProductID() sourceSystemProductID} attribute.
   * @param value The value for sourceSystemProductID
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemProductID(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "sourceSystemProductID");
    if (Objects.equal(this.sourceSystemProductID, newValue)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        newValue,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link EventSourceDetail#sourceSystemProductID() sourceSystemProductID} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceSystemProductID
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemProductID(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.sourceSystemProductID, value)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        value,
        this.sourceSystemProductName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link EventSourceDetail#sourceSystemProductName() sourceSystemProductName} attribute.
   * @param value The value for sourceSystemProductName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemProductName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "sourceSystemProductName");
    if (Objects.equal(this.sourceSystemProductName, newValue)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link EventSourceDetail#sourceSystemProductName() sourceSystemProductName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceSystemProductName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEventSourceDetail withSourceSystemProductName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.sourceSystemProductName, value)) return this;
    return new ImmutableEventSourceDetail(
        this.sourceSystemReservationID,
        this.sourceSystemApplicationID,
        this.sourceSystemOfferingID,
        this.sourceSystemOrderID,
        this.sourceSystemExternalOrderID,
        this.sourceSystemProductID,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEventSourceDetail} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEventSourceDetail
        && equalTo((ImmutableEventSourceDetail) another);
  }

  private boolean equalTo(ImmutableEventSourceDetail another) {
    return sourceSystemReservationID.equals(another.sourceSystemReservationID)
        && sourceSystemApplicationID.equals(another.sourceSystemApplicationID)
        && sourceSystemOfferingID.equals(another.sourceSystemOfferingID)
        && Objects.equal(sourceSystemOrderID, another.sourceSystemOrderID)
        && Objects.equal(sourceSystemExternalOrderID, another.sourceSystemExternalOrderID)
        && Objects.equal(sourceSystemProductID, another.sourceSystemProductID)
        && Objects.equal(sourceSystemProductName, another.sourceSystemProductName);
  }

  /**
   * Computes a hash code from attributes: {@code sourceSystemReservationID}, {@code sourceSystemApplicationID}, {@code sourceSystemOfferingID}, {@code sourceSystemOrderID}, {@code sourceSystemExternalOrderID}, {@code sourceSystemProductID}, {@code sourceSystemProductName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + sourceSystemReservationID.hashCode();
    h += (h << 5) + sourceSystemApplicationID.hashCode();
    h += (h << 5) + sourceSystemOfferingID.hashCode();
    h += (h << 5) + Objects.hashCode(sourceSystemOrderID);
    h += (h << 5) + Objects.hashCode(sourceSystemExternalOrderID);
    h += (h << 5) + Objects.hashCode(sourceSystemProductID);
    h += (h << 5) + Objects.hashCode(sourceSystemProductName);
    return h;
  }

  /**
   * Prints the immutable value {@code EventSourceDetail} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("EventSourceDetail")
        .omitNullValues()
        .add("sourceSystemReservationID", sourceSystemReservationID)
        .add("sourceSystemApplicationID", sourceSystemApplicationID)
        .add("sourceSystemOfferingID", sourceSystemOfferingID)
        .add("sourceSystemOrderID", sourceSystemOrderID)
        .add("sourceSystemExternalOrderID", sourceSystemExternalOrderID)
        .add("sourceSystemProductID", sourceSystemProductID)
        .add("sourceSystemProductName", sourceSystemProductName)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements EventSourceDetail {
    @Nullable String sourceSystemReservationID;
    @Nullable String sourceSystemApplicationID;
    @Nullable String sourceSystemOfferingID;
    Optional<String> sourceSystemOrderID = Optional.empty();
    Optional<String> sourceSystemExternalOrderID = Optional.empty();
    Optional<String> sourceSystemProductID = Optional.empty();
    Optional<String> sourceSystemProductName = Optional.empty();
    @JsonProperty("sourceSystemReservationID")
    public void setSourceSystemReservationID(String sourceSystemReservationID) {
      this.sourceSystemReservationID = sourceSystemReservationID;
    }
    @JsonProperty("sourceSystemApplicationID")
    public void setSourceSystemApplicationID(String sourceSystemApplicationID) {
      this.sourceSystemApplicationID = sourceSystemApplicationID;
    }
    @JsonProperty("sourceSystemOfferingID")
    public void setSourceSystemOfferingID(String sourceSystemOfferingID) {
      this.sourceSystemOfferingID = sourceSystemOfferingID;
    }
    @JsonProperty("sourceSystemOrderID")
    public void setSourceSystemOrderID(Optional<String> sourceSystemOrderID) {
      this.sourceSystemOrderID = sourceSystemOrderID;
    }
    @JsonProperty("sourceSystemExternalOrderID")
    public void setSourceSystemExternalOrderID(Optional<String> sourceSystemExternalOrderID) {
      this.sourceSystemExternalOrderID = sourceSystemExternalOrderID;
    }
    @JsonProperty("sourceSystemProductID")
    public void setSourceSystemProductID(Optional<String> sourceSystemProductID) {
      this.sourceSystemProductID = sourceSystemProductID;
    }
    @JsonProperty("sourceSystemProductName")
    public void setSourceSystemProductName(Optional<String> sourceSystemProductName) {
      this.sourceSystemProductName = sourceSystemProductName;
    }
    @Override
    public String sourceSystemReservationID() { throw new UnsupportedOperationException(); }
    @Override
    public String sourceSystemApplicationID() { throw new UnsupportedOperationException(); }
    @Override
    public String sourceSystemOfferingID() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> sourceSystemOrderID() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> sourceSystemExternalOrderID() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> sourceSystemProductID() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> sourceSystemProductName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEventSourceDetail fromJson(Json json) {
    ImmutableEventSourceDetail.Builder builder = ImmutableEventSourceDetail.builder();
    if (json.sourceSystemReservationID != null) {
      builder.sourceSystemReservationID(json.sourceSystemReservationID);
    }
    if (json.sourceSystemApplicationID != null) {
      builder.sourceSystemApplicationID(json.sourceSystemApplicationID);
    }
    if (json.sourceSystemOfferingID != null) {
      builder.sourceSystemOfferingID(json.sourceSystemOfferingID);
    }
    if (json.sourceSystemOrderID != null) {
      builder.sourceSystemOrderID(json.sourceSystemOrderID);
    }
    if (json.sourceSystemExternalOrderID != null) {
      builder.sourceSystemExternalOrderID(json.sourceSystemExternalOrderID);
    }
    if (json.sourceSystemProductID != null) {
      builder.sourceSystemProductID(json.sourceSystemProductID);
    }
    if (json.sourceSystemProductName != null) {
      builder.sourceSystemProductName(json.sourceSystemProductName);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EventSourceDetail} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EventSourceDetail instance
   */
  public static ImmutableEventSourceDetail copyOf(EventSourceDetail instance) {
    if (instance instanceof ImmutableEventSourceDetail) {
      return (ImmutableEventSourceDetail) instance;
    }
    return ImmutableEventSourceDetail.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEventSourceDetail ImmutableEventSourceDetail}.
   * @return A new ImmutableEventSourceDetail builder
   */
  public static ImmutableEventSourceDetail.Builder builder() {
    return new ImmutableEventSourceDetail.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEventSourceDetail ImmutableEventSourceDetail}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SOURCE_SYSTEM_RESERVATION_I_D = 0x1L;
    private static final long INIT_BIT_SOURCE_SYSTEM_APPLICATION_I_D = 0x2L;
    private static final long INIT_BIT_SOURCE_SYSTEM_OFFERING_I_D = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String sourceSystemReservationID;
    private @Nullable String sourceSystemApplicationID;
    private @Nullable String sourceSystemOfferingID;
    private @Nullable String sourceSystemOrderID;
    private @Nullable String sourceSystemExternalOrderID;
    private @Nullable String sourceSystemProductID;
    private @Nullable String sourceSystemProductName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EventSourceDetail} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EventSourceDetail instance) {
      Preconditions.checkNotNull(instance, "instance");
      sourceSystemReservationID(instance.sourceSystemReservationID());
      sourceSystemApplicationID(instance.sourceSystemApplicationID());
      sourceSystemOfferingID(instance.sourceSystemOfferingID());
      Optional<String> sourceSystemOrderIDOptional = instance.sourceSystemOrderID();
      if (sourceSystemOrderIDOptional.isPresent()) {
        sourceSystemOrderID(sourceSystemOrderIDOptional);
      }
      Optional<String> sourceSystemExternalOrderIDOptional = instance.sourceSystemExternalOrderID();
      if (sourceSystemExternalOrderIDOptional.isPresent()) {
        sourceSystemExternalOrderID(sourceSystemExternalOrderIDOptional);
      }
      Optional<String> sourceSystemProductIDOptional = instance.sourceSystemProductID();
      if (sourceSystemProductIDOptional.isPresent()) {
        sourceSystemProductID(sourceSystemProductIDOptional);
      }
      Optional<String> sourceSystemProductNameOptional = instance.sourceSystemProductName();
      if (sourceSystemProductNameOptional.isPresent()) {
        sourceSystemProductName(sourceSystemProductNameOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link EventSourceDetail#sourceSystemReservationID() sourceSystemReservationID} attribute.
     * @param sourceSystemReservationID The value for sourceSystemReservationID 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemReservationID")
    public final Builder sourceSystemReservationID(String sourceSystemReservationID) {
      this.sourceSystemReservationID = Preconditions.checkNotNull(sourceSystemReservationID, "sourceSystemReservationID");
      initBits &= ~INIT_BIT_SOURCE_SYSTEM_RESERVATION_I_D;
      return this;
    }

    /**
     * Initializes the value for the {@link EventSourceDetail#sourceSystemApplicationID() sourceSystemApplicationID} attribute.
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
     * Initializes the value for the {@link EventSourceDetail#sourceSystemOfferingID() sourceSystemOfferingID} attribute.
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
     * Initializes the optional value {@link EventSourceDetail#sourceSystemOrderID() sourceSystemOrderID} to sourceSystemOrderID.
     * @param sourceSystemOrderID The value for sourceSystemOrderID
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceSystemOrderID(String sourceSystemOrderID) {
      this.sourceSystemOrderID = Preconditions.checkNotNull(sourceSystemOrderID, "sourceSystemOrderID");
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemOrderID() sourceSystemOrderID} to sourceSystemOrderID.
     * @param sourceSystemOrderID The value for sourceSystemOrderID
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemOrderID")
    public final Builder sourceSystemOrderID(Optional<String> sourceSystemOrderID) {
      this.sourceSystemOrderID = sourceSystemOrderID.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemExternalOrderID() sourceSystemExternalOrderID} to sourceSystemExternalOrderID.
     * @param sourceSystemExternalOrderID The value for sourceSystemExternalOrderID
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceSystemExternalOrderID(String sourceSystemExternalOrderID) {
      this.sourceSystemExternalOrderID = Preconditions.checkNotNull(sourceSystemExternalOrderID, "sourceSystemExternalOrderID");
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemExternalOrderID() sourceSystemExternalOrderID} to sourceSystemExternalOrderID.
     * @param sourceSystemExternalOrderID The value for sourceSystemExternalOrderID
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemExternalOrderID")
    public final Builder sourceSystemExternalOrderID(Optional<String> sourceSystemExternalOrderID) {
      this.sourceSystemExternalOrderID = sourceSystemExternalOrderID.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemProductID() sourceSystemProductID} to sourceSystemProductID.
     * @param sourceSystemProductID The value for sourceSystemProductID
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceSystemProductID(String sourceSystemProductID) {
      this.sourceSystemProductID = Preconditions.checkNotNull(sourceSystemProductID, "sourceSystemProductID");
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemProductID() sourceSystemProductID} to sourceSystemProductID.
     * @param sourceSystemProductID The value for sourceSystemProductID
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemProductID")
    public final Builder sourceSystemProductID(Optional<String> sourceSystemProductID) {
      this.sourceSystemProductID = sourceSystemProductID.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemProductName() sourceSystemProductName} to sourceSystemProductName.
     * @param sourceSystemProductName The value for sourceSystemProductName
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceSystemProductName(String sourceSystemProductName) {
      this.sourceSystemProductName = Preconditions.checkNotNull(sourceSystemProductName, "sourceSystemProductName");
      return this;
    }

    /**
     * Initializes the optional value {@link EventSourceDetail#sourceSystemProductName() sourceSystemProductName} to sourceSystemProductName.
     * @param sourceSystemProductName The value for sourceSystemProductName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sourceSystemProductName")
    public final Builder sourceSystemProductName(Optional<String> sourceSystemProductName) {
      this.sourceSystemProductName = sourceSystemProductName.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableEventSourceDetail ImmutableEventSourceDetail}.
     * @return An immutable instance of EventSourceDetail
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEventSourceDetail build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEventSourceDetail(
          sourceSystemReservationID,
          sourceSystemApplicationID,
          sourceSystemOfferingID,
          sourceSystemOrderID,
          sourceSystemExternalOrderID,
          sourceSystemProductID,
          sourceSystemProductName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_SOURCE_SYSTEM_RESERVATION_I_D) != 0) attributes.add("sourceSystemReservationID");
      if ((initBits & INIT_BIT_SOURCE_SYSTEM_APPLICATION_I_D) != 0) attributes.add("sourceSystemApplicationID");
      if ((initBits & INIT_BIT_SOURCE_SYSTEM_OFFERING_I_D) != 0) attributes.add("sourceSystemOfferingID");
      return "Cannot build EventSourceDetail, some of required attributes are not set " + attributes;
    }
  }
}
