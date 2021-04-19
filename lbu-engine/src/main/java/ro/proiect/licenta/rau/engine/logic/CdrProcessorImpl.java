package ro.proiect.licenta.rau.engine.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

public class CdrProcessorImpl implements CdrProcessor
{

  static final Logger logger = LoggerFactory.getLogger(CdrProcessorImpl.class);

  @Override
  public void doProcess(VoiceCallDetails cdr)
  {
    logger.debug("Dummy processing of '{}'", cdr);
  }
}
