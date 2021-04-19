package ro.proiect.licenta.rau.lbufileprocessor;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ro.proiect.licenta.rau.lbufileprocessor.service.fs.FileService;

@SpringBootApplication
public class LbuFileProcessorApplication
{

  static final Logger logger = LoggerFactory
      .getLogger(LbuFileProcessorApplication.class);

  public static ConfigurableApplicationContext context;

  private static boolean isRunning;

  private static LbuConfig   config;
  private static FileService fileService;

  public static void main(String[] args)
  {
    context = SpringApplication.run(LbuFileProcessorApplication.class, args);

    config = LbuAppContext.getConfig();
    fileService = LbuAppContext.getFileService();

    // Some initial logging
    logStartupInfo(config);

    if (!validateConfiguration())
    {
      logger.error("Invalid Configuration. Application cannot start!");
    }

    // Test - Remove this part
    // DbService dbService = LbuAppContext.getDbService();
    // FileStatistics fileStats = new FileStatistics("myfile.cdr");
    //
    // fileStats.setFileName(fileStats.getFileName());
    // fileStats.setDateProcessingStarted(ZonedDateTime.now().minus(5,
    // ChronoUnit.SECONDS));
    // fileStats.setDateProcessingEnd(ZonedDateTime.now());
    // fileStats.setHeaderRecordExists(false);
    // fileStats.setTrailerRecordExists(false);
    // fileStats.setNumRecsTotal(78);
    // fileStats.setNumRecsSuccess(71);
    // fileStats.getErrors().setNumDecodingFailed(2);
    // fileStats.getErrors().setNumNotSupported(5);
    // boolean saved = dbService.saveFileStatistics(fileStats);
    // logger.warn("SAVE DB ENTRY RESULT: {}", saved);

    // start an infinite loop
    isRunning = true;
    while (isRunning)
    {

      // get next file to process
      Path currentFile = fileService.getNextFile();

      // if file was found, process it. If nothing is found, sleep a bit.
      if (currentFile != null)
      {
        FileProcessor fileProcessor = new VoiceCallFileProcessor(currentFile);
        fileProcessor.doProcess();
      }
      else
      {
        logger.debug("NO FILE TO PROCESS ...");

        try
        {
          Thread.sleep(config.getSleepTimeNoFileFound() * 1000L);
        }
        catch (InterruptedException ie)
        {
          logger.error("{}", ie.toString());
          logger.debug("Stack trace: ", ie);
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
   * @return FALSE if configuration is not valid and the application cannot
   *         start
   */
  private static boolean validateConfiguration()
  {
    if (!fileService.directoryExists(config.getInputDir()))
    {
      logger.warn("Invalid input directory: '{}'", config.getInputDir());
      return false;
    }
    return true;
  }

}
