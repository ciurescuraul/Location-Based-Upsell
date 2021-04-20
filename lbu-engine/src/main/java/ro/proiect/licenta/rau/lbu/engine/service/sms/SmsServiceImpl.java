package ro.proiect.licenta.rau.lbu.engine.service.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsServiceImpl implements SmsService
{

  static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

  @Override
  public void sendSms(String msisdnTo, String message)
  {
    logger.debug("Sending '{}' to '{}'", message, msisdnTo);
  }
}
