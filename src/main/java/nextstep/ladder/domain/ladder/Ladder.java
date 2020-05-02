package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.strategy.LineGenerateStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder valueOf(final LineGenerateStrategy lineGenerateStrategy, final Height height, final int playerCount) {
        return new Ladder(drawLines(lineGenerateStrategy, height, playerCount));
    }

    public Stream<Line> stream() {
        return lines.stream();
    }

    private static List<Line> drawLines(final LineGenerateStrategy lineGenerateStrategy, final Height height, final int playerCount) {
        return height.rangeClosed()
                     .mapToObj(count -> Line.valueOf(lineGenerateStrategy, playerCount))
                     .collect(Collectors.toList());
    }
}
