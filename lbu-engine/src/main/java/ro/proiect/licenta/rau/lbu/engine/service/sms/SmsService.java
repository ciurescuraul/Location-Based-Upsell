package ro.proiect.licenta.rau.lbu.engine.service.sms;

public interface SmsService
{

  void sendSms(String msisdnTo, String message);
}
