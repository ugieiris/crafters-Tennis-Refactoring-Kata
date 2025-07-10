import java.util.Objects;

public class Players {
    int m_score1 = 0;
    int m_score2 = 0;
    String player1Name;
    String player2Name;

    public Players() {
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }
}