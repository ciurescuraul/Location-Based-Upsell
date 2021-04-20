package ro.proiect.licenta.rau.lbu.core;

import java.util.ArrayList;
import java.util.List;

public class InterestArea
{

  /**
   * instance variables
   */
  int      id;
  AreaType areaType;
  String   name;

  List<String> cellIds = new ArrayList<String>();

  /**
   * getters and setters
   */
  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public AreaType getAreaType()
  {
    return areaType;
  }

  public void setAreaType(AreaType areaType)
  {
    this.areaType = areaType;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<String> getCellIds()
  {
    return cellIds;
  }

  public void setCellIds(List<String> cellIds)
  {
    this.cellIds = cellIds;
  }
}
