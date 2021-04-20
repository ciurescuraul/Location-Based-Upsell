package ro.proiect.licenta.rau.lbu.core.cdr;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "msisdn", "location", "starttime", "duration" })
public class VoiceCallDetails extends Cdr
{

  private String        msisnd;
  private String        location;
  private LocalDateTime callStartTime;
  private int           duration;

  public VoiceCallDetails(String msisnd)
  {
    this.msisnd = msisnd;
    callStartTime = LocalDateTime.now();
  }

  public String getMsisnd()
  {
    return msisnd;
  }

  public void setMsisnd(String isnd)
  {
    msisnd = isnd;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public LocalDateTime getCallStartTime()
  {
    return callStartTime;
  }

  public void setCallStartTime(LocalDateTime callStartTime)
  {
    this.callStartTime = callStartTime;
  }

  public int getDuration()
  {
    return duration;
  }

  public void setDuration(int duration)
  {
    this.duration = duration;
  }

  @Override
  public String toString()
  {
    return "VoiceCallDetails{" + "msisnd='" + msisnd + '\'' + ", location='" +
           location + '\'' + ", callStartTime=" + callStartTime +
           ", duration=" + duration + '}';
  }
}
