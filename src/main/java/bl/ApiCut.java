package bl;

import DataClasses.OpenWeatherResponse;
import DataClasses.Weather;
import com.google.gson.Gson;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiCut
{

  private static String URI = "http://api.openweathermap.org/data/2.5/";
  private static String forcastURI = "http://pro.openweathermap.org/data/2.5/forecast/hourly?";
  private static String PATH = "weather";
  private static String APPID = "d098c83531678235423366b804870d8e";
  private OpenWeatherResponse res = new OpenWeatherResponse();
  private static final String iconPath = System.getProperty("user.dir")
          + File.separator + "src"
          + File.separator + "main"
          + File.separator + "java"
          + File.separator + "icons";

  String[] icons =
  {
    "bewoelkt.jpg", "gewitter.jpg", "regen.jpg", "schnee.jpg", "sonnig.jpg"
  };

  /**
   * Is needed to get the Data from Open Weather
   *
   * @param name is the ZIP code from the destination
   * @throws IOException
   */
  public void getForcast()
  {

  }

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
   * to parse the data in the known units
   *
   * @param name is the name with which the API will be called
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

    ImageIcon icon = getIcon(description);

    Weather weather = new Weather(destination, country, clouds, description, windspeed, pressure, humidity, currenttemp, mintemp, maxTemp, sunrise, sunset, icon);
    return weather;
  }

  public ImageIcon getIcon(String description) throws IOException
  {
    String con = "";

    if (description.equalsIgnoreCase("broken clouds"))
    {
      con = icons[0];
    }
    else{
      con = icons[2];
    }

    String help = iconPath + "\\" + con;
    System.out.println(help);
    
    Image img = ImageIO.read(new File(help));
    img = img.getScaledInstance(40, 25, Image.SCALE_SMOOTH);

    return new ImageIcon(img);
  }
}
