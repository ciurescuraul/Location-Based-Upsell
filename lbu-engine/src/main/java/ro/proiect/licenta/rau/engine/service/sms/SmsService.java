package ro.proiect.licenta.rau.engine.service.sms;

public interface SmsService
{

  void sendSms(String msisdnTo, String message);
}
