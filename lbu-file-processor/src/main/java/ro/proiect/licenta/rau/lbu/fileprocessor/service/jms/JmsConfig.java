package ro.proiect.licenta.rau.lbu.fileprocessor.service.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@ComponentScan("ro.proiect.licenta.rau.lbu")
public class JmsConfig
{

  // TODO: read JMS configuration (url, queue, name)

  private final String queueName = "jmsQueue";
  private final String userName  = "jms-username";
  private final int    priority  = 1;
  private String brokerUrl = "tcp://localhost:61616";

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
  {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public ActiveMQConnectionFactory senderActiveMqConnectionFactory()
  {
    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();

    factory.setBrokerURL(brokerUrl);

    return factory;
  }

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter()
  {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

    converter.setTargetType(MessageType.TEXT);

    converter.setTypeIdPropertyName("_type");

    return converter;
  }

  public String getQueueName()
  {
    return queueName;
  }

  public String getUserName()
  {
    return userName;
  }

  public int getPriority()
  {
    return priority;
  }
}
