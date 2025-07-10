import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String ALL = "All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for ";
    private final Player player = new Player();

    public TennisGame1(String player1Name, String player2Name) {
        this.player.player1Name = player1Name;
        this.player.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_1))
            player.m_score1 = player.m_score1 + 1;
        else
            player.m_score2 = player.m_score2 + 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (player.m_score1 == player.m_score2)
        {
            switch (player.m_score1)
            {
                case 0:
                        score = SCORE.LOVE.getValue() + "-" + ALL;
                    break;
                case 1:
                        score = SCORE.FIFTEEN.getValue() + "-" + ALL;
                    break;
                case 2:
                        score = SCORE.THIRTY.getValue() + "-" + ALL;
                    break;
                default:
                        score = DEUCE;
                    break;

            }
        }
        else if (isScoreMoreThanForty())
        {
            int minusResult = player.m_score1 - player.m_score2;
            if (minusResult==1) score = ADVANTAGE + " " + PLAYER_1;
            else if (minusResult ==-1) score = ADVANTAGE + " " + PLAYER_2;
            else if (minusResult>=2) score = WIN_FOR + PLAYER_1;
            else score = WIN_FOR + PLAYER_2;
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player.m_score1;
                else { score+="-"; tempScore = player.m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+= SCORE.LOVE.getValue();
                        break;
                    case 1:
                        score+= SCORE.FIFTEEN.getValue();
                        break;
                    case 2:
                        score+= SCORE.THIRTY.getValue();
                        break;
                    case 3:
                        score+= SCORE.FORTY.getValue();
                        break;
                }
            }
        }
        return score;
    }

    private boolean isScoreMoreThanForty() {
        return player.m_score1 >= 4 || player.m_score2 >= 4;
    }
}
