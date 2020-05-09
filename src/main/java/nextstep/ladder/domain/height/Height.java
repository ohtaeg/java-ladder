package nextstep.ladder.domain.height;

import nextstep.ladder.domain.exception.OutOfHeightException;

import java.util.Objects;
import java.util.stream.IntStream;

public class Height {
    private static final int MIN = 1;

    private final int value;

    private Height(final int value) {
        this.value = value;
    }

    public static Height valueOf(final int value) {
        validHeight(value);
        return new Height(value);
    }

    public IntStream rangeClosed() {
        return IntStream.rangeClosed(MIN, value);
    }

    private static void validHeight(final int value) {
        if (value < MIN) {
            throw new OutOfHeightException(value);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
