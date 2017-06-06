package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CruisePlannerEventCommand.UpdateCruisePlannerEventCommand}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUpdateCruisePlannerEventCommand.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "CruisePlannerEventCommand.UpdateCruisePlannerEventCommand"})
@Immutable
public final class ImmutableUpdateCruisePlannerEventCommand
    implements CruisePlannerEventCommand.UpdateCruisePlannerEventCommand {
  private final CruisePlannerEventMessage message;

  private ImmutableUpdateCruisePlannerEventCommand(CruisePlannerEventMessage message) {
    this.message = message;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @Override
  public CruisePlannerEventMessage message() {
    return message;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CruisePlannerEventCommand.UpdateCruisePlannerEventCommand#message() message} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUpdateCruisePlannerEventCommand withMessage(CruisePlannerEventMessage value) {
    if (this.message == value) return this;
    CruisePlannerEventMessage newValue = Preconditions.checkNotNull(value, "message");
    return new ImmutableUpdateCruisePlannerEventCommand(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUpdateCruisePlannerEventCommand} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUpdateCruisePlannerEventCommand
        && equalTo((ImmutableUpdateCruisePlannerEventCommand) another);
  }

  private boolean equalTo(ImmutableUpdateCruisePlannerEventCommand another) {
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
   * Prints the immutable value {@code UpdateCruisePlannerEventCommand} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UpdateCruisePlannerEventCommand")
        .omitNullValues()
        .add("message", message)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link CruisePlannerEventCommand.UpdateCruisePlannerEventCommand} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UpdateCruisePlannerEventCommand instance
   */
  public static ImmutableUpdateCruisePlannerEventCommand copyOf(CruisePlannerEventCommand.UpdateCruisePlannerEventCommand instance) {
    if (instance instanceof ImmutableUpdateCruisePlannerEventCommand) {
      return (ImmutableUpdateCruisePlannerEventCommand) instance;
    }
    return ImmutableUpdateCruisePlannerEventCommand.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUpdateCruisePlannerEventCommand ImmutableUpdateCruisePlannerEventCommand}.
   * @return A new ImmutableUpdateCruisePlannerEventCommand builder
   */
  public static ImmutableUpdateCruisePlannerEventCommand.Builder builder() {
    return new ImmutableUpdateCruisePlannerEventCommand.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUpdateCruisePlannerEventCommand ImmutableUpdateCruisePlannerEventCommand}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_MESSAGE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable CruisePlannerEventMessage message;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UpdateCruisePlannerEventCommand} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CruisePlannerEventCommand.UpdateCruisePlannerEventCommand instance) {
      Preconditions.checkNotNull(instance, "instance");
      message(instance.message());
      return this;
    }

    /**
     * Initializes the value for the {@link CruisePlannerEventCommand.UpdateCruisePlannerEventCommand#message() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder message(CruisePlannerEventMessage message) {
      this.message = Preconditions.checkNotNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUpdateCruisePlannerEventCommand ImmutableUpdateCruisePlannerEventCommand}.
     * @return An immutable instance of UpdateCruisePlannerEventCommand
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUpdateCruisePlannerEventCommand build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUpdateCruisePlannerEventCommand(message);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      return "Cannot build UpdateCruisePlannerEventCommand, some of required attributes are not set " + attributes;
    }
  }
}
