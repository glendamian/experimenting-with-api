import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Class to convert JSON to objects in order to obtain data for the project.
 */
public class ConvertToObject {
  Reader reader = new FileReader("response.json");
  Gson gson = new Gson();
  GratitudeNUImpl game = gson.fromJson(reader, GratitudeNUImpl.class);


  public ConvertToObject() throws FileNotFoundException {
  }
}
