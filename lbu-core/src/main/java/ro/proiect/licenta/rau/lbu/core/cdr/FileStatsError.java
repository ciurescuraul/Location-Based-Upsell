package ro.proiect.licenta.rau.lbu.core.cdr;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "decodingFailed", "notSupported" })
public class FileStatsError
{

  @JsonProperty("decodingFailed")
  private int numDecodingFailed;

  @JsonProperty("notSupported")
  private int numNotSupported;

  public void incrementNumDecodingFailed()
  {
    numDecodingFailed++;
  }

  public void incrementNumNotSupported()
  {
    numNotSupported++;
  }

  public int getNumDecodingFailed()
  {
    return numDecodingFailed;
  }

  public void setNumDecodingFailed(int decodingFailed)
  {
    numDecodingFailed = decodingFailed;
  }

  public int getNumNotSupported()
  {
    return numNotSupported;
  }

  public void setNumNotSupported(int notSupported)
  {
    numNotSupported = notSupported;
  }
}
