import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        //displayEquality
        //displayAdvantage
        //displayWinnerOfGame
        //displayStandardGamePoints

        String score = "";
        if (m_score1 == m_score2) {
            score = displayEquality();
        } else if (isPlayerScoreOverForty() && Math.abs(getPlayersScoreDifference()) == 1) {
            score = displayAdvantage();
        } else if (isPlayerScoreOverForty() && Math.abs(getPlayersScoreDifference()) >= 2) {
            score = displayWinnerOfGame();
        } else {
            int tempScore = 0;
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = m_score1;
                } else {
                    score += "-";
                    tempScore = m_score2;
                }
                score += getLitteralScore(tempScore);
            }
        }
        return score;
    }

    private static String getLitteralScore(int tempScore) {
        return switch (tempScore) {
            case 0 -> GamePointLitteral.LOVE.getLitteral();
            case 1 -> GamePointLitteral.FIFTEEN.getLitteral();
            case 2 -> GamePointLitteral.THIRTY.getLitteral();
            case 3 -> GamePointLitteral.FORTY.getLitteral();
            default -> "";
        };
    }

    private String displayWinnerOfGame() {
        String score;
        score = "Win for " + getPlayerGameLeader(getPlayersScoreDifference());
        return score;
    }

    private String displayAdvantage() {
        String score;
        score = "Advantage " + getPlayerGameLeader(getPlayersScoreDifference());
        return score;
    }

    private String getPlayerGameLeader(int minusResult) {
        return minusResult > 0 ? player1Name : player2Name;
    }

    private int getPlayersScoreDifference() {
        return m_score1 - m_score2;
    }

    private boolean isPlayerScoreOverForty() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String displayEquality() {
        return switch (m_score1) {
            case 0 -> GamePointLitteral.LOVE.getLitteralEquality();
            case 1 -> GamePointLitteral.FIFTEEN.getLitteralEquality();
            case 2 -> GamePointLitteral.THIRTY.getLitteralEquality();
            default -> "Deuce";
        };
    }

}
