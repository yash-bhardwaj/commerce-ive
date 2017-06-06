package com.rccl.cp.ive.update.cruiseplanner.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link StreamResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableStreamResponse.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "StreamResponse"})
@Immutable
public final class ImmutableStreamResponse implements StreamResponse {
  private final int code;
  private final String message;
  private final String streamStatusCode;
  private final String statusStatusMessage;
  private final long count;

  private ImmutableStreamResponse(
      int code,
      String message,
      String streamStatusCode,
      String statusStatusMessage,
      long count) {
    this.code = code;
    this.message = message;
    this.streamStatusCode = streamStatusCode;
    this.statusStatusMessage = statusStatusMessage;
    this.count = count;
  }

  /**
   * @return The value of the {@code code} attribute
   */
  @JsonProperty("code")
  @Override
  public int code() {
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
   * @return The value of the {@code streamStatusCode} attribute
   */
  @JsonProperty("streamStatusCode")
  @Override
  public String streamStatusCode() {
    return streamStatusCode;
  }

  /**
   * @return The value of the {@code statusStatusMessage} attribute
   */
  @JsonProperty("statusStatusMessage")
  @Override
  public String statusStatusMessage() {
    return statusStatusMessage;
  }

  /**
   * @return The value of the {@code count} attribute
   */
  @JsonProperty("count")
  @Override
  public long count() {
    return count;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StreamResponse#code() code} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for code
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStreamResponse withCode(int value) {
    if (this.code == value) return this;
    return new ImmutableStreamResponse(value, this.message, this.streamStatusCode, this.statusStatusMessage, this.count);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StreamResponse#message() message} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStreamResponse withMessage(String value) {
    if (this.message.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "message");
    return new ImmutableStreamResponse(this.code, newValue, this.streamStatusCode, this.statusStatusMessage, this.count);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StreamResponse#streamStatusCode() streamStatusCode} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for streamStatusCode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStreamResponse withStreamStatusCode(String value) {
    if (this.streamStatusCode.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "streamStatusCode");
    return new ImmutableStreamResponse(this.code, this.message, newValue, this.statusStatusMessage, this.count);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StreamResponse#statusStatusMessage() statusStatusMessage} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for statusStatusMessage
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStreamResponse withStatusStatusMessage(String value) {
    if (this.statusStatusMessage.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "statusStatusMessage");
    return new ImmutableStreamResponse(this.code, this.message, this.streamStatusCode, newValue, this.count);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StreamResponse#count() count} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for count
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableStreamResponse withCount(long value) {
    if (this.count == value) return this;
    return new ImmutableStreamResponse(this.code, this.message, this.streamStatusCode, this.statusStatusMessage, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableStreamResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableStreamResponse
        && equalTo((ImmutableStreamResponse) another);
  }

  private boolean equalTo(ImmutableStreamResponse another) {
    return code == another.code
        && message.equals(another.message)
        && streamStatusCode.equals(another.streamStatusCode)
        && statusStatusMessage.equals(another.statusStatusMessage)
        && count == another.count;
  }

  /**
   * Computes a hash code from attributes: {@code code}, {@code message}, {@code streamStatusCode}, {@code statusStatusMessage}, {@code count}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + code;
    h += (h << 5) + message.hashCode();
    h += (h << 5) + streamStatusCode.hashCode();
    h += (h << 5) + statusStatusMessage.hashCode();
    h += (h << 5) + Longs.hashCode(count);
    return h;
  }

  /**
   * Prints the immutable value {@code StreamResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("StreamResponse")
        .omitNullValues()
        .add("code", code)
        .add("message", message)
        .add("streamStatusCode", streamStatusCode)
        .add("statusStatusMessage", statusStatusMessage)
        .add("count", count)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements StreamResponse {
    int code;
    boolean codeIsSet;
    @Nullable String message;
    @Nullable String streamStatusCode;
    @Nullable String statusStatusMessage;
    long count;
    boolean countIsSet;
    @JsonProperty("code")
    public void setCode(int code) {
      this.code = code;
      this.codeIsSet = true;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
      this.message = message;
    }
    @JsonProperty("streamStatusCode")
    public void setStreamStatusCode(String streamStatusCode) {
      this.streamStatusCode = streamStatusCode;
    }
    @JsonProperty("statusStatusMessage")
    public void setStatusStatusMessage(String statusStatusMessage) {
      this.statusStatusMessage = statusStatusMessage;
    }
    @JsonProperty("count")
    public void setCount(long count) {
      this.count = count;
      this.countIsSet = true;
    }
    @Override
    public int code() { throw new UnsupportedOperationException(); }
    @Override
    public String message() { throw new UnsupportedOperationException(); }
    @Override
    public String streamStatusCode() { throw new UnsupportedOperationException(); }
    @Override
    public String statusStatusMessage() { throw new UnsupportedOperationException(); }
    @Override
    public long count() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableStreamResponse fromJson(Json json) {
    ImmutableStreamResponse.Builder builder = ImmutableStreamResponse.builder();
    if (json.codeIsSet) {
      builder.code(json.code);
    }
    if (json.message != null) {
      builder.message(json.message);
    }
    if (json.streamStatusCode != null) {
      builder.streamStatusCode(json.streamStatusCode);
    }
    if (json.statusStatusMessage != null) {
      builder.statusStatusMessage(json.statusStatusMessage);
    }
    if (json.countIsSet) {
      builder.count(json.count);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link StreamResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable StreamResponse instance
   */
  public static ImmutableStreamResponse copyOf(StreamResponse instance) {
    if (instance instanceof ImmutableStreamResponse) {
      return (ImmutableStreamResponse) instance;
    }
    return ImmutableStreamResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableStreamResponse ImmutableStreamResponse}.
   * @return A new ImmutableStreamResponse builder
   */
  public static ImmutableStreamResponse.Builder builder() {
    return new ImmutableStreamResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableStreamResponse ImmutableStreamResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CODE = 0x1L;
    private static final long INIT_BIT_MESSAGE = 0x2L;
    private static final long INIT_BIT_STREAM_STATUS_CODE = 0x4L;
    private static final long INIT_BIT_STATUS_STATUS_MESSAGE = 0x8L;
    private static final long INIT_BIT_COUNT = 0x10L;
    private long initBits = 0x1fL;

    private int code;
    private @Nullable String message;
    private @Nullable String streamStatusCode;
    private @Nullable String statusStatusMessage;
    private long count;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code StreamResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(StreamResponse instance) {
      Preconditions.checkNotNull(instance, "instance");
      code(instance.code());
      message(instance.message());
      streamStatusCode(instance.streamStatusCode());
      statusStatusMessage(instance.statusStatusMessage());
      count(instance.count());
      return this;
    }

    /**
     * Initializes the value for the {@link StreamResponse#code() code} attribute.
     * @param code The value for code 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("code")
    public final Builder code(int code) {
      this.code = code;
      initBits &= ~INIT_BIT_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link StreamResponse#message() message} attribute.
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
     * Initializes the value for the {@link StreamResponse#streamStatusCode() streamStatusCode} attribute.
     * @param streamStatusCode The value for streamStatusCode 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("streamStatusCode")
    public final Builder streamStatusCode(String streamStatusCode) {
      this.streamStatusCode = Preconditions.checkNotNull(streamStatusCode, "streamStatusCode");
      initBits &= ~INIT_BIT_STREAM_STATUS_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link StreamResponse#statusStatusMessage() statusStatusMessage} attribute.
     * @param statusStatusMessage The value for statusStatusMessage 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("statusStatusMessage")
    public final Builder statusStatusMessage(String statusStatusMessage) {
      this.statusStatusMessage = Preconditions.checkNotNull(statusStatusMessage, "statusStatusMessage");
      initBits &= ~INIT_BIT_STATUS_STATUS_MESSAGE;
      return this;
    }

    /**
     * Initializes the value for the {@link StreamResponse#count() count} attribute.
     * @param count The value for count 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("count")
    public final Builder count(long count) {
      this.count = count;
      initBits &= ~INIT_BIT_COUNT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableStreamResponse ImmutableStreamResponse}.
     * @return An immutable instance of StreamResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableStreamResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableStreamResponse(code, message, streamStatusCode, statusStatusMessage, count);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CODE) != 0) attributes.add("code");
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      if ((initBits & INIT_BIT_STREAM_STATUS_CODE) != 0) attributes.add("streamStatusCode");
      if ((initBits & INIT_BIT_STATUS_STATUS_MESSAGE) != 0) attributes.add("statusStatusMessage");
      if ((initBits & INIT_BIT_COUNT) != 0) attributes.add("count");
      return "Cannot build StreamResponse, some of required attributes are not set " + attributes;
    }
  }
}
