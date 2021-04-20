package ro.proiect.licenta.rau.lbu.core.utils;

import java.io.IOException;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import ro.proiect.licenta.rau.lbu.core.LbuConstants;

public class ZonedDateTimeCustomDeserializer extends
                                             StdDeserializer<ZonedDateTime>
{

  private static final long serialVersionUID = 1L;

  public ZonedDateTimeCustomDeserializer()
  {
    this(null);
  }

  public ZonedDateTimeCustomDeserializer(Class<ZonedDateTime> t)
  {
    super(t);
  }

  @Override
  public ZonedDateTime deserialize(JsonParser jp,
                                   DeserializationContext dc) throws IOException,
                                                              JsonProcessingException
  {
    return ZonedDateTime.parse(jp.getText(), LbuConstants.DATE_FORMATTER);
  }
}
