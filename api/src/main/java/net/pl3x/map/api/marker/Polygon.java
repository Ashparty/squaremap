package net.pl3x.map.api.marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.pl3x.map.api.Point;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Polygon marker
 */
public final class Polygon extends Marker implements IPolygon {

    private final List<Point> mainPolygon;
    private final List<List<Point>> negativeSpace;

    Polygon(final @NonNull List<Point> points, final @NonNull List<List<Point>> negativeSpace) {
        this.mainPolygon = new ArrayList<>(points);
        this.negativeSpace = new ArrayList<>(negativeSpace);
    }

    @Override
    public @NonNull List<List<Point>> negativeSpace() {
        return this.negativeSpace;
    }

    @Override
    public @NonNull List<Point> mainPolygon() {
        return this.mainPolygon;
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final @Nullable Polygon polygon = (Polygon) o;
        return this.markerOptionsMatch(polygon)
            && this.mainPolygon.equals(polygon.mainPolygon)
            && this.negativeSpace.equals(polygon.negativeSpace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.markerOptions(), this.mainPolygon, this.negativeSpace);
    }

}
