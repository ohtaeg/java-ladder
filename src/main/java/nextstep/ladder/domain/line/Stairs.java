package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stairs {
    private static final Stairs CREATE_FIRST_STAIRS = new Stairs(new ArrayList<>(Arrays.asList(Stair.NOT_EXIST)));
    private static final int LAST_INDEX = 1;

    private final List<Stair> stairs;

    private Stairs(final List<Stair> stairs) {
        this.stairs = Collections.unmodifiableList(stairs);
    }

    public static Stairs createFirstStair() {
        return CREATE_FIRST_STAIRS;
    }

    public int count() {
        return stairs.size();
    }

    public Stairs addNextStair(final Stair stair) {
        List<Stair> copyStairs = new ArrayList<>();
        copyStairs.addAll(stairs);

        if (isContinuousStairs()) {
            copyStairs.add(Stair.NOT_EXIST);
            return new Stairs(copyStairs);
        }

        copyStairs.add(stair);
        return new Stairs(copyStairs);
    }
    public Stream<Stair> stream() {
        return stairs.stream();
    }

    private boolean isContinuousStairs() {
        return lastStair().isExist();
    }

    private Stair lastStair() {
        return stairs.get(count() - LAST_INDEX);
    }
}
