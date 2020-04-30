package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.InvalidPlayerNameException;
import nextstep.ladder.domain.exception.OutOfPlayerNameLengthException;

import java.util.Objects;

public class PlayerName {
    private String name;

    private PlayerName(String name) {
        validName(name);
        validNameLength(name);
        this.name = name;
    }

    public static PlayerName valueOf(final String name) {
        return new PlayerName(name);
    }

    private void validName(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPlayerNameException(name);
        }
    }

    private void validNameLength(final String name) {
        if (name.length() > 5) {
            throw new OutOfPlayerNameLengthException(name);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
