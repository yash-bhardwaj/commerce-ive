package com.rccl.cp.ive.update.dining.api.impl;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link DiningEventCommand.UpdateDiningEventCommand}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUpdateDiningEventCommand.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "DiningEventCommand.UpdateDiningEventCommand"})
@Immutable
public final class ImmutableUpdateDiningEventCommand
    implements DiningEventCommand.UpdateDiningEventCommand {
  private final DiningEventMessage message;

  private ImmutableUpdateDiningEventCommand(DiningEventMessage message) {
    this.message = message;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @Override
  public DiningEventMessage message() {
    return message;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DiningEventCommand.UpdateDiningEventCommand#message() message} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUpdateDiningEventCommand withMessage(DiningEventMessage value) {
    if (this.message == value) return this;
    DiningEventMessage newValue = Preconditions.checkNotNull(value, "message");
    return new ImmutableUpdateDiningEventCommand(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUpdateDiningEventCommand} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUpdateDiningEventCommand
        && equalTo((ImmutableUpdateDiningEventCommand) another);
  }

  private boolean equalTo(ImmutableUpdateDiningEventCommand another) {
    return message.equals(another.message);
  }

  /**
   * Computes a hash code from attributes: {@code message}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + message.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UpdateDiningEventCommand} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UpdateDiningEventCommand")
        .omitNullValues()
        .add("message", message)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link DiningEventCommand.UpdateDiningEventCommand} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UpdateDiningEventCommand instance
   */
  public static ImmutableUpdateDiningEventCommand copyOf(DiningEventCommand.UpdateDiningEventCommand instance) {
    if (instance instanceof ImmutableUpdateDiningEventCommand) {
      return (ImmutableUpdateDiningEventCommand) instance;
    }
    return ImmutableUpdateDiningEventCommand.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUpdateDiningEventCommand ImmutableUpdateDiningEventCommand}.
   * @return A new ImmutableUpdateDiningEventCommand builder
   */
  public static ImmutableUpdateDiningEventCommand.Builder builder() {
    return new ImmutableUpdateDiningEventCommand.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUpdateDiningEventCommand ImmutableUpdateDiningEventCommand}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_MESSAGE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable DiningEventMessage message;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UpdateDiningEventCommand} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DiningEventCommand.UpdateDiningEventCommand instance) {
      Preconditions.checkNotNull(instance, "instance");
      message(instance.message());
      return this;
    }

    /**
     * Initializes the value for the {@link DiningEventCommand.UpdateDiningEventCommand#message() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder message(DiningEventMessage message) {
      this.message = Preconditions.checkNotNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUpdateDiningEventCommand ImmutableUpdateDiningEventCommand}.
     * @return An immutable instance of UpdateDiningEventCommand
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUpdateDiningEventCommand build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUpdateDiningEventCommand(message);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      return "Cannot build UpdateDiningEventCommand, some of required attributes are not set " + attributes;
    }
  }
}
