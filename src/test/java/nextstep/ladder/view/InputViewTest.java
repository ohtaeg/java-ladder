package nextstep.ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private InputView inputView;

    @DisplayName("플레이어 이름을 받을 수 있다.")
    @Test
    void inputPlayers() {
        final String names = "pobi,honux,crong,jk";
        inputView = new InputView(init(names));

        String actual = inputView.inputPlayers();

        assertThat(actual).isEqualTo(names);
    }

    InputStream init(String value) {
        return new ByteArrayInputStream(value.getBytes());
    }
}