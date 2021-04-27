package ro.proiect.licenta.rau.lbu.fileprocessor.service.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import ro.proiect.licenta.rau.lbu.core.LbuConstants;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@Service
public class JmsServiceImpl implements JmsService
{

  private final JmsConfig jmsConfig;

  Logger logger = LoggerFactory.getLogger(JmsServiceImpl.class);

  @Autowired
  public JmsServiceImpl(JmsConfig jmsConfig)
  {
    this.jmsConfig = jmsConfig;
  }

  @Override
  public boolean enqueueCall(VoiceCallDetails callDetails)
  {
    boolean enqueued = true;

    // TODO implement this part

    ActiveMQConnectionFactory factory = jmsConfig
        .senderActiveMqConnectionFactory();

    try
    {
      // create a connection with connection factory
      Connection connection = factory.createConnection();

      connection.start();

      // create a session
      Session session = connection.createSession(false,
                                                 Session.AUTO_ACKNOWLEDGE);

      // creating the queue
      Queue queue = session.createQueue("jmsQueue");

      // create a producer
      MessageProducer producer = session.createProducer(queue);

      // convert the message
      MessageConverter messageConverter = jmsConfig
          .jacksonJmsMessageConverter();

      Message message = messageConverter.toMessage(callDetails, session);
      message.setLongProperty("EventType", LbuConstants.EVENT_TYPE_VOICE_CALL);
      message.setStringProperty("LbuUser", jmsConfig.getUserName());
      message.setJMSCorrelationID(jmsConfig.getUserName());
      message.setJMSPriority(jmsConfig.getPriority());

      // sending message to Queue
      producer.send(queue, message);

    }
    catch (JMSException e)
    {
      logger.debug("Couldn't enqueue message '{}' because of '{}'",
                   callDetails,
                   e.toString());
      logger.error(e.getMessage(), e);
      enqueued = false;
    }

    return enqueued;
  }
}
