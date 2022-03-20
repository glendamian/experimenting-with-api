import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * POJO class.
 */
public class ResultStatistic {
  /*
  The reason that I have Objects for most of the field type is because if
  a player has not played in any of the games, then each one of their statistics will be "N/A" and
  not an Integer.
   */
  private int id;
  private String name;
  private Object totalScore;
  private Object averageTake;
  private Object gamesWon;

  /*
  List of getter methods and methods to set/assign values to corresponding data in JSON.
   */
  protected int getId() {
    return id;
  }

  protected void setId(int id) {
    this.id = id;
  }

  protected String getName() {
    return this.name;
  }

  protected void setName(String name) {
    this.name = name;
  }

  protected Object getTS() {
    return this.totalScore;
  }

  protected void setTS(Object totalScore) {
    this.totalScore = totalScore;
  }

  protected Object getAT() {
    return this.averageTake;
  }

  protected void setAT(Object averageTake) {
    this.averageTake = averageTake;
  }

  protected Object getGW() {
    return gamesWon;
  }

  protected void setGW(Object gamesWon) {
    this.gamesWon = gamesWon;
  }





}
