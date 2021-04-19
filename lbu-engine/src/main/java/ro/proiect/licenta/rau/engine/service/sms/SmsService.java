package ro.proiect.licenta.rau.engine.service.sms;

import org.springframework.stereotype.Service;

@Service
public interface SmsService
{

  public void sendSms(String msisdnTo, String message);
}
