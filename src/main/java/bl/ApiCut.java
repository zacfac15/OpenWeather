package bl;

import DataClasses.OpenWeatherResponse;
import DataClasses.Weather;
import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiCut
{

  private static String URI = "http://api.openweathermap.org/data/2.5/";
  private static String PATH = "weather";
  private static String APPID = "d098c83531678235423366b804870d8e";
  private OpenWeatherResponse res = new OpenWeatherResponse();


  /**
   * Is needed to get the Data from the API-Key
   *
   * @param name is the ZIP code from the destination
   * @throws IOException
   */
  public void getData(String name) throws IOException
  {
    Client client = ClientBuilder.newClient();

    Response r = client.target(URI)
            .path(PATH)
            .queryParam("APPID", APPID)
            .queryParam("q", name)
            .request(MediaType.APPLICATION_JSON)
            .get();

    System.out.println(r.toString());
    String text = r.readEntity(String.class);
    Gson gson = new Gson();
    System.out.println(text);
    res = gson.fromJson(text, OpenWeatherResponse.class);
  }

  /**
   *
   * @param name
   * @return finished Weather Object to Display in GUI
   * @throws java.io.IOException
   */
  public Weather parseData(String name) throws IOException
  {
    getData(name);
    float kelvin = (float) -273.15;
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

    destination = res.getName();
    country = res.getSys().getCountry();
    clouds = res.getWeather().get(0).getMain();
    description = res.getWeather().get(0).getDescription();
    windspeed = res.getWind().getSpeed();
    pressure = res.getMain().getPressure();
    humidity = res.getMain().getHumidity();

    float help = res.getMain().getTemp();
    currenttemp = help + kelvin;

    help = res.getMain().getTemp_min();
    mintemp = help + kelvin;

    help = res.getMain().getTemp_max();
    maxTemp = help + kelvin;

    help = res.getSys().getSunrise();
    sunrise = LocalDateTime.now().plusSeconds((long) help);

    help = res.getSys().getSunset();
    sunset = LocalDateTime.now().plusSeconds((long) help);

    Weather weather = new Weather(destination, country, clouds, description, windspeed, pressure, humidity, currenttemp, mintemp, maxTemp, sunrise, sunset);
    return weather;
  }
}
