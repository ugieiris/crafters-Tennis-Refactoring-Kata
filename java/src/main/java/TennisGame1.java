public class TennisGame1 implements TennisGame {

    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for";
    private int player1GamePoints = 0;
    private int player2GamePoints = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == PLAYER_1)
            player1GamePoints += 1;
        else
            player2GamePoints += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1GamePoints == player2GamePoints) {
            switch (player1GamePoints) {
                case 0:
                    score = GamePointLitteral.LOVE + "-All";
                    break;
                case 1:
                    score = GamePointLitteral.FIFTEEN + "-All";
                    break;
                case 2:
                    score = GamePointLitteral.THIRTY + "-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1GamePoints >= 4 || player2GamePoints >= 4) {
            int minusResult = player1GamePoints - player2GamePoints;
            if (minusResult == 1) score = ADVANTAGE + " " + PLAYER_1;
            else if (minusResult == -1) score = ADVANTAGE + " " + PLAYER_2;
            else if (minusResult >= 2) score = WIN_FOR + " " + PLAYER_1;
            else score = WIN_FOR + " " + PLAYER_2;
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1GamePoints;
                else {
                    score += "-";
                    tempScore = player2GamePoints;
                }
                switch (tempScore) {
                    case 0:
                        score += GamePointLitteral.LOVE;
                        break;
                    case 1:
                        score += GamePointLitteral.FIFTEEN;
                        break;
                    case 2:
                        score += GamePointLitteral.THIRTY;
                        break;
                    case 3:
                        score += GamePointLitteral.FORTY;
                        break;
                }
            }
        }
        return score;
    }
}
