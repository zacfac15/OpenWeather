package bl;

import DataClasses.Weather;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WTM extends AbstractTableModel
{

  private List<Weather> weatherList = new ArrayList<>();
  private ApiCut api = new ApiCut();
  private String[] headers = {"Country","Current Temprature","Pressure","Clouds","Windspeed","Description","Destination"};

  @Override
  public int getRowCount()
  {
    return weatherList.size();
  }

  @Override
  public int getColumnCount()
  {
    return 7;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Weather weather = weatherList.get(rowIndex);
    
    switch(columnIndex)
    {
      case 0: return weather.getCountry();
      case 1: return weather.getCurrenttemp();
      case 2: return weather.getPressure();
      case 3: return weather.getClouds();
      case 4: return weather.getWindspeed();
      case 5: return weather.getDescription();
      case 6: return weather.getDestination();
      default: return "error";
    }
  }
  
  /**
   * Displayes the Columnnames for the Table
   * @param column colmunIndex for the Header
   * @return a String with the columnname
   */

  @Override
  public String getColumnName(int column)
  {
    return headers[column];
  }

  
  /**
   * To add in the List and to call the api( in another class)
   * @param name City name to call API
   * @throws IOException 
   */
  public void addToList(String name) throws IOException
  {
    Weather w = api.parseData(name);
    weatherList.add(w);
    this.fireTableRowsInserted(weatherList.size()-1, weatherList.size()-1);
  }

}
