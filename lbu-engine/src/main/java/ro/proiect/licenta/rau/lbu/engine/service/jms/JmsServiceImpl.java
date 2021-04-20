package ro.proiect.licenta.rau.lbu.engine.service.jms;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public class JmsServiceImpl implements JmsService
{

  @Override
  public Optional<VoiceCallDetails> dequeueCall()
  {
    return Optional.empty();
  }
}
