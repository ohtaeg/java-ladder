package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;

    private Player(final PlayerName playerName) {
        this.playerName = playerName;
    }

    public static Player ofName(final String name) {
        return new Player(PlayerName.valueOf(name));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
