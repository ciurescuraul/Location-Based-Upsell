package ro.proiect.licenta.rau.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.proiect.licenta.rau.engine.logic.CdrProcessor;
import ro.proiect.licenta.rau.engine.service.db.DbService;
import ro.proiect.licenta.rau.engine.service.jms.JmsService;
import ro.proiect.licenta.rau.engine.service.sms.SmsService;

@Component
public class LbuAppContext
{

  private static LbuEngineConfig lbuEngineConfig;
  private static DbService       dbService;
  private static JmsService      jmsService;
  private static SmsService      smsService;
  private static CdrProcessor    cdrProcessor;

  @Autowired
  public LbuAppContext(LbuEngineConfig lbuEngineConfig,
                       DbService dbService,
                       JmsService jmsService,
                       SmsService smsService,
                       CdrProcessor cdrProcessor)
  {
    LbuAppContext.lbuEngineConfig = lbuEngineConfig;
    LbuAppContext.dbService = dbService;
    LbuAppContext.jmsService = jmsService;
    LbuAppContext.smsService = smsService;
    LbuAppContext.cdrProcessor = cdrProcessor;
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

  public static SmsService getSmsService()
  {
    return smsService;
  }

  public static CdrProcessor getCdrProcessor()
  {
    return cdrProcessor;
  }
}
