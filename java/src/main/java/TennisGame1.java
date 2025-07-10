
public class TennisGame1 implements TennisGame {

    private final Player player = new Player();

    public TennisGame1(String player1Name, String player2Name) {
        this.player.player1Name = player1Name;
        this.player.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
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
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (player.m_score1 >=4 || player.m_score2 >=4)
        {
            int minusResult = player.m_score1 - player.m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
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
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
