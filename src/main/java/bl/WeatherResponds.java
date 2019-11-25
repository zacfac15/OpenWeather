/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import javax.swing.Icon;

/**
 *
 * @author fabia
 */
public class WeatherResponds
{
  private float id;
  private String main;
  private String description;
  private Icon icon;

  public float getId()
  {
    return id;
  }

  public void setId(float id)
  {
    this.id = id;
  }

  public String getMain()
  {
    return main;
  }

  public void setMain(String main)
  {
    this.main = main;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public Icon getIcon()
  {
    return icon;
  }

  public void setIcon(Icon icon)
  {
    this.icon = icon;
  }
  
  
}
