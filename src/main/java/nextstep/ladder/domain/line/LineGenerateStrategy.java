package nextstep.ladder.domain.line;

import java.util.List;

@FunctionalInterface
public interface LineGenerateStrategy {
    List<Stair> generate(final int playerNameCount);
}
