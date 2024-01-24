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
        String winner;
        if (playerOneScore < 4 && playerTwoScore < 4 && !(playerOneScore + playerTwoScore == 6)) {
            winner = SCORE_NAME[playerOneScore];
            return (playerOneScore == playerTwoScore) ? winner + "-All" : winner + "-" + SCORE_NAME[playerTwoScore];
        } else {
            if (playerOneScore == playerTwoScore)
                return "Deuce";
            winner = playerOneScore > playerTwoScore ? playerOneName : playerTwoName;
            return ((playerOneScore - playerTwoScore)*(playerOneScore - playerTwoScore) == 1) ? "Advantage " + winner : "Win for " + winner;
        }
    }
    
    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_ONE))
            this.playerOneScore += 1;
        else
            this.playerTwoScore += 1;
        
    }

}
