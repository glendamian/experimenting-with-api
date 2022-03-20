import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class to represent a Game.
 */
public class Games {
  private final int gameNumber;
  private final List<Integer> players;
  private final Map<String, List<Integer>> takes;

  /**
   * Default constructor for a single game.
   * @param id the game id.
   * @param players the list of players that are participating in a single round.
   * @param takes the list of takes in a single round.
   */
  public Games(int id, List<Integer> players, Map<String, List<Integer>> takes)
          throws IllegalArgumentException {
    if (Objects.isNull(players) || Objects.isNull(takes)) {
      throw new IllegalArgumentException("Objects cannot be null.");
    }
    this.gameNumber = id;
    this.players = players;
    this.takes = takes;
  }

  /**
   * Get the total score a player in one round of a game.
   * @param id the player id.
   * @return the total score in a round.
   */
  protected int scorePerRound(String id) {
    int result = 0;
    if (this.isInGame(id)) {
      for (String s : this.takes.keySet()) {
        if (Objects.equals(id, s)) {
          for (int scores : this.takes.get(s)) {
            result += scores;
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the total number of takes in a round of game.
   *
   * @param id the player id.
   * @return the number of takes in a round.
   */
  protected int takesPerRound(String id) {
    int result = 0;
    if (this.isInGame(id)) {
      for (String s : this.takes.keySet()) {
        if (id.equals(s)) {
          result = this.takes.get(s).size();
          break;
        }
      }
    }
    return result;
  }

  /**
   * Determine if the player wins the current round.
   *
   * @param id the player id.
   * @return true if the player wins.
   */
  protected boolean winThisRound(String id) {
    boolean result = true;
    if (this.isInGame(id)) {
      int playerScore = this.scorePerRound(id);
      for (String s : this.takes.keySet()) {
      /*
      If the current id is equal to the given id, we do not compare the values.
      If the score is equal or lower, then the current player does not win.
       */
        if (!s.equals(id)) {
          if ((playerScore <= this.scorePerRound(s))) {
            result = false;
            break;
          }
        }
      }
    } else {
      result = false;
    }
    return result;
  }

  /**
   * Determine if a player is participating in this round.
   * @param id the player id.
   * @return yes if the player is participating.
   */
  protected boolean isInGame(String id) {
    boolean result = false;
    for (int p : this.players) {
      if (Integer.parseInt(id) == p) {
        result = true;
        break;
      }
    }
    return result;
  }

}
