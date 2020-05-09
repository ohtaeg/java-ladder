package nextstep.ladder.domain.exception;

public class OutOfPlayerNameLengthException extends RuntimeException {
    private static final String message = "플레이어 이름은 5글자를 넘길 수 없습니다. / %s";

    public OutOfPlayerNameLengthException(final String causeValue) {
        super(String.format(message, causeValue));
    }
}
