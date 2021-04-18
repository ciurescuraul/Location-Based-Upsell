package ro.proiect.licenta.rau.lbufileprocessor.service.jms;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

public interface JmsService {

    public void enqueueCall(VoiceCallDetails callDetails);
}
