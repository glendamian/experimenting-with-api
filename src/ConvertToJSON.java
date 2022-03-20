import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to convert objects back to JSON.
 */
public class ConvertToJSON {

  public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    List<ResultStatistic> finalResults = new ArrayList<ResultStatistic>();
    finalResults = gratitude(finalResults);
    System.out.println(gson.toJson(finalResults));
  }

  public static List<ResultStatistic> gratitude(List<ResultStatistic> finalResults)
          throws FileNotFoundException {
    Reader reader = new FileReader("response.json");
    Gson gson = new Gson();
    GratitudeNUImpl game = gson.fromJson(reader, GratitudeNUImpl.class);


    for (Player p : game.playerInfo) {
      ResultStatistic result = new ResultStatistic();
      /*
      Checks if player is not in any game.
       */
      if (!game.atLeastOne(Integer.toString(p.getID()))) {
        result.setId(p.getID());
        result.setName(p.getName());
        result.setTS("N/A");
        result.setAT("N/A");
        result.setGW("N/A");
        /*
        If player is in at least one game, we set the corresponding data for the JSON.
         */
      } else {
        result.setId(p.getID());
        result.setName(p.getName());
        result.setTS(game.getTotalScore(Integer.toString(p.getID())));
        result.setAT(game.getAverageTake(Integer.toString(p.getID())));
        result.setGW(game.getGamesWon(Integer.toString(p.getID())));
      }
      finalResults.add(result);
    }
    return finalResults;
  }
}