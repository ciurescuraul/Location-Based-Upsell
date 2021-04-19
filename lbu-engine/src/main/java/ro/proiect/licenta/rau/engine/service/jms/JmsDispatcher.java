package ro.proiect.licenta.rau.engine.service.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.proiect.licenta.rau.engine.LbuEngineConfig;

@Component
public class JmsDispatcher
{

  @Autowired
  private LbuEngineConfig config;

  public JmsService getCustomJmsServiceEntity()
  {
    switch (config.getUserName())
    {
      case "rci":
        return new JmsServiceImpl();
      default:
        throw new IllegalArgumentException();
    }

  }
}
