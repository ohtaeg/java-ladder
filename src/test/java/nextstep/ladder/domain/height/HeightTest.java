package nextstep.ladder.domain.height;

import nextstep.ladder.domain.exception.OutOfHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class HeightTest {

    @DisplayName("높이객체를 생성할 수 있다.")
    @Test
    void create() {
        final int value = 1;
        final Height expect = Height.valueOf(value);

        final Height actual = Height.valueOf(value);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("높이가 1미만이면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validHeight(int value) {
        assertThatExceptionOfType(OutOfHeightException.class).isThrownBy(
                () -> Height.valueOf(value)
        );
    }
}