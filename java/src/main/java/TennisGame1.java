
public class TennisGame1 implements TennisGame {

    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String ALL = "All";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for";
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:
                    score = GamePointLitteral.LOVE.getValue() + "-" + ALL;
                    break;
                case 1:
                        score = GamePointLitteral.FIFTEEN.getValue() + "-" + ALL;
                    break;
                case 2:
                        score = GamePointLitteral.THIRTY.getValue() + "-" + ALL;
                    break;
                default:
                        score = GamePointLitteral.DEUCE.getValue();
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score = ADVANTAGE + " " + PLAYER_1;
            else {
                if (minusResult ==-1) score = ADVANTAGE + " " + PLAYER_2;
                else if (minusResult>=2) score = WIN_FOR + " " + PLAYER_1;
                else score = WIN_FOR + " " + PLAYER_2;
            }
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+= GamePointLitteral.LOVE.getValue();
                        break;
                    case 1:
                        score+= GamePointLitteral.FIFTEEN.getValue();
                        break;
                    case 2:
                        score+= GamePointLitteral.THIRTY.getValue();
                        break;
                    case 3:
                        score+= GamePointLitteral.FORTY.getValue();
                        break;
                }
            }
        }
        return score;
    }
}
