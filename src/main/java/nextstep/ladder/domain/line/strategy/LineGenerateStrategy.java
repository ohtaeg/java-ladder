package nextstep.ladder.domain.line.strategy;

import nextstep.ladder.domain.line.Stairs;

@FunctionalInterface
public interface LineGenerateStrategy {
    Stairs generate(final int playerNameCount);
}
