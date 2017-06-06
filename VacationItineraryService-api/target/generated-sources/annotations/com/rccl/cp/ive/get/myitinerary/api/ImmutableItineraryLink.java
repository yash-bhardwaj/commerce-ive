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
 * Immutable implementation of {@link ItineraryLink}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableItineraryLink.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ItineraryLink"})
@Immutable
public final class ImmutableItineraryLink implements ItineraryLink {
  private final String rel;
  private final String href;

  private ImmutableItineraryLink(String rel, String href) {
    this.rel = rel;
    this.href = href;
  }

  /**
   * @return The value of the {@code rel} attribute
   */
  @JsonProperty("rel")
  @Override
  public String rel() {
    return rel;
  }

  /**
   * @return The value of the {@code href} attribute
   */
  @JsonProperty("href")
  @Override
  public String href() {
    return href;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryLink#rel() rel} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for rel
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryLink withRel(String value) {
    if (this.rel.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "rel");
    return new ImmutableItineraryLink(newValue, this.href);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ItineraryLink#href() href} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for href
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableItineraryLink withHref(String value) {
    if (this.href.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "href");
    return new ImmutableItineraryLink(this.rel, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableItineraryLink} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableItineraryLink
        && equalTo((ImmutableItineraryLink) another);
  }

  private boolean equalTo(ImmutableItineraryLink another) {
    return rel.equals(another.rel)
        && href.equals(another.href);
  }

  /**
   * Computes a hash code from attributes: {@code rel}, {@code href}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + rel.hashCode();
    h += (h << 5) + href.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ItineraryLink} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ItineraryLink")
        .omitNullValues()
        .add("rel", rel)
        .add("href", href)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ItineraryLink {
    @Nullable String rel;
    @Nullable String href;
    @JsonProperty("rel")
    public void setRel(String rel) {
      this.rel = rel;
    }
    @JsonProperty("href")
    public void setHref(String href) {
      this.href = href;
    }
    @Override
    public String rel() { throw new UnsupportedOperationException(); }
    @Override
    public String href() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableItineraryLink fromJson(Json json) {
    ImmutableItineraryLink.Builder builder = ImmutableItineraryLink.builder();
    if (json.rel != null) {
      builder.rel(json.rel);
    }
    if (json.href != null) {
      builder.href(json.href);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ItineraryLink} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ItineraryLink instance
   */
  public static ImmutableItineraryLink copyOf(ItineraryLink instance) {
    if (instance instanceof ImmutableItineraryLink) {
      return (ImmutableItineraryLink) instance;
    }
    return ImmutableItineraryLink.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableItineraryLink ImmutableItineraryLink}.
   * @return A new ImmutableItineraryLink builder
   */
  public static ImmutableItineraryLink.Builder builder() {
    return new ImmutableItineraryLink.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableItineraryLink ImmutableItineraryLink}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_REL = 0x1L;
    private static final long INIT_BIT_HREF = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String rel;
    private @Nullable String href;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ItineraryLink} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ItineraryLink instance) {
      Preconditions.checkNotNull(instance, "instance");
      rel(instance.rel());
      href(instance.href());
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryLink#rel() rel} attribute.
     * @param rel The value for rel 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("rel")
    public final Builder rel(String rel) {
      this.rel = Preconditions.checkNotNull(rel, "rel");
      initBits &= ~INIT_BIT_REL;
      return this;
    }

    /**
     * Initializes the value for the {@link ItineraryLink#href() href} attribute.
     * @param href The value for href 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("href")
    public final Builder href(String href) {
      this.href = Preconditions.checkNotNull(href, "href");
      initBits &= ~INIT_BIT_HREF;
      return this;
    }

    /**
     * Builds a new {@link ImmutableItineraryLink ImmutableItineraryLink}.
     * @return An immutable instance of ItineraryLink
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableItineraryLink build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableItineraryLink(rel, href);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_REL) != 0) attributes.add("rel");
      if ((initBits & INIT_BIT_HREF) != 0) attributes.add("href");
      return "Cannot build ItineraryLink, some of required attributes are not set " + attributes;
    }
  }
}
