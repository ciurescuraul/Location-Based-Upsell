package ro.proiect.licenta.rau.lbu.core;

public class LbuGenericJson
{

  private LbuTimestampBean ts = new LbuTimestampBean();

  public LbuGenericJson(boolean writeOnly)
  {
    // no need to save lastModified for writeOnly objects
    if (writeOnly)
    {
      ts.setLastModified(null);
    }
  }

  public LbuTimestampBean getTs() {
    return ts;
  }

  public void setTs(LbuTimestampBean timeStamp) {
    ts = timeStamp;
  }
}
