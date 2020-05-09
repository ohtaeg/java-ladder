package nextstep.ladder.domain.exception;

public class InvalidPlayerNameException extends RuntimeException {
    private static final String message = "유효하지 않은 이름을 입력하셨습니다. / %s";

    public InvalidPlayerNameException(final String causeValue) {
        super(String.format(message, causeValue));
    }
}
