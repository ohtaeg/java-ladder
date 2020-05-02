package nextstep.ladder.view;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.player.PlayerNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private InputView inputView;

    @DisplayName("플레이어 이름을 받을 수 있다.")
    @Test
    void inputPlayerNames() {
        final String names = "pobi,honux,crong,jk";
        inputView = new InputView(init(names));

        PlayerNames actual = inputView.inputPlayerNames();

        assertThat(actual.count()).isEqualTo(4);
    }

    @DisplayName("높이를 입력받는다.")
    @Test
    void inputHeight() {
        final String value = "5";
        final int intValue = 5;
        inputView = new InputView(init(value));
        Height expect = Height.valueOf(intValue);

        Height actual = inputView.inputHeight();

        assertThat(actual).isEqualTo(expect);
    }

    InputStream init(String value) {
        return new ByteArrayInputStream(value.getBytes());
    }
}