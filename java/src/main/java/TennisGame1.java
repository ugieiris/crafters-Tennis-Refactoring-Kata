public class TennisGame1 implements TennisGame {

    private final Players players = new Players();
    private final ScroreDisplay scroreDisplay = new ScroreDisplay(this);

    public TennisGame1(String player1Name, String player2Name) {
        this.players.player1Name = player1Name;
        this.players.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        players.wonPoint(playerName);
    }

    public String getScore() {
        return scroreDisplay.getScore();
    }

    public Players getPlayers() {
        return players;
    }
}
