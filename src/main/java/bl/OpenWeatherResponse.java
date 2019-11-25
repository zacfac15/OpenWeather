/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.List;

/**
 *
 * @author fabia
 */
public class OpenWeatherResponse
{

  private List<CoordResponds> coord;
  private List<WeatherResponds> weather;
  private String base;
  private List<MainResponse> main;
  private float visibility;
  private List<WindResponde> wind;
  private List<CloudResponde> cloud;
  private String dt;
  private List<SysResponde> sys;
  private float timezone;
  private float id;
  private String name;
  private float cod;

  public List<CoordResponds> getCoord()
  {
    return coord;
  }

  public void setCoord(List<CoordResponds> coord)
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

  public List<MainResponse> getMain()
  {
    return main;
  }

  public void setMain(List<MainResponse> main)
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

  public List<WindResponde> getWind()
  {
    return wind;
  }

  public void setWind(List<WindResponde> wind)
  {
    this.wind = wind;
  }

  public List<CloudResponde> getCloud()
  {
    return cloud;
  }

  public void setCloud(List<CloudResponde> cloud)
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

  public List<SysResponde> getSys()
  {
    return sys;
  }

  public void setSys(List<SysResponde> sys)
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
