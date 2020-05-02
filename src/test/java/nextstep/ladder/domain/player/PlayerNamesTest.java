package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNamesTest {

    @DisplayName("플레이어 이름들을 가진 일급 객체를 생성할 수 있다.")
    @Test
    void create() {
        final String names = "a,b,c,";
        final int expect = names.split(",").length;

        final PlayerNames actual = PlayerNames.ofNames(names);

        assertThat(actual.size()).isEqualTo(expect);
    }
}