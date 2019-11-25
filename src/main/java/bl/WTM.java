package bl;

import java.time.LocalDateTime;
import java.time.Month;
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

  
  public void getExportData(String zip)
  {
    String[] tokens = api.getData(zip);

    String name;
    String country;
    String condition;
    String description;
    String windspeed;
    int pressure;
    int humidity;
    double currenttemp;
    double mintemp;
    double maxtemp;
    LocalDateTime sunrise;
    LocalDateTime sunset;

  }

}
