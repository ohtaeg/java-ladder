package nextstep.ladder.domain.line;

public enum Stair {
    EXIST(true),
    NOT_EXIST(false)
    ;

    private final boolean isExist;

    Stair(final boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return isExist;
    }

    public static Stair find(boolean isExist) {
        if (isExist) {
            return Stair.EXIST;
        }
        return Stair.NOT_EXIST;
    }
}
