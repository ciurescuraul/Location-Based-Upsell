package ro.proiect.licenta.rau.lbu.core;

public enum AreaType
{

  NORMAL(0),
  AIRPORT(1),
  CONCERT(2);

  private final int areaCode;

  private AreaType(int areaCode)
  {
    this.areaCode = areaCode;
  }

  /**
   * Return AreaType by AreaCode
   * 
   * @param areaCode
   * @return
   */
  public static AreaType getByCode(int areaCode)
  {
    for (AreaType areaType : values())
    {
      if (areaType.areaCode == areaCode)
      {
        return areaType;
      }
    }
    return NORMAL;
  }

  public int getAreaCode()
  {
    return areaCode;
  }
}
