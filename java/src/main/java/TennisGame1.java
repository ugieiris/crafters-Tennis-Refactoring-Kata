import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (scorePlayer1== scorePlayer2)
        {
            score = switch (scorePlayer1) {
                case 0 -> new StringBuilder(GamePoints.LOVE.getValue() + "-All");
                case 1 -> new StringBuilder(GamePoints.FIFTEEN.getValue() + "-All");
                case 2 -> new StringBuilder(GamePoints.THIRTY.getValue() + "-All");
                default -> new StringBuilder("Deuce");
            };
        }
        else if (scorePlayer1>=4 || scorePlayer2 >=4)
        {
            score = new StringBuilder(getFinalScore());
        }
        else
        {
            int tempScore;
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scorePlayer1;
                else { score.append("-"); tempScore = scorePlayer2;}
                switch(tempScore)
                {
                    case 0:
                        score.append(GamePoints.LOVE.getValue());
                        break;
                    case 1:
                        score.append(GamePoints.FIFTEEN.getValue());
                        break;
                    case 2:
                        score.append(GamePoints.THIRTY.getValue());
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                    default:
                        break;
                }
            }
        }
        return score.toString();
    }

    private String getFinalScore() {
        String score;
        int minusResult = getMinusResult();
        if (minusResult==1) score ="Advantage " + player1Name;
        else if (minusResult ==-1) score ="Advantage " + player2Name;
        else if (minusResult>=2) score = "Win for " + player1Name;
        else score ="Win for " + player2Name;
        return score;
    }

    private int getMinusResult() {
        return scorePlayer1 - scorePlayer2;
    }
}
