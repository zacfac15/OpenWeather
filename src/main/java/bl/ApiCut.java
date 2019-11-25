package bl;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiCut
{

  private static String URI = "http://api.openweathermap.org/data/2.5/";
  private static String PATH = "weather";
  private static String APPID = "d098c83531678235423366b804870d8e";

  public void getData(String zip) throws IOException
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
    Gson gson = new Gson();
    System.out.println(text);
//    OpenWeatherResponse res = gson.fromJson(text, OpenWeatherResponse.class);
//    System.out.println(res);
//    Map<String,Object> map = gson.fromJson(text,new TypeToken<Map<String,Object>>(){}.getType());
//    System.out.println(map);
    
  }

  public static void main(String[] args)
  {
    ApiCut api = new ApiCut();
    try
    {
      api.getData("94040,us");
    } catch (IOException ex)
    {
      Logger.getLogger(ApiCut.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
