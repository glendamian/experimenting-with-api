import java.util.List;
import java.util.Objects;

/**
 * Class to represent the game GratitudeNU.
 */
public class GratitudeNUImpl implements GratitudeNU {
  protected List<Games> games;
  protected List<Player> playerInfo;

  /**
   * Default constructor for the game GratitudeNU.
   * @param games the list of game rounds.
   * @param playerInfo list of players that are participating.
   */
  public GratitudeNUImpl(List<Games> games, List<Player> playerInfo)
          throws IllegalArgumentException {
    if (Objects.isNull(games) || Objects.isNull(playerInfo)) {
      throw new IllegalArgumentException("Objects cannot be null.");
    }
    this.games = games;
    this.playerInfo = playerInfo;
  }

  public int getTotalScore(String id) {
    int result = 0;
    for (Games g : games) {
      result += g.scorePerRound(id);
    }
    return result;
  }

  public double getAverageTake(String id) {
    double totalTakes = 0;
    for (Games g : games) {
      totalTakes += g.takesPerRound(id);
    }
    if (totalTakes != 0) {
      totalTakes = this.getTotalScore(id) / totalTakes;
    }
    return totalTakes;
  }

  public int getGamesWon(String id) {
    int gamesWon = 0;
    for (Games g : games) {
      if (g.winThisRound(id)) {
        gamesWon++;
      }
    }
    return gamesWon;
  }

  /**
   * Checks to see if player is in at least one game.
   * @param id the player id.
   * @return true if yes.
   */
  protected boolean atLeastOne(String id) {
    boolean result = false;
    for (Games g : games) {
      if (g.isInGame(id)) {
        result = true;
        break;
      }
    }
    return result;
  }
}
