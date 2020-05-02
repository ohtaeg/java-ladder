package nextstep.ladder.domain.line;

public enum Stair {
    EXIST(true, "-----"),
    NOT_EXIST(false, "     ")
    ;

    private final boolean isExist;
    private final String expression;

    Stair(final boolean isExist, final String expression) {
        this.isExist = isExist;
        this.expression = expression;
    }

    public boolean isExist() {
        return isExist;
    }

    public String getExpression() {
        return expression;
    }

    public static Stair find(boolean isExist) {
        if (isExist) {
            return Stair.EXIST;
        }
        return Stair.NOT_EXIST;
    }
}
