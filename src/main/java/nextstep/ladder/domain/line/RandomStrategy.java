package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements LineGenerateStrategy {
    private static final int LAST_INDEX = 1;

    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public List<Stair> generate(final int playerNameCount) {
        final List<Stair> stairs = init();
        for (int startIndex = stairs.size(); startIndex < playerNameCount; startIndex++) {
            Stair prevStair = stairs.get(startIndex - LAST_INDEX);
            stairs.add(drawLine(prevStair));
        }
        return stairs;
    }

    private List<Stair> init() {
        return new ArrayList<>(Arrays.asList(Stair.NOT_EXIST));
    }

    private Stair drawLine(final Stair prevStair) {
        if (prevStair.isExist()) {
            return Stair.NOT_EXIST;
        }
        return Stair.find(random.nextBoolean());
    }
}