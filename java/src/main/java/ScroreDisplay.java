public class ScroreDisplay {
    private final TennisGame1 tennisGame1;

    public ScroreDisplay(TennisGame1 tennisGame1) {
        this.tennisGame1 = tennisGame1;
    }

    public String getScore() {
        String score;
        if (tennisGame1.getPlayers().m_score1 == tennisGame1.getPlayers().m_score2) {
            score = displayEquality();
        } else if (isPlayerScoreOverForty() && Math.abs(getPlayersScoreDifference()) == 1) {
            score = displayAdvantage();
        } else if (isPlayerScoreOverForty() && Math.abs(getPlayersScoreDifference()) >= 2) {
            score = displayWinnerOfGame();
        } else {
            score = displayStandardGamePoints();
        }
        return score;
    }

    String displayStandardGamePoints() {
        return getLitteralScore(tennisGame1.getPlayers().m_score1) + "-" + getLitteralScore(tennisGame1.getPlayers().m_score2);
    }

    static String getLitteralScore(int tempScore) {
        return switch (tempScore) {
            case 0 -> GamePointLitteral.LOVE.getLitteral();
            case 1 -> GamePointLitteral.FIFTEEN.getLitteral();
            case 2 -> GamePointLitteral.THIRTY.getLitteral();
            case 3 -> GamePointLitteral.FORTY.getLitteral();
            default -> "";
        };
    }

    String displayWinnerOfGame() {
        String score;
        score = "Win for " + getPlayerGameLeader(getPlayersScoreDifference());
        return score;
    }

    String displayAdvantage() {
        String score;
        score = "Advantage " + getPlayerGameLeader(getPlayersScoreDifference());
        return score;
    }

    String getPlayerGameLeader(int minusResult) {
        return minusResult > 0 ? tennisGame1.getPlayers().player1Name : tennisGame1.getPlayers().player2Name;
    }

    int getPlayersScoreDifference() {
        return tennisGame1.getPlayers().m_score1 - tennisGame1.getPlayers().m_score2;
    }

    boolean isPlayerScoreOverForty() {
        return tennisGame1.getPlayers().m_score1 >= 4 || tennisGame1.getPlayers().m_score2 >= 4;
    }

    String displayEquality() {
        return switch (tennisGame1.getPlayers().m_score1) {
            case 0 -> GamePointLitteral.LOVE.getLitteralEquality();
            case 1 -> GamePointLitteral.FIFTEEN.getLitteralEquality();
            case 2 -> GamePointLitteral.THIRTY.getLitteralEquality();
            default -> "Deuce";
        };
    }
}