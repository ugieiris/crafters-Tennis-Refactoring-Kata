import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String ALL = "All";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for";
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (m_score1==m_score2)
        {
            score = new StringBuilder(switch (m_score1) {
                case 0 -> GamePointLitteral.LOVE.getValue() + "-" + ALL;
                case 1 -> GamePointLitteral.FIFTEEN.getValue() + "-" + ALL;
                case 2 -> GamePointLitteral.THIRTY.getValue() + "-" + ALL;
                default -> GamePointLitteral.DEUCE.getValue();
            });
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score = new StringBuilder(ADVANTAGE + " " + player1Name);
            else {
                if (minusResult ==-1) score = new StringBuilder(ADVANTAGE + " " + player2Name);
                else if (minusResult>=2) score = new StringBuilder(WIN_FOR + " " + player1Name);
                else score = new StringBuilder(WIN_FOR + " " + player2Name);
            }
        }
        else
        {

            for (int i=1; i<3; i++)
            {
                int tempScore=0;
                if (i==1)
                    tempScore = m_score1;
                else { score.append("-"); tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score.append(GamePointLitteral.LOVE.getValue());
                        break;
                    case 1:
                        score.append(GamePointLitteral.FIFTEEN.getValue());
                        break;
                    case 2:
                        score.append(GamePointLitteral.THIRTY.getValue());
                        break;
                    case 3:
                        score.append(GamePointLitteral.FORTY.getValue());
                        break;
                }
            }
        }
        return score.toString();
    }
}
