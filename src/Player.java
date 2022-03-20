import java.util.Objects;

/**
 * Class representing a single player in the game.
 */
public class Player {
  private final int id;
  private final String name;

  /**
   * Constructor for a player.
   * @param id the player id.
   * @param name the player name.
   */
  public Player(int id, String name) throws IllegalArgumentException {
    if (Objects.isNull(id) || Objects.isNull(name)) {
      throw new IllegalArgumentException("Objects cannot be null.");
    }
    this.id = id;
    this.name = name;
  }

  /**
   * Gets the player id.
   * @return the player id.
   */
  protected int getID() {
    return this.id;
  }

  /**
   * Gets the player's name.
   * @return the player's name.
   */
  protected String getName() {
    return this.name;
  }

}
