package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Stair;
import nextstep.ladder.domain.line.Stairs;
import nextstep.ladder.domain.line.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("사다리 객체를 생성할 수 있다.")
    @Test
    void create() {
        final LineGenerateStrategy lineGenerateStrategy = playerNameCount -> Stairs.createFirstStair();
        final Height height = Height.valueOf(1);
        final int playerCount = 1;

        final List<Line> actual = Ladder.valueOf(lineGenerateStrategy, height, playerCount)
                                        .stream()
                                        .collect(Collectors.toList());

        assertThat(actual.size()).isOne();
    }

    @DisplayName("높이가 1, 참여자 3명인 사다리 객체를 생성할 수 있다.")
    @Test
    void createLadder() {
        final LineGenerateStrategy lineGenerateStrategy = playerNameCount ->
                toStairs(new ArrayList<>(Arrays.asList(Stair.NOT_EXIST, Stair.EXIST)));
        final Height height = Height.valueOf(1);
        final int playerCount = 3;

        final List<Line> lines = Ladder.valueOf(lineGenerateStrategy, height, playerCount)
                                       .stream()
                                       .collect(Collectors.toList());

        final List<Stair> stairs = lines.get(0)
                                        .stream()
                                        .collect(Collectors.toList());

        assertThat(lines.size()).isEqualTo(1);
        assertThat(stairs.get(0).isExist()).isFalse();
        assertThat(stairs.get(1).isExist()).isFalse();
        assertThat(stairs.get(2).isExist()).isTrue();
    }

    Stairs toStairs(final List<Stair> stairList) {
        Stairs stairs = Stairs.createFirstStair();
        for (Stair stair : stairList) {
            stairs = stairs.addNextStair(stair);
        }
        return stairs;
    }
}