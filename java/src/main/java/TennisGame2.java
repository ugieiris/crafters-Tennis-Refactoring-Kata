
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (isWin()) {
            return getWinScoreString();
        }

        if (isAvantageBoolean()) {
            return getAdvantageScore();
        }

        String score = "";
        if (isEquality()) {
            score = getEquality(score);
        }

        if (P1point > 0 && P2point == 0) {
            if (P1point == 1) {
                P1res = "Fifteen";
            }
            if (P1point == 2) {
                P1res = "Thirty";
            }
            if (P1point == 3) {
                P1res = "Forty";
            }

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point == 0) {
            if (P2point == 1) {
                P2res = "Fifteen";
            }
            if (P2point == 2) {
                P2res = "Thirty";
            }
            if (P2point == 3) {
                P2res = "Forty";
            }

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            if (P1point == 2) {
                P1res = "Thirty";
            }
            if (P1point == 3) {
                P1res = "Forty";
            }
            if (P2point == 1) {
                P2res = "Fifteen";
            }
            if (P2point == 2) {
                P2res = "Thirty";
            }
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2) {
                P2res = "Thirty";
            }
            if (P2point == 3) {
                P2res = "Forty";
            }
            if (P1point == 1) {
                P1res = "Fifteen";
            }
            if (P1point == 2) {
                P1res = "Thirty";
            }
            score = P1res + "-" + P2res;
        }

        return score;
    }

    private String getEquality(String score) {
        if (P1point >= 3) {
            score = "Deuce";
        } else {
            if (P1point == 0) {
                score = "Love";
            }
            if (P1point == 1) {
                score = "Fifteen";
            }
            if (P1point == 2) {
                score = "Thirty";
            }
            score += "-All";
        }
        return score;
    }

    private boolean isEquality() {
        return P1point == P2point;
    }

    private String getWinScoreString() {
        String score;
        score = "Win for ";
        if (P1point - P2point >= 2) {
            score += this.player1Name;
        }
        if (P2point - P1point >= 2) {
            score += this.player2Name;
        }
        return score;
    }

    private String getAdvantageScore() {
        String score;
        score = "Advantage ";

        if (P1point > P2point) {
            score += this.player1Name;
        }
        if (P2point > P1point) {
            score += this.player2Name;
        }
        return score;
    }

    private boolean isWin() {
        return P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2 || P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2;
    }

    private boolean isAvantageBoolean() {
        return P1point > P2point && P2point >= 3 || P2point > P1point && P1point >= 3;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player)) {
            P1point++;
        } else {
            P2point++;
        }
    }
}