package main.java.days;

import main.java.util.InputReader;
import java.util.List;

public class Day2 {

    private final List<String> inputList = InputReader.getInputAsList(2);

    public long totalScore() {
        long totalScore = 0;
        for (String game: inputList) {
            totalScore += checkWhatWasThrown(game) + checkOutcome(game);
        }
        return totalScore;
    }

    public int checkOutcome(String game) {
        if (checkDraw(game)) {
            return 3;
        } else if (checkWin(game)) {
            return 6;
        } return 0;
    }

    public boolean checkDraw(String game) {
        return game.charAt(0) - 'A' == game.charAt(2) - 'X';
    }

    public boolean checkWin(String game) {
        return game.equals("A Y") || game.equals("B Z") || game.equals("C X");
    }

    public int checkWhatWasThrown(String game) {
        return game.charAt(2) - 'W';
    }

    public int totalScoreSecondStrat() {
        int totalScore = 0;
        for (String game: inputList) {
            if (wantWin(game)) {
                totalScore += 6 + characterScoreForWin(game);
            } else if (wantDraw(game)) {
                totalScore += 3 + characterScoreForDraw(game);
            } else totalScore += characterScoreForLoss(game);
        }
        return totalScore;
    }

    public int desiredOutcome(String game) {
        return (game.charAt(2) - 'X') * 3;
    }

    public boolean wantWin(String game) {
        return desiredOutcome(game) == 6;
    }

    public boolean wantDraw(String game) {
        return desiredOutcome(game) == 3;
    }

    public int characterScoreForWin(String game) {
        char opponentThrown = game.charAt(0);
        return switch (opponentThrown) {
            case 'A' -> 2;
            case 'B' -> 3;
            case 'C' -> 1;
            default -> throw new IllegalStateException("Unexpected value: " + opponentThrown);
        };
    }

    public int characterScoreForDraw(String game) {
        return game.charAt(0) - '@';
    }

    public int characterScoreForLoss(String game) {
        char opponentThrown = game.charAt(0);
        return switch (opponentThrown) {
            case 'A' -> 3;
            case 'B' -> 1;
            case 'C' -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + opponentThrown);
        };
    }
}
