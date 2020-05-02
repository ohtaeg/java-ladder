package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.InvalidPlayerNameException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    private static final String SEPARATOR = "\\s*,\\s*";

    private final List<PlayerName> names;

    private PlayerNames(final List<PlayerName> names) {
        this.names = Collections.unmodifiableList(names);
    }

    public static PlayerNames ofNames(final String names) {
        String[] splitNames = splitName(names);
        return new PlayerNames(toPlayerNameList(splitNames));
    }

    public int size() {
        return names.size();
    }

    private static String[] splitName(final String names) {
        if (names == null) {
            throw new InvalidPlayerNameException(names);
        }
        return names.split(SEPARATOR);
    }

    private static List<PlayerName> toPlayerNameList(final String[] splitNames) {
        return Arrays.stream(splitNames)
                     .map(PlayerName::valueOf)
                     .collect(Collectors.toList());
    }
}
