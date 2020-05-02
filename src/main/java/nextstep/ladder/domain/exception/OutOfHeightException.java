package nextstep.ladder.domain.exception;

public class OutOfHeightException extends RuntimeException {
    private static final String message = "높이는 1이상이여야 합니다. / %d";

    public OutOfHeightException(final int causeValue) {
        super(String.format(message, causeValue));
    }
}
