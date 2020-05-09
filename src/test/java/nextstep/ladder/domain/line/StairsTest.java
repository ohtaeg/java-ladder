package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class StairsTest {
    @DisplayName("첫번째 Stair은 존재하지 않는다.")
    @Test
    void isNotExistFirstStair() {
        final Stairs stairs = Stairs.createFirstStair();

        Stair actual = stairs.stream()
                             .findFirst()
                             .orElse(Stair.NOT_EXIST);

        assertThat(actual.isExist()).isFalse();
    }

    @DisplayName("이전 Stair가 존재할 경우 다음 Stair는 무조건 존재하지 않는다.")
    @Test
    void addNextStair() {
        Stairs stairs = Stairs.createFirstStair();
        stairs = stairs.addNextStair(Stair.EXIST);
        stairs = stairs.addNextStair(Stair.EXIST);

        final List<Stair> stairsList = stairs.stream()
                                             .collect(Collectors.toList());

        assertThat(stairsList.get(0).isExist()).isFalse();
        assertThat(stairsList.get(1).isExist()).isTrue();
        assertThat(stairsList.get(2).isExist()).isFalse();
    }
}