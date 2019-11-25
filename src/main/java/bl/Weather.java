package bl;

import java.time.LocalDateTime;

public class Weather
{
  private int plz;
  private String destination;
  private String country;
  private String clouds;
  private String description;
  private int windspeed;
  private int pressure;
  private int humidity;
  private double currenttemp;
  private double mintemp;
  private double maxTemp;
  private LocalDateTime sunrise;
  private LocalDateTime sunset;

  public Weather(int plz, String destination, String country, String clouds, String description, int windspeed, int pressure, int humidity, double currenttemp, double mintemp, double maxTemp, LocalDateTime sunrise, LocalDateTime sunset)
  {
    this.plz = plz;
    this.destination = destination;
    this.country = country;
    this.clouds = clouds;
    this.description = description;
    this.windspeed = windspeed;
    this.pressure = pressure;
    this.humidity = humidity;
    this.currenttemp = currenttemp;
    this.mintemp = mintemp;
    this.maxTemp = maxTemp;
    this.sunrise = sunrise;
    this.sunset = sunset;
  }

  public int getPlz()
  {
    return plz;
  }

  public String getDestination()
  {
    return destination;
  }

  public String getCountry()
  {
    return country;
  }

  public String getClouds()
  {
    return clouds;
  }

  public String getDescription()
  {
    return description;
  }

  public int getWindspeed()
  {
    return windspeed;
  }

  public int getPressure()
  {
    return pressure;
  }

  public int getHumidity()
  {
    return humidity;
  }

  public double getCurrenttemp()
  {
    return currenttemp;
  }

  public double getMintemp()
  {
    return mintemp;
  }

  public double getMaxTemp()
  {
    return maxTemp;
  }

  public LocalDateTime getSunrise()
  {
    return sunrise;
  }

  public LocalDateTime getSunset()
  {
    return sunset;
  }

  
  
  
}
