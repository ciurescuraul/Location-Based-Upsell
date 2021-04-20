package ro.proiect.licenta.rau.lbu.fileprocessor.service.jms;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

public interface JmsService
{

  boolean enqueueCall(VoiceCallDetails callDetails);
}
