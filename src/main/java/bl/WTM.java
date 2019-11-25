package bl;

import DataClasses.Weather;
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

  public void addToList(String zip)
  {
    Weather w = api.parseData(zip);
    weather.add(w);
    this.fireTableRowsInserted(weather.size()-1, weather.size()-1);
  }

}
