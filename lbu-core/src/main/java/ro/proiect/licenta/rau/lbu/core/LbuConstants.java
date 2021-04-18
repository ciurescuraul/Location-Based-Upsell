package ro.proiect.licenta.rau.lbu.core;

import java.time.format.DateTimeFormatter;

public class LbuConstants
{

  public static final String JSON_DATE_FORMAT           = "yyyyMMddHHmmss";
  public static final String JSON_DATE_FORMAT_TZ        = "yyyyMMddHHmmssxx";
  public static final String JSON_DAY_FORMAT            = "yyyyMMdd";
  public static final String JSON_BUSINESS_HOURS_FORMAT = "HH:mm:ss";

  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
      .ofPattern(JSON_DATE_FORMAT_TZ);

  public static final String COUNTRY_CODE_ROMANIA = "40";
}
