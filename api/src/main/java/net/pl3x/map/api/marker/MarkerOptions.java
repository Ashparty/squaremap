package net.pl3x.map.api.marker;

import java.awt.Color;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Class holding options for map markers
 *
 * <p>Note that not all options are applicable to all marker types</p>
 *
 * <p>Many of these options mirror those found in the leaflet path options, see the link below for reference</p>
 *
 * @see <a href="https://leafletjs.com/reference-1.7.1.html#path">https://leafletjs.com/reference-1.7.1.html#path</a>
 */
public final class MarkerOptions {

    private static final MarkerOptions DEFAULT_OPTIONS = builder().build();

    private final boolean stroke;
    private final Color strokeColor;
    private final int strokeWeight;
    private final double strokeOpacity;
    private final boolean fill;
    private final Color fillColor;
    private final double fillOpacity;
    private final FillRule fillRule;
    private final String clickTooltip;
    private final String hoverTooltip;

    private MarkerOptions(
        final boolean stroke,
        final @NonNull Color strokeColor,
        final int strokeWeight,
        final double strokeOpacity,
        final boolean fill,
        final @Nullable Color fillColor,
        final double fillOpacity,
        final @NonNull FillRule fillRule,
        final @Nullable String clickTooltip,
        final @Nullable String hoverTooltip
    ) {
        this.stroke = stroke;
        this.strokeColor = strokeColor;
        this.strokeWeight = strokeWeight;
        this.strokeOpacity = strokeOpacity;
        this.fill = fill;
        this.fillColor = fillColor;
        this.fillOpacity = fillOpacity;
        this.fillRule = fillRule;
        this.clickTooltip = clickTooltip;
        this.hoverTooltip = hoverTooltip;
    }

    /**
     * Get the default marker options instance
     *
     * @return default options
     */
    public static @NonNull MarkerOptions defaultOptions() {
        return MarkerOptions.DEFAULT_OPTIONS;
    }

    /**
     * Get whether to render the line stroke
     *
     * @return stroke
     */
    public boolean stroke() {
        return this.stroke;
    }

    /**
     * Get the stroke color
     *
     * @return color
     */
    public @NonNull Color strokeColor() {
        return this.strokeColor;
    }

    /**
     * Get the line stroke weight
     *
     * @return stroke weight
     */
    public int strokeWeight() {
        return this.strokeWeight;
    }

    /**
     * Get the line stroke opacity
     *
     * @return stroke opacity
     */
    public double strokeOpacity() {
        return this.strokeOpacity;
    }

    /**
     * Get whether to fill the inside of the marker
     *
     * @return fill
     */
    public boolean fill() {
        return this.fill;
    }

    /**
     * Get the fill color
     *
     * @return color
     */
    public @Nullable Color fillColor() {
        return this.fillColor;
    }

    /**
     * Get the fill opacity
     *
     * @return fill opacity
     */
    public double fillOpacity() {
        return this.fillOpacity;
    }

    /**
     * Get the fill rule
     *
     * @return fill mode
     */
    public @NonNull FillRule fillRule() {
        return this.fillRule;
    }

    /**
     * Get the click tooltip
     *
     * <p>Will be {@code null} if not set</p>
     *
     * @return tooltip
     */
    public @Nullable String clickTooltip() {
        return this.clickTooltip;
    }

    /**
     * Get the hover tooltip
     *
     * <p>Will be {@code null} if not set</p>
     *
     * @return tooltip
     */
    public @Nullable String hoverTooltip() {
        return this.hoverTooltip;
    }

    /**
     * Create a new {@link MarkerOptions.Builder} from this {@link MarkerOptions} instance
     *
     * @return new builder
     */
    public @NonNull Builder asBuilder() {
        return new Builder(
            this.stroke,
            this.strokeColor,
            this.strokeWeight,
            this.strokeOpacity,
            this.fill,
            this.fillColor,
            this.fillOpacity,
            this.fillRule,
            this.clickTooltip,
            this.hoverTooltip
        );
    }

    /**
     * Get a new {@link MarkerOptions.Builder}
     *
     * @return new builder
     */
    public static @NonNull Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final @Nullable MarkerOptions that = (MarkerOptions) o;
        return this.stroke == that.stroke
            && this.strokeWeight == that.strokeWeight
            && Double.compare(that.strokeOpacity, this.strokeOpacity) == 0
            && this.fill == that.fill
            && Double.compare(that.fillOpacity, this.fillOpacity) == 0
            && this.strokeColor.equals(that.strokeColor)
            && Objects.equals(this.fillColor, that.fillColor)
            && this.fillRule == that.fillRule
            && Objects.equals(this.clickTooltip, that.clickTooltip)
            && Objects.equals(this.hoverTooltip, that.hoverTooltip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.stroke,
            this.strokeColor,
            this.strokeWeight,
            this.strokeOpacity,
            this.fill,
            this.fillColor,
            this.fillOpacity,
            this.fillRule,
            this.clickTooltip,
            this.hoverTooltip
        );
    }

    /**
     * Fill modes enum
     *
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/fill-rule">https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/fill-rule</a>
     */
    public enum FillRule {
        NONZERO, EVENODD
    }

    /**
     * Builder for {@link MarkerOptions}
     */
    public static final class Builder {

        private boolean stroke = true;
        private Color strokeColor = Color.BLUE;
        private int strokeWeight = 3;
        private double strokeOpacity = 1.0;
        private boolean fill = true;
        private Color fillColor = null;
        private double fillOpacity = 0.2;
        private FillRule fillRule = FillRule.EVENODD;
        private String clickTooltip = null;
        private String hoverTooltip = null;

        private Builder() {
        }

        private Builder(
            final boolean stroke,
            final @NonNull Color strokeColor,
            final int strokeWeight,
            final double strokeOpacity,
            final boolean fill,
            final @Nullable Color fillColor,
            final double fillOpacity,
            final @NonNull FillRule fillRule,
            final @Nullable String clickTooltip,
            final @Nullable String hoverTooltip
        ) {
            this.stroke = stroke;
            this.strokeColor = strokeColor;
            this.strokeWeight = strokeWeight;
            this.strokeOpacity = strokeOpacity;
            this.fill = fill;
            this.fillColor = fillColor;
            this.fillOpacity = fillOpacity;
            this.fillRule = fillRule;
            this.clickTooltip = clickTooltip;
            this.hoverTooltip = hoverTooltip;
        }

        /**
         * Set whether to render the line stroke
         *
         * <p>Default: {@code true}</p>
         *
         * @param stroke new stroke
         * @return this builder
         */
        public @NonNull Builder stroke(final boolean stroke) {
            this.stroke = stroke;
            return this;
        }

        /**
         * Set the line stroke color
         *
         * <p>Default: {@link Color#BLUE}</p>
         *
         * @param color new color
         * @return this builder
         */
        public @NonNull Builder strokeColor(final @NonNull Color color) {
            this.strokeColor = color;
            return this;
        }

        /**
         * Set the line stroke weight
         *
         * <p>Default: {@code 3}</p>
         *
         * @param weight new weight
         * @return this builder
         */
        public @NonNull Builder strokeWeight(final int weight) {
            this.strokeWeight = weight;
            return this;
        }

        /**
         * Set the line stroke opacity
         *
         * <p>Default: {@code 1.0}</p>
         *
         * @param opacity new opacity
         * @return this builder
         */
        public @NonNull Builder strokeOpacity(final double opacity) {
            this.strokeOpacity = opacity;
            return this;
        }

        /**
         * Set whether to fill the marker
         *
         * <p>Default: {@code true}</p>
         *
         * @param fill new fill
         * @return this builder
         */
        public @NonNull Builder fill(final boolean fill) {
            this.fill = fill;
            return this;
        }

        /**
         * Set the fill color
         *
         * <p>Default: unset</p>
         *
         * @param color new color
         * @return this builder
         */
        public @NonNull Builder fillColor(final @NonNull Color color) {
            this.fillColor = color;
            return this;
        }

        /**
         * Set the fill opacity
         *
         * <p>Default: {@code 0.2}</p>
         *
         * @param opacity new opacity
         * @return this builder
         */
        public @NonNull Builder fillOpacity(final double opacity) {
            this.fillOpacity = opacity;
            return this;
        }

        /**
         * Set the fill rule
         *
         * <p>Default: {@link FillRule#EVENODD}</p>
         *
         * @param fillRule new fill rule
         * @return this builder
         */
        public @NonNull Builder fillRule(final @NonNull FillRule fillRule) {
            this.fillRule = fillRule;
            return this;
        }

        /**
         * Set the click tooltip, accepts HTML
         *
         * <p>Default: unset</p>
         *
         * @param tooltip new tooltip
         * @return this builder
         */
        public @NonNull Builder clickTooltip(final @Nullable String tooltip) {
            this.clickTooltip = tooltip;
            return this;
        }

        /**
         * Set the hover tooltip, accepts HTML
         *
         * <p>Default: unset</p>
         *
         * @param tooltip new tooltip
         * @return this builder
         */
        public @NonNull Builder hoverTooltip(final @Nullable String tooltip) {
            this.hoverTooltip = tooltip;
            return this;
        }

        /**
         * Create a new marker options instance from the current state of this builder
         *
         * @return new marker options
         */
        public @NonNull MarkerOptions build() {
            return new MarkerOptions(
                this.stroke,
                this.strokeColor,
                this.strokeWeight,
                this.strokeOpacity,
                this.fill,
                this.fillColor,
                this.fillOpacity,
                this.fillRule,
                this.clickTooltip,
                this.hoverTooltip
            );
        }

    }

}
