package ro.proiect.licenta.rau.engine.logic;

import org.springframework.stereotype.Service;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public interface CdrProcessor
{

  public void doProcess(VoiceCallDetails cdr);
}
