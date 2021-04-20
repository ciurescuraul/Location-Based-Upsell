package ro.proiect.licenta.rau.lbu.engine;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;

@SpringBootApplication
public class LbuEngineApplication
{

  static final Logger logger = LoggerFactory
      .getLogger(LbuEngineApplication.class);

  private static boolean isRunning;

  public static void main(String[] args)
  {
    LbuAppContext appContext = SpringApplication
        .run(LbuEngineApplication.class, args).getBean(LbuAppContext.class);

    // some initial logging
    logStartupInfo(appContext);

    // start an infinite loop
    isRunning = true;
    while (isRunning)
    {
      // get next cdr from queue; if nothing found wait a bit
      Optional<VoiceCallDetails> cdr = appContext.getJmsService().dequeueCall();

      if (cdr.isPresent())
      {
        logger.debug("Dequeued: '{}'", cdr.get());
        appContext.getCdrProcessor().doProcess(cdr.get());
      }
      else
      {
        logger.debug("Queue Empty. Nothing to process ...");
        try
        {
          Thread
              .sleep(appContext.getLbuEngineConfig().getSleepTimeIfFileNotFound() *
                     1000L);
        }
        catch (InterruptedException e)
        {
          logger.error(e.getMessage(), e);
        }
      }
    }

    logger.info("Engine end.");
  }

  /**
   * It logs some useful information when the application starts
   * 
   * @param appContext
   */
  private static void logStartupInfo(LbuAppContext appContext)
  {
    logger.info("");
    logger.info("");
    logger.info("####################################################");
    logger.info("       Location-Based Upsell:  ENGINE               ");
    logger.info("####################################################");
    logger.info("");
    logger.info(" Configuration used: ");
    logger.info("      App User: '{}'",
                appContext.getLbuEngineConfig().getApplicationUser());
    logger.info("      sleep time when queue is empty: {} sec",
                appContext.getLbuEngineConfig().getSleepTimeIfFileNotFound());

  }

}
