import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for";
    private int player1GamePoints = 0;
    private int player2GamePoints = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_1)) player1GamePoints += 1;
        else player2GamePoints += 1;
    }

    public String getScore() {
        String score = "";
        if (player1GamePoints == player2GamePoints) {
            score = getScoreEqual();
        } else if (player1GamePoints >= 4 || player2GamePoints >= 4) {
            int minusResult = player1GamePoints - player2GamePoints;

            if (Math.abs(minusResult) == 1) {
                score = ADVANTAGE + " " + displayWinner(minusResult);
            } else {
                score = WIN_FOR + " " + displayWinner(minusResult);
            }
        } else {
            score = displayScore(player1GamePoints) + "-" + displayScore(player2GamePoints);
        }
        return score;
    }

    private static String displayWinner(int minusResult) {
        return minusResult > 0 ? PLAYER_1 : PLAYER_2;
    }

    private String getScoreEqual() {
        return switch (player1GamePoints) {
            case 0, 1, 2 -> displayScore(player1GamePoints) + "-All";
            default -> "Deuce";
        };
    }

    private static String displayScore(int score) {
        return switch (score) {
            case 0 -> GamePointLitteral.LOVE;
            case 1 -> GamePointLitteral.FIFTEEN;
            case 2 -> GamePointLitteral.THIRTY;
            case 3 -> GamePointLitteral.FORTY;
            default -> throw new IllegalStateException("Unexpected value: " + score);
        };
    }
}
