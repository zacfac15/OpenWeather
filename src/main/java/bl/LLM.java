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

  /**
   * This methods adds a location to a list
   * @param loc loaction object, with city and country
   */
  public void add(Location loc)
  {
    list.add(loc);
    this.fireIntervalAdded(loc, list.size() - 1, list.size() - 1);
  }

  /**
   * replaces the constisting object if needed
   * @param index position where it will be replaced
   * @param loc new location object
   */
  public void replace(int index, Location loc)
  {
    list.set(index, loc);
    this.fireContentsChanged(this, index, index);
  }
  
  /**
   * to get the Name
   * @param index position of the item
   * @return the city name from the selected item to display the data
   */
  public String getName(int index)
  {
    return list.get(index).getName();
  }

  /**
   * Returns a location object and is mandatory for the replace mehtod
   * @param index of the selectet object
   * @return a location object
   */
  public Location get(int index)
  {
    return list.get(index);
  }

  /**
   * to remove a location object from the list
   * @param index selected item
   */
  public void remove(int index)
  {
    list.remove(index);
    this.fireIntervalRemoved(this, index, index);
  }
}
