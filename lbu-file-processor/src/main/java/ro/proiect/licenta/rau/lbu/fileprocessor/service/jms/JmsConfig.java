package ro.proiect.licenta.rau.lbu.fileprocessor.service.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig
{

  // TODO: read JMS configuration (url, queue name)

  @Value("${lbu.jms.broker_url}")
  private String brokerUrl;

  @Value("${lbu.jms.queue_name}")
  private String queueName;

  @Value("${lbu.jms.user_name}")
  private String userName;

  @Bean
  public ActiveMQConnectionFactory senderActiveMqConnectionFactory()
  {
    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();

    activeMQConnectionFactory.setBrokerURL(brokerUrl);

    return activeMQConnectionFactory;
  }

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter()
  {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

    converter.setTargetType(MessageType.TEXT);

    converter.setTypeIdPropertyName("_type");

    return converter;
  }

  public String getUserName()
  {
    return userName;
  }
}
