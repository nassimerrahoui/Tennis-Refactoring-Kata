import java.util.Objects;

public class TennisGame3 implements TennisGame {
    public static final String[] SCORE_LABEL = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public String getScore() {
        boolean isNotEndgame = playerOne.score < 4 && playerTwo.score < 4 && !(playerOne.score + playerTwo.score == 6);
        if (isNotEndgame) return getCurrentScore();
        return getEndgameScore();
    }

    private String getCurrentScore() {
        String score = SCORE_LABEL[playerOne.score];
        var hasSameScore = playerOne.score == playerTwo.score;
        return hasSameScore ? score + "-All" : score + "-" + SCORE_LABEL[playerTwo.score];
    }

    private String getEndgameScore() {
        var hasSameScore = playerOne.score == playerTwo.score;
        if (hasSameScore) return "Deuce";
        String leader = playerOne.score > playerTwo.score ? playerOne.name : playerTwo.name;
        boolean hasAdvantage = (playerOne.score - playerTwo.score) * (playerOne.score - playerTwo.score) == 1;
        return hasAdvantage ? "Advantage " + leader : "Win for " + leader;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            this.playerOne.score += 1;
        else
            this.playerTwo.score += 1;
        
    }

}
