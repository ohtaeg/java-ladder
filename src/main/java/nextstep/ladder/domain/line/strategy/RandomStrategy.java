package nextstep.ladder.domain.line.strategy;

import nextstep.ladder.domain.line.Stair;
import nextstep.ladder.domain.line.Stairs;

import java.util.Random;

public class RandomStrategy implements LineGenerateStrategy {
    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public Stairs generate(final int playerNameCount) {
        Stairs stairs = Stairs.createFirstStair();
        for (int startIndex = stairs.count(); startIndex < playerNameCount; startIndex++) {
            stairs = stairs.addNextStair(makeNextStair());
        }
        return stairs;
    }

    private Stair makeNextStair() {
        return Stair.find(random.nextBoolean());
    }
}