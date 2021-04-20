package ro.proiect.licenta.rau.lbufileprocessor.service.jms;

import org.springframework.stereotype.Service;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public class JmsServiceImpl implements JmsService
{

  private final JmsConfig jmsConfig;

  public JmsServiceImpl(JmsConfig jmsConfig)
  {
    this.jmsConfig = jmsConfig;
  }

  @Override
  public boolean enqueueCall(VoiceCallDetails callDetails)
  {
    boolean enqueued = true;

    // TODO implement this part

    return enqueued;
  }
}
