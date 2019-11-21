package bl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WTM extends AbstractTableModel
{
  private List<Weather> weather = new ArrayList<>();

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
  
}
