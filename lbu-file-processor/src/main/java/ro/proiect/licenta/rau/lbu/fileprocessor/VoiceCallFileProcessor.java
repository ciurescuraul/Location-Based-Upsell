package ro.proiect.licenta.rau.lbu.fileprocessor;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoiceCallFileProcessor extends FileProcessor
{

  static final Logger logger = LoggerFactory
      .getLogger(VoiceCallFileProcessor.class);

  public void doProcess(Path file)
  {

    logger.info("Going to process file: '{}'", file.getFileName());

    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    // TODO: implement this part
    // - open the file
    // - read the file record by record
    // - process each record
    // - use a RecordProcessor similar with FileProcessor
    // - parse, validate, create corresponding VoiceCallDetails object and
    // enqueue it
    // - write unit tests for record validation procedures
    // - if record validation fails, write the record into an .error file
    // - if enqueue fails (ActiveMQ is down), repeat unlimited with a one second
    // sleep (configurable) between retries
    // - update file statistics for each record in memory
    // - close the file
    // - write file statistics into DB
    // - if writing in DB fails, log an error and continue
    // - rename the file (append .done extension to the file)

  }

}
