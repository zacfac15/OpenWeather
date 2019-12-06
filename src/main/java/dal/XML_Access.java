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
  private final Document doc;
  private List<Location> list = new ArrayList<>();
  private Element locElem = new Element("LocationDB");

  public static XML_Access getXML() throws JDOMException, IOException
  {
    if (xml == null)
    {
      xml = new XML_Access();
    }

    return xml;
  }

  private XML_Access() throws JDOMException, IOException
  {
    SAXBuilder builder = new SAXBuilder();
    doc = builder.build(new File(XMLPATH));
  }

  public void persistXML() throws IOException
  {
    XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

    try (FileOutputStream fos = new FileOutputStream(new File(XMLPATH)))
    {
      out.output(doc, fos);
      out.output(doc, System.out);
    }
  }

  public void getLocations()
  {
    for (Element loaction : doc.getRootElement().getChildren())
    {
      if (loaction.getName().equalsIgnoreCase("city"))
      {
        list.add(new Location(loaction.getAttributeValue("City"),loaction.getAttributeValue("Country")));
      }
    }
  }

  public void saveLocations() throws IOException
  {
    Element loc = new Element("Location");

    for (Location location : list)
    {
      Element city = new Element("city");
      city.setAttribute("City", "" + location.getName());
      loc.addContent(city);
      Element country = new Element("country");
      country.setAttribute("Country",""+location.getCountry());
      city.addContent(country);
    }

    locElem.addContent(loc);

    xml.persistXML();
  }
}
