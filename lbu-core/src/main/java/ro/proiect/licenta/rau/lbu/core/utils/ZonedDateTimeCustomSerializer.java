package ro.proiect.licenta.rau.lbu.core.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ro.proiect.licenta.rau.lbu.core.LbuConstants;

import java.io.IOException;
import java.time.ZonedDateTime;

public class ZonedDateTimeCustomSerializer extends StdSerializer<ZonedDateTime>
{

  private static final long serialVersionUID = 1L;

  public ZonedDateTimeCustomSerializer()
  {
    this(null);
  }

  public ZonedDateTimeCustomSerializer(Class<ZonedDateTime> t)
  {
    super(t);
  }

  @Override
  public void serialize(ZonedDateTime value,
                        JsonGenerator generator,
                        SerializerProvider serializerProvider) throws IOException
  {
    generator.writeString(LbuConstants.DATE_FORMATTER.format(value));
  }
}
