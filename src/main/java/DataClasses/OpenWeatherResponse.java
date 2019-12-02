package DataClasses;

import java.util.List;

/**
 *
 * @author fabia
 */
public class OpenWeatherResponse
{

  private CoordResponds coord;
  private List<WeatherResponds> weather;
  private String base;
  private MainResponse main;
  private float visibility;
  private WindResponde wind;
  private CloudResponde cloud;
  private String dt;
  private SysResponde sys;
  private float timezone;
  private float id;
  private String name;
  private float cod;

  public CoordResponds getCoord()
  {
    return coord;
  }

  public void setCoord(CoordResponds coord)
  {
    this.coord = coord;
  }

  public List<WeatherResponds> getWeather()
  {
    return weather;
  }

  public void setWeather(List<WeatherResponds> weather)
  {
    this.weather = weather;
  }

  public String getBase()
  {
    return base;
  }

  public void setBase(String base)
  {
    this.base = base;
  }

  public MainResponse getMain()
  {
    return main;
  }

  public void setMain(MainResponse main)
  {
    this.main = main;
  }

  public float getVisibility()
  {
    return visibility;
  }

  public void setVisibility(float visibility)
  {
    this.visibility = visibility;
  }

  public WindResponde getWind()
  {
    return wind;
  }

  public void setWind(WindResponde wind)
  {
    this.wind = wind;
  }

  public CloudResponde getCloud()
  {
    return cloud;
  }

  public void setCloud(CloudResponde cloud)
  {
    this.cloud = cloud;
  }

  public String getDt()
  {
    return dt;
  }

  public void setDt(String dt)
  {
    this.dt = dt;
  }

  public SysResponde getSys()
  {
    return sys;
  }

  public void setSys(SysResponde sys)
  {
    this.sys = sys;
  }

  public float getTimezone()
  {
    return timezone;
  }

  public void setTimezone(float timezone)
  {
    this.timezone = timezone;
  }

  public float getId()
  {
    return id;
  }

  public void setId(float id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public float getCod()
  {
    return cod;
  }

  public void setCod(float cod)
  {
    this.cod = cod;
  }

 
}
