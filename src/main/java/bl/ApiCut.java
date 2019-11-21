package bl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiCut
{

  private static String URI = "http://api.openweathermap.org/data/2.5/";
  private static String PATH = "weather";
  private static String APPID = "d098c83531678235423366b804870d8e";

  
  /**
   * Gets the data from the weatherservice and place it formated in a String array
   * @param zip wanted location
   * @return the splited values from the weather service
   */
  public String[] getData(String zip)
  {
    Client client = ClientBuilder.newClient();

    Response r = client.target(URI)
            .path(PATH)
            .queryParam("APPID", APPID)
            .queryParam("zip", zip)
            .request(MediaType.APPLICATION_JSON)
            .get();

    System.out.println(r.toString());
    String text = r.readEntity(String.class);
    text = text.replace("{", "");
    text = text.replace("}", "");
    text = text.replace("[", "");
    text = text.replace("]", "");
    text = text.replace("coord", "");
    text = text.replace("\"", "");
    text = text.substring(1);
    System.out.println(text);
    String[] tokens = text.split(",");
    String[] help = new String[2];

    return tokens;
  }
  
  public static void main(String[] args)
  {
    ApiCut api = new ApiCut();
    api.getData("94040,us");
  }
}

