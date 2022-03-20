/**
 * Interface to represent GratitudeNU game.
 */
public interface GratitudeNU {
  /**
   * Gets the total score of an individual player in all games.
   *
   * @param id the player id.
   * @return the total score.
   */
  public int getTotalScore(String id);

  /**
   * Gets the average take of an individual player in all games.
   *
   * @param id the player id.
   * @return the total score.
   */
  public double getAverageTake(String id);

  /**
   * Gets the total games won for an individual player.
   *
   * @param id the player id.
   * @return the total score.
   */
  public int getGamesWon(String id);
}
