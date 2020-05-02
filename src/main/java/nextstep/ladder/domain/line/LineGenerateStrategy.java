package nextstep.ladder.domain.line;

import java.util.List;

public interface LineGenerateStrategy {
    List<Stair> generate(final int playerNameCount);
}
