package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.view.InputView;

public class Application {
    public static void main(String[] args) {
        new LadderGame().run(new InputView());
    }
}
