package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.InvalidPlayerNameException;
import nextstep.ladder.domain.exception.OutOfPlayerNameLengthException;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    private PlayerName(String name) {
        this.name = name;
    }

    public static PlayerName valueOf(final String name) {
        validName(name);
        validNameLength(name);
        return new PlayerName(name);
    }

    public String getName() {
        return name;
    }

    private static void validName(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPlayerNameException(name);
        }
    }

    private static void validNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
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
