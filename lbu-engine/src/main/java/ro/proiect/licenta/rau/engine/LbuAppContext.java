package ro.proiect.licenta.rau.engine;

import org.springframework.stereotype.Component;

import ro.proiect.licenta.rau.engine.logic.CdrProcessor;
import ro.proiect.licenta.rau.engine.service.db.DbService;
import ro.proiect.licenta.rau.engine.service.jms.JmsService;
import ro.proiect.licenta.rau.engine.service.sms.SmsService;

@Component
public class LbuAppContext
{

  private final LbuEngineConfig lbuEngineConfig;
  private final DbService       dbService;
  private final JmsService      jmsService;
  private final SmsService      smsService;
  private final CdrProcessor    cdrProcessor;

  public LbuAppContext(LbuEngineConfig lbuEngineConfig,
                       DbService dbService,
                       JmsService jmsService,
                       SmsService smsService,
                       CdrProcessor cdrProcessor)
  {
    this.lbuEngineConfig = lbuEngineConfig;
    this.dbService = dbService;
    this.jmsService = jmsService;
    this.smsService = smsService;
    this.cdrProcessor = cdrProcessor;
  }

  public LbuEngineConfig getLbuEngineConfig()
  {
    return lbuEngineConfig;
  }

  public DbService getDbService()
  {
    return dbService;
  }

  public JmsService getJmsService()
  {
    return jmsService;
  }

  public SmsService getSmsService()
  {
    return smsService;
  }

  public CdrProcessor getCdrProcessor()
  {
    return cdrProcessor;
  }
}
