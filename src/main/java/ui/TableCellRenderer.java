package ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRenderer extends DefaultTableCellRenderer
{

  /**
   * to change the color of the cells
   * @param table
   * @param value
   * @param isSelected
   * @param hasFocus
   * @param row
   * @param column
   * @return 
   */
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
  {
    Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    int col = table.convertColumnIndexToModel(column);

    if (col == 1)
    {
      float no = (float) value;
      if (no <= 0)
      {
        setBackground(Color.blue);
      } else if (no >= 1 && no <= 10)
      {
        setBackground(Color.GREEN);
      } else if (no >= 11 && no <= 20)
      {
        setBackground(Color.yellow);
      } else if (no >= 21 && no <= 30)
      {
        setBackground(Color.orange);
      } else if (no >= 31)
      {
        setBackground(Color.red);
      } else
      {
        setBackground(table.getBackground());
      }
    } else
    {
      setBackground(table.getBackground());
    }
    return comp;
  }
}
