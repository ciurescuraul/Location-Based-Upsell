package ro.proiect.licenta.rau.engine.service.jms;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public interface JmsService
{

  public Optional<VoiceCallDetails> dequeueCall();
}
