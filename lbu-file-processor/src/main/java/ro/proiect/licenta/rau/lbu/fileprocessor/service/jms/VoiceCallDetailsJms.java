package ro.proiect.licenta.rau.lbu.fileprocessor.service.jms;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ro.proiect.licenta.rau.lbu.core.LbuConstants;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@JsonIgnoreProperties(value = { "ts" })
public class VoiceCallDetailsJms extends VoiceCallDetails
{

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonFormat(pattern = LbuConstants.JSON_DATE_FORMAT)
  private LocalDateTime callStartTime;

  public VoiceCallDetailsJms(String msisnd)
  {
    super(msisnd);
    this.callStartTime = super.getCallStartTime();
  }
}
