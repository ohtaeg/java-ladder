package nextstep.ladder.controller;

import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.line.strategy.RandomStrategy;
import nextstep.ladder.domain.player.PlayerNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public void run(final InputView inputView) {
        PlayerNames playerNames = inputView.inputPlayerNames();
        Height height = inputView.inputHeight();
        Ladder ladder = Ladder.valueOf(new RandomStrategy(), height, playerNames.count());

        OutputView.printPlayerNames(playerNames);
        OutputView.printLadder(ladder);
    }
}
