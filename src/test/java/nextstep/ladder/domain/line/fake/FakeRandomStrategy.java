package nextstep.ladder.domain.line.fake;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import nextstep.ladder.domain.line.Stair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeRandomStrategy implements LineGenerateStrategy {

    @Override
    public List<Stair> generate(final int playerNameCount) {
        return new ArrayList<>(Arrays.asList(Stair.NOT_EXIST));
    }
}