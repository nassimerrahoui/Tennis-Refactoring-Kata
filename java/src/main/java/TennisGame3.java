import java.util.Objects;

public class TennisGame3 implements TennisGame {

    public static final String PLAYER_ONE = "player1";
    public static final String[] SCORE_NAME = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int playerTwoScore;
    private int playerOneScore;
    private final String playerOneName;
    private final String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        if (playerOneScore < 4 && playerTwoScore < 4 && !(playerOneScore + playerTwoScore == 6)) {
            var scoreName = SCORE_NAME[playerOneScore];
            return (playerOneScore == playerTwoScore) ? scoreName + "-All" : scoreName + "-" + SCORE_NAME[playerTwoScore];
        } else {
            if (playerOneScore == playerTwoScore)
                return "Deuce";
            String leader = playerOneScore > playerTwoScore ? playerOneName : playerTwoName;
            return hasAdvantage() ? "Advantage " + leader : "Win for " + leader;
        }
    }

    private boolean hasAdvantage() {
        return Math.abs(playerOneScore - playerTwoScore) == 1;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_ONE))
            this.playerOneScore += 1;
        else
            this.playerTwoScore += 1;
        
    }

}
