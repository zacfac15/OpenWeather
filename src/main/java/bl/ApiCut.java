package bl;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

  public OpenWeatherResponse getData(String zip) throws IOException
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
    OpenWeatherResponse res = gson.fromJson(text, OpenWeatherResponse.class);
    
    return res;
  }

  public Weather parseData(OpenWeatherResponse res, String zip)
  {
    int plz;
    String destination;
    String country;
    String clouds;
    String description;
    float windspeed;
    float pressure;
    float humidity;
    float currenttemp;
    float mintemp;
    float maxTemp;
    LocalDateTime sunrise;
    LocalDateTime sunset;

    plz = Integer.parseInt(zip);
    destination = res.getName();
    country = res.getSys().getCountry();
    clouds = res.getWeather().get(0).getMain();
    description = res.getWeather().get(0).getDescription();
    windspeed = res.getWind().getSpeed();
    pressure = res.getMain().getPressure();
    humidity = res.getMain().getHumidity();
    
    float help = res.getMain().getTemp();
    currenttemp =(float) (( 5.0 *(help - 32.0)) / 9.0);
    
    help = res.getMain().getTemp_min();
    mintemp =(float) (( 5.0 *(help - 32.0)) / 9.0);
    
    help = res.getMain().getTemp_max();
    maxTemp = (float) (( 5.0 *(help - 32.0)) / 9.0);
    
    help = res.getSys().getSunrise();
    sunrise = LocalDateTime.now().plusSeconds((long) help);
    
    help = res.getSys().getSunset();
    sunset = LocalDateTime.now().plusSeconds((long) help);
    
    Weather weather = new Weather(plz, destination, country, clouds, description, windspeed, pressure, humidity, currenttemp, mintemp, maxTemp, sunrise, sunset);
    return weather;
  }

  public static void main(String[] args)
  {
    ApiCut api = new ApiCut();
    try
    {
      Weather weather = api.parseData(api.getData("94040,us"),"94040");
    } catch (IOException ex)
    {
      Logger.getLogger(ApiCut.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
