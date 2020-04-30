package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.InvalidPlayerNameException;
import nextstep.ladder.domain.exception.OutOfPlayerNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerNameTest {

    @DisplayName("플레이어 이름 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void create(String name) {
        PlayerName expect = PlayerName.valueOf(name);

        PlayerName actual = PlayerName.valueOf(name);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("플레이어 이름은 5글자를 넘길 수 없다.")
    @Test
    void validNameLength() {
        assertThatExceptionOfType(OutOfPlayerNameLengthException.class).isThrownBy(
                () -> PlayerName.valueOf("aaaaaa")
        );
    }

    @DisplayName("플레이어 이름에 공백이나 null이 들어올 수 없다.")
    @ParameterizedTest
    @MethodSource("blankStrings")
    void validName(String name) {
        assertThatExceptionOfType(InvalidPlayerNameException.class).isThrownBy(
                () -> PlayerName.valueOf(name)
        );
    }

    static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }
}