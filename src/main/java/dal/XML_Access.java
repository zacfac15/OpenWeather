package dal;

import DataClasses.Location;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XML_Access
{

  public static XML_Access xml;
  private static final String XMLPATH = "xml/locations.xml";
  private Document doc;
  private Element root;
  private Element locElem = new Element("Locations");

  public static XML_Access getXML() throws JDOMException, IOException
  {
    if (xml == null)
    {
      xml = new XML_Access();
    }
    return xml;
  }

  /**
   * if the document did not exist a new one will be created
   * @throws JDOMException
   * @throws IOException 
   */
  private XML_Access() throws JDOMException, IOException
  {
    if (doc == null)
    {
      doc = new Document();
      doc.addContent(locElem);
    } else
    {
      SAXBuilder builder = new SAXBuilder();
      doc = builder.build(new File(XMLPATH));
    }
  }

  /**
   * to format the xml
   * @throws IOException 
   */
  public void persistXML() throws IOException
  {
    XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

    try (FileOutputStream fos = new FileOutputStream(new File(XMLPATH)))
    {
      out.output(doc, fos);
      out.output(doc, System.out);
    }
  }

  /**
   * to load the saved locations in the list model
   *
   * @return to return it to the GUI
   */
  public List<Location> getLocations()
  {
    List<Location> list = new ArrayList<>();
    for (Element loaction : doc.getRootElement().getChildren())
    {
      if (loaction.getName().equalsIgnoreCase("city"))
      {
        list.add(new Location(loaction.getAttributeValue("City"), loaction.getAttributeValue("Country")));
      }
    }
    return list;
  }

  /**
   * to save the locations in a xml file
   *
   * @param list gets the lsit form the gui to save the Locations
   * @throws IOException
   */
  public void saveLocations(List<Location> list) throws IOException
  {
    System.out.println(list.toString());
    Element loc = new Element("Location");

    for (Location location : list)
    {
      Element city = new Element("city");
      city.setAttribute("City", "" + location.getName());
      loc.addContent(city);
      Element country = new Element("country");
      country.setAttribute("Country", "" + location.getCountry());
      city.addContent(country);
    }
    System.out.println(list.toString());
    locElem.addContent(loc);
    xml.persistXML();
  }
}
