package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.fake.FakeRandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private LineGenerateStrategy lineGenerateStrategy;

    @BeforeEach
    void setUp() {
        lineGenerateStrategy = new FakeRandomStrategy();
    }

    @DisplayName("참여자가 1명이라면 첫번째 Stair은 존재하지 않는다.")
    @Test
    void isNotExist_OnePlayer() {
        int playerCount = 1;
        Line line = Line.generate(lineGenerateStrategy, playerCount);

        Stair actual = line.stream()
                           .findFirst()
                           .orElse(Stair.NOT_EXIST);

        assertThat(actual.isExist()).isFalse();
    }
}