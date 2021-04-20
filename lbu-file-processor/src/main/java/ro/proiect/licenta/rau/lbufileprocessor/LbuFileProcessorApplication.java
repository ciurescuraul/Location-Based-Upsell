package ro.proiect.licenta.rau.lbufileprocessor;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ro.proiect.licenta.rau.lbufileprocessor.service.fs.FileService;

@SpringBootApplication
public class LbuFileProcessorApplication
{

  static final Logger logger = LoggerFactory
      .getLogger(LbuFileProcessorApplication.class);

  private static boolean isRunning;

  public static void main(String[] args)
  {
    LbuAppContext appContext = SpringApplication
        .run(LbuFileProcessorApplication.class, args)
        .getBean(LbuAppContext.class);

    LbuConfig config = appContext.getConfig();
    FileService fileService = appContext.getFileService();

    // some initial logging
    logStartupInfo(config);

    if (!validateConfiguration(fileService, config))
    {
      logger.error("Invalid Configuration. Application cannot start!");
    }

    // start an infinite loop
    isRunning = true;
    while (isRunning)
    {

      // get next file to process
      Path currentFile = fileService.getNextFile();

      // if file was found, process it. If nothing is found, sleep a bit.
      if (currentFile != null)
      {
        new VoiceCallFileProcessor().doProcess(currentFile);
      }
      else
      {
        logger.debug("NO FILE TO PROCESS ...");

        try
        {
          Thread.sleep(config.getSleepTimeNoFileFound() * 1000L);
        }
        catch (InterruptedException e)
        {
          logger.error(e.getMessage(), e);
        }
      }
    }
    logger.info("File processor end.");
  }

  /**
   * It logs some useful information about the application configuration on
   * startup
   * 
   * @param config
   */
  private static void logStartupInfo(LbuConfig config)
  {
    logger.info("");
    logger.info("");
    logger.info("####################################################");
    logger.info("       Location-Based Upsell: FILE PROCESSOR        ");
    logger.info("####################################################");
    logger.info("");
    logger.info(" Configuration used: ");
    logger.info("      input dir: '{}'", config.getInputDir());
    logger.info("      sleep time when no file was found: {} sec",
                config.getSleepTimeNoFileFound());
  }

  /**
   * Validates the configuration
   * 
   * @param fileService
   * @param config
   * @return FALSE if configuration is not valid and the application cannot
   *         start
   */
  private static boolean validateConfiguration(FileService fileService,
                                               LbuConfig config)
  {
    if (!fileService.directoryExists(config.getInputDir()))
    {
      logger.warn("Invalid input directory: '{}'", config.getInputDir());
      return false;
    }
    return true;
  }

}
