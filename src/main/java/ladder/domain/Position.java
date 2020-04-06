package ladder.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}