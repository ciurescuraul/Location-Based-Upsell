package ro.proiect.licenta.rau.lbu.core.cdr;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "decodingFailed", "notSupported" })
public class FileStatsError
{

  @JsonProperty("decodingFailed")
  int numDecodingFailed;

  @JsonProperty("notSupported")
  int numNotSupported;

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
