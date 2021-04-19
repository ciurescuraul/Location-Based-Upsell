package ro.proiect.licenta.rau.engine;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ro.proiect.licenta.rau.engine.logic.CdrProcessor;
import ro.proiect.licenta.rau.engine.service.jms.JmsService;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@SpringBootApplication
public class LbuEngineApplication
{

  static final Logger logger = LoggerFactory
      .getLogger(LbuEngineApplication.class);

  private static LbuEngineConfig config;
  private static JmsService      jmsService;
  private static CdrProcessor    cdrProcessor;

  private static boolean isRunning;

  public static void main(String[] args)
  {
    SpringApplication.run(LbuEngineApplication.class, args);

    config = LbuAppContext.getLbuEngineConfig();
    jmsService = LbuAppContext.getJmsService();
    cdrProcessor = LbuAppContext.getCdrProcessor();

    // some initial logging
    logStartupInfo();

    // start an infinite loop
    isRunning = true;
    while (isRunning)
    {
      // get next cdr from queue; if nothing found wait a bit
      Optional<VoiceCallDetails> cdr = jmsService.dequeueCall();

      if (cdr.isPresent())
      {
        logger.debug("Dequeued: '{}'", cdr.get());
        cdrProcessor.doProcess(cdr.get());
      }
      else
      {
        logger.debug("Queue Empty. Nothing to process ...");
        try
        {
          Thread.sleep(config.getSleepTimeNoFileFound() * 1000L);
        }
        catch (InterruptedException e)
        {
          logger.error("{}", e.toString());
          logger.debug("Stack Trace:", e);
        }
      }
    }

    logger.info("Engine end.");
  }

  /**
   * It logs some useful information when the application starts
   */
  private static void logStartupInfo()
  {
    logger.info("");
    logger.info("");
    logger.info("####################################################");
    logger.info("       Location-Based Upsell:  ENGINE               ");
    logger.info("####################################################");
    logger.info("");
    logger.info(" Configuration used: ");
    logger.info("      App User: '{}'", config.getApplicationUser());
    logger.info("      sleep time when no file was found: {} sec",
                config.getSleepTimeNoFileFound());

  }

}
