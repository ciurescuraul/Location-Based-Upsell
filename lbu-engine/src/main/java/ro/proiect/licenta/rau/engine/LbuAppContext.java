package ro.proiect.licenta.rau.engine;

import org.springframework.stereotype.Component;

import ro.proiect.licenta.rau.engine.service.db.DbService;
import ro.proiect.licenta.rau.engine.service.jms.JmsService;

@Component
public class LbuAppContext
{

  private static LbuEngineConfig lbuEngineConfig;
  private static DbService       dbService;
  private static JmsService      jmsService;

  public LbuAppContext(LbuEngineConfig lbuEngineConfig,
                       DbService dbService,
                       JmsService jmsService)
  {
    LbuAppContext.lbuEngineConfig = lbuEngineConfig;
    LbuAppContext.dbService = dbService;
    LbuAppContext.jmsService = jmsService;
  }

  public static LbuEngineConfig getLbuEngineConfig()
  {
    return lbuEngineConfig;
  }

  public static DbService getDbService()
  {
    return dbService;
  }

  public static JmsService getJmsService()
  {
    return jmsService;
  }
}
