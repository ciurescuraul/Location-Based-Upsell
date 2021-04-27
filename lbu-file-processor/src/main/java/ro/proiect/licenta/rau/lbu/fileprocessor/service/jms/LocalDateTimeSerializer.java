package ro.proiect.licenta.rau.lbu.fileprocessor.service.jms;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime>
{

  private static DateTimeFormatter formatter = DateTimeFormatter
      .ofPattern("yyyyMMddHHmmss");

  protected LocalDateTimeSerializer(Class<LocalDateTime> t)
  {
    super(t);
  }

  public LocalDateTimeSerializer()
  {
    this(null);
  }

  @Override
  public void serialize(LocalDateTime value,
                        JsonGenerator gen,
                        SerializerProvider provider) throws IOException
  {
    gen.writeString(formatter.format(value));
  }
}
