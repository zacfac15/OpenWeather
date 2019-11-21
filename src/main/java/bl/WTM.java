package bl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WTM extends AbstractTableModel
{
  private List<Weather> weather = new ArrayList<>();
  private ApiCut api = new ApiCut();

  @Override
  public int getRowCount()
  {
    return weather.size();
  }

  @Override
  public int getColumnCount()
  {
    return 5;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    return null;
  }
  
  
  /**
   * Reads the required data from the the array
   * @param zip 
   */
  public void getExportData(String zip)
  {
    String[] tokens = api.getData(zip);
    
    String name;
    String country;
    String condition;
    String description;
    int windspeed;
    int pressure;
    int humidity;
    double currenttemp;
    double mintemp;
    double maxtemp;
    LocalDateTime sunrise;
    LocalDateTime sunset;
    
    String[] arr = new String[3];
    
    for (String token : tokens)
    {
      if(token.equalsIgnoreCase("country"))
      {
        arr = token.split(":");
        int length = arr.length;
        country = arr[length-1];
      }
      else if(token.equalsIgnoreCase("name"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("speed"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("sunset"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("sunrise"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("temp_min"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("temp_max"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("main:temp"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("humidity"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("pressure"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
      else if(token.equalsIgnoreCase("wind:speed"))
      {
        arr = token.split(":");
        int length = arr.length;
      }
    }
  }
}
