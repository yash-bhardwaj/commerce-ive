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
 * Immutable implementation of {@link Error}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableError.builder()}.
 */
@SuppressWarnings({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION", "all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "Error"})
@Immutable
public final class ImmutableError implements Error {
  private final Integer code;
  private final String message;
  private final String fields;

  private ImmutableError(Integer code, String message, String fields) {
    this.code = code;
    this.message = message;
    this.fields = fields;
  }

  /**
   * @return The value of the {@code code} attribute
   */
  @JsonProperty("code")
  @Override
  public Integer code() {
    return code;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("message")
  @Override
  public String message() {
    return message;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @JsonProperty("fields")
  @Override
  public String fields() {
    return fields;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Error#code() code} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for code
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableError withCode(Integer value) {
    if (this.code.equals(value)) return this;
    Integer newValue = Preconditions.checkNotNull(value, "code");
    return new ImmutableError(newValue, this.message, this.fields);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Error#message() message} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableError withMessage(String value) {
    if (this.message.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "message");
    return new ImmutableError(this.code, newValue, this.fields);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Error#fields() fields} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for fields
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableError withFields(String value) {
    if (this.fields.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "fields");
    return new ImmutableError(this.code, this.message, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableError} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableError
        && equalTo((ImmutableError) another);
  }

  private boolean equalTo(ImmutableError another) {
    return code.equals(another.code)
        && message.equals(another.message)
        && fields.equals(another.fields);
  }

  /**
   * Computes a hash code from attributes: {@code code}, {@code message}, {@code fields}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + code.hashCode();
    h += (h << 5) + message.hashCode();
    h += (h << 5) + fields.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Error} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Error")
        .omitNullValues()
        .add("code", code)
        .add("message", message)
        .add("fields", fields)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Error {
    @Nullable Integer code;
    @Nullable String message;
    @Nullable String fields;
    @JsonProperty("code")
    public void setCode(Integer code) {
      this.code = code;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
      this.message = message;
    }
    @JsonProperty("fields")
    public void setFields(String fields) {
      this.fields = fields;
    }
    @Override
    public Integer code() { throw new UnsupportedOperationException(); }
    @Override
    public String message() { throw new UnsupportedOperationException(); }
    @Override
    public String fields() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableError fromJson(Json json) {
    ImmutableError.Builder builder = ImmutableError.builder();
    if (json.code != null) {
      builder.code(json.code);
    }
    if (json.message != null) {
      builder.message(json.message);
    }
    if (json.fields != null) {
      builder.fields(json.fields);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Error} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Error instance
   */
  public static ImmutableError copyOf(Error instance) {
    if (instance instanceof ImmutableError) {
      return (ImmutableError) instance;
    }
    return ImmutableError.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableError ImmutableError}.
   * @return A new ImmutableError builder
   */
  public static ImmutableError.Builder builder() {
    return new ImmutableError.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableError ImmutableError}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CODE = 0x1L;
    private static final long INIT_BIT_MESSAGE = 0x2L;
    private static final long INIT_BIT_FIELDS = 0x4L;
    private long initBits = 0x7L;

    private @Nullable Integer code;
    private @Nullable String message;
    private @Nullable String fields;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Error} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Error instance) {
      Preconditions.checkNotNull(instance, "instance");
      code(instance.code());
      message(instance.message());
      fields(instance.fields());
      return this;
    }

    /**
     * Initializes the value for the {@link Error#code() code} attribute.
     * @param code The value for code 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("code")
    public final Builder code(Integer code) {
      this.code = Preconditions.checkNotNull(code, "code");
      initBits &= ~INIT_BIT_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link Error#message() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("message")
    public final Builder message(String message) {
      this.message = Preconditions.checkNotNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Initializes the value for the {@link Error#fields() fields} attribute.
     * @param fields The value for fields 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("fields")
    public final Builder fields(String fields) {
      this.fields = Preconditions.checkNotNull(fields, "fields");
      initBits &= ~INIT_BIT_FIELDS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableError ImmutableError}.
     * @return An immutable instance of Error
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableError build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableError(code, message, fields);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CODE) != 0) attributes.add("code");
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      if ((initBits & INIT_BIT_FIELDS) != 0) attributes.add("fields");
      return "Cannot build Error, some of required attributes are not set " + attributes;
    }
  }
}
