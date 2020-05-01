package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("플레이어는 이름을 가지고 있다.")
    @Test
    void create() {
        final String name = "ohtae";
        Player expect = Player.ofName(name);

        Player actual = Player.ofName(name);

        assertThat(actual).isEqualTo(expect);
    }
}