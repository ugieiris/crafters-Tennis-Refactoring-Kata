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

    @Override
    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_1)) player1GamePoints += 1;
        else player2GamePoints += 1;
    }

    @Override
    public String getScore() {
        if (player1GamePoints == player2GamePoints) {
            return displayEquality();
        } else if (player1GamePoints >= 4 || player2GamePoints >= 4) {
            int scoreDifference = player1GamePoints - player2GamePoints;
            return Math.abs(scoreDifference) == 1 ? displayAdvantage(scoreDifference) : displayWinnerOfGame(scoreDifference);
        }
        return displayScore(player1GamePoints) + "-" + displayScore(player2GamePoints);
    }

    private static String displayWinnerOfGame(int minusResult) {
        return WIN_FOR + " " + displayWinner(minusResult);
    }

    private static String displayAdvantage(int minusResult) {
        return ADVANTAGE + " " + displayWinner(minusResult);
    }

    /**
     * Affiche le nom du gagnant en fonction du résultat de la soustraction.
     * Positif pour le joueur 1, négatif pour le joueur 2.
     */
    private static String displayWinner(int scoreDifference) {
        return scoreDifference > 0 ? PLAYER_1 : PLAYER_2;
    }

    private String displayEquality() {
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
