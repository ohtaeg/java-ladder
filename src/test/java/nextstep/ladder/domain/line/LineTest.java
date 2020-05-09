package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private LineGenerateStrategy lineGenerateStrategy;

    @DisplayName("참여자가 1명이라면 첫번째 Stair은 존재하지 않는다.")
    @Test
    void isNotExist_OnePlayer() {
        int playerCount = 1;
        lineGenerateStrategy = playerNameCount -> toStairs(new ArrayList<>());
        Line line = Line.valueOf(lineGenerateStrategy, playerCount);

        Stair actual = line.stream()
                           .findFirst()
                           .orElse(Stair.NOT_EXIST);

        assertThat(actual.isExist()).isFalse();
    }

    @DisplayName("참여자가 2명일때 두번째 Stair은 존재한다.")
    @Test
    void existSecondStair() {
        int playerCount = 2;
        lineGenerateStrategy = playerNameCount -> toStairs(new ArrayList<>(Arrays.asList(Stair.EXIST)));
        Line line = Line.valueOf(lineGenerateStrategy, playerCount);

        final List<Stair> stairs = line.stream()
                                       .collect(Collectors.toList());

        assertThat(stairs.get(0).isExist()).isFalse();
        assertThat(stairs.get(1).isExist()).isTrue();
    }

    @DisplayName("참여자가 2명일때 두번째 Stair은 존재하지 않는다.")
    @Test
    void notExistSecondStair() {
        int playerCount = 2;
        lineGenerateStrategy = playerNameCount -> toStairs(new ArrayList<>(Arrays.asList(Stair.NOT_EXIST)));
        Line line = Line.valueOf(lineGenerateStrategy, playerCount);

        final List<Stair> stairs = line.stream()
                                       .collect(Collectors.toList());

        assertThat(stairs.get(0).isExist()).isFalse();
        assertThat(stairs.get(1).isExist()).isFalse();
    }

    Stairs toStairs(final List<Stair> stairList) {
        Stairs stairs = Stairs.createFirstStair();
        for (Stair stair : stairList) {
            stairs = stairs.addNextStair(stair);
        }
        return stairs;
    }
}