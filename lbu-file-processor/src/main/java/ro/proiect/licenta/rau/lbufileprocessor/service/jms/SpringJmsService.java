package ro.proiect.licenta.rau.lbufileprocessor.service.jms;

import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.jmx.JmxException;

import org.springframework.stereotype.Component;
import ro.proiect.licenta.rau.lbu.core.LbuConstants;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

/**
 * JMSTemplate class is the central class in the JMS core package.
 * It simplifies the use of JMS, since it handles the creation and release of
 * resources when sending or synchronously receiving messages.
 * Spring JMS documentation:
 * https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#jms
 * https://spring.io/guides/gs/messaging-jms/
 */

@Component
public class SpringJmsService implements JmsService
{

  static final Logger logger = LoggerFactory.getLogger(SpringJmsService.class);

  @Autowired
  JmsTemplate jmsTemplate;

  @Autowired
  JmsConfig jmsConfig;

  @Override
  public boolean enqueueCall(VoiceCallDetails callDetails)
  {
    boolean enqueued = true;

    try
    {
      jmsTemplate
          .convertAndSend("jmsQueue", callDetails, new MessagePostProcessor()
          {

            @Override
            public Message postProcessMessage(Message message) throws JMSException
            {
              message.setLongProperty("EventType",
                                      LbuConstants.EVENT_TYPE_VOICE_CALL);
              message.setStringProperty("UserName", jmsConfig.userName);
              return message;
            }
          });
    }
    catch (JmxException e)
    {
      logger.error("Could not enqueue message '{}' because of: {}",
                   callDetails,
                   e.toString());
      logger.debug("Stack trace: ", e);
      enqueued = false;
    }

    return enqueued;
  }
}
