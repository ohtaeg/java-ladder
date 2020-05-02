package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<Stair> stairs;

    private Line(final List<Stair> stairs) {
        this.stairs = stairs;
    }

    public static Line generate(final LineGenerateStrategy lineGenerateStrategy, final int playerNameCount) {
        return new Line(lineGenerateStrategy.generate(playerNameCount));
    }

    public Stream<Stair> stream() {
        return stairs.stream();
    }
}
