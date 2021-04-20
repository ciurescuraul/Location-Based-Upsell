package ro.proiect.licenta.rau.engine.service.jms;

import java.util.Optional;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

public interface JmsService
{

  Optional<VoiceCallDetails> dequeueCall();
}
