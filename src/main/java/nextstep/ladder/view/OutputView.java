package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Stair;
import nextstep.ladder.domain.player.PlayerNames;

import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_FORMAT_EXPRESSION = "%6s";
    private static final String LADDER_STRAIGHT_LINE = "|";
    private static final String EMPTY_STRING = "";

    private OutputView() { }

    public static void printPlayerNames(PlayerNames playerNames) {
        System.out.print(System.lineSeparator());
        System.out.println(RESULT_MESSAGE);
        playerNames.stream()
                   .map(name -> formatName(name.getName()))
                   .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        ladder.stream()
              .map(OutputView::printLine)
              .forEach(System.out::println);
    }

    private static String printLine(final Line line) {
        return line.stream()
                   .map(Stair::getExpression)
                   .collect(Collectors.joining(LADDER_STRAIGHT_LINE, EMPTY_STRING, LADDER_STRAIGHT_LINE));
    }

    private static String formatName(String name) {
        return String.format(NAME_FORMAT_EXPRESSION, name);
    }
}
