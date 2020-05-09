package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.strategy.LineGenerateStrategy;

import java.util.stream.Stream;

public class Line {
    private final Stairs stairs;

    private Line(final Stairs stairs) {
        this.stairs = stairs;
    }

    public static Line valueOf(final LineGenerateStrategy lineGenerateStrategy, final int playerNameCount) {
        return new Line(lineGenerateStrategy.generate(playerNameCount));
    }

    public Stream<Stair> stream() {
        return stairs.stream();
    }
}
