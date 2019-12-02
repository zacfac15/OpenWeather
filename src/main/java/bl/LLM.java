package bl;

import DataClasses.Location;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

public class LLM extends AbstractListModel
{

  private List<Location> list = new ArrayList<>();

  @Override
  public int getSize()
  {
    return list.size();
  }

  @Override
  public Object getElementAt(int index)
  {
    return list.get(index);
  }

  public void add(Location loc)
  {
    list.add(loc);
    this.fireIntervalAdded(loc, list.size() - 1, list.size() - 1);
  }

  public void replace(int index, Location loc)
  {
    list.set(index, loc);
    this.fireContentsChanged(this, index, index);
  }
  
  public String getName(int index)
  {
    return list.get(index).getName();
  }

  public Location get(int index)
  {
    return list.get(index);
  }

  public void remove(int index)
  {
    list.remove(index);
    this.fireIntervalRemoved(this, index, index);
  }
}
