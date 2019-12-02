package DataClasses;

import java.time.LocalDateTime;

public class Weather
{
  private String destination;
  private String country;
  private String clouds;
  private String description;
  private float windspeed;
  private float pressure;
  private float humidity;
  private float currenttemp;
  private float mintemp;
  private float maxTemp;
  private LocalDateTime sunrise;
  private LocalDateTime sunset;

  public Weather( String destination, String country, String clouds, String description, float windspeed, float pressure, float humidity, float currenttemp, float mintemp, float maxTemp, LocalDateTime sunrise, LocalDateTime sunset)
  {
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

  public String getDestination()
  {
    return destination;
  }

  public void setDestination(String destination)
  {
    this.destination = destination;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getClouds()
  {
    return clouds;
  }

  public void setClouds(String clouds)
  {
    this.clouds = clouds;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public float getWindspeed()
  {
    return windspeed;
  }

  public void setWindspeed(float windspeed)
  {
    this.windspeed = windspeed;
  }

  public float getPressure()
  {
    return pressure;
  }

  public void setPressure(float pressure)
  {
    this.pressure = pressure;
  }

  public float getHumidity()
  {
    return humidity;
  }

  public void setHumidity(float humidity)
  {
    this.humidity = humidity;
  }

  public float getCurrenttemp()
  {
    return currenttemp;
  }

  public void setCurrenttemp(float currenttemp)
  {
    this.currenttemp = currenttemp;
  }

  public float getMintemp()
  {
    return mintemp;
  }

  public void setMintemp(float mintemp)
  {
    this.mintemp = mintemp;
  }

  public float getMaxTemp()
  {
    return maxTemp;
  }

  public void setMaxTemp(float maxTemp)
  {
    this.maxTemp = maxTemp;
  }

  public LocalDateTime getSunrise()
  {
    return sunrise;
  }

  public void setSunrise(LocalDateTime sunrise)
  {
    this.sunrise = sunrise;
  }

  public LocalDateTime getSunset()
  {
    return sunset;
  }

  public void setSunset(LocalDateTime sunset)
  {
    this.sunset = sunset;
  }

  
}
