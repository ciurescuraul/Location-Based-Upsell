package ro.proiect.licenta.rau.lbu.core;

public class LbuGenericJson
{

  private LbuTimestampBean timestamp = new LbuTimestampBean();

  public LbuGenericJson(boolean writeOnly)
  {
    // no need to save lastModified for writeOnly objects
    if (writeOnly)
    {
      timestamp.setLastModified(null);
    }
  }

  public LbuTimestampBean getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp(LbuTimestampBean timeStamp)
  {
    timestamp = timeStamp;
  }
}
