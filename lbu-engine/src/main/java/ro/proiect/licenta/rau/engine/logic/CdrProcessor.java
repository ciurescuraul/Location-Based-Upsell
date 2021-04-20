package ro.proiect.licenta.rau.engine.logic;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

public interface CdrProcessor
{

  void doProcess(VoiceCallDetails cdr);
}
