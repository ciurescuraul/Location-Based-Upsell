package ro.proiect.licenta.rau.lbu.fileprocessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoiceCallFileProcessor extends FileProcessor
{

  static final Logger logger = LoggerFactory
      .getLogger(VoiceCallFileProcessor.class);

  private RecordProcessor recordProcessor = new RecordProcessor();

  public void doProcess(Path file)
  {
    logger.info("Going to process file: '{}'", file.getFileName());

    // TODO: implement this part
    // - open the file DONE
    // - read the file record by record DONE
    // - process each record DONE
    // - use a RecordProcessor similar with FileProcessor DONE
    // - parse, validate  DONE
    // create corresponding VoiceCallDetails object and enqueue it
    // write unit tests for record validation procedures
    // if record validation fails, write the record into an .error file
    // if enqueue fails (ActiveMQ is down), repeat unlimited with a one second
    // sleep (configurable) between retries
    // update file statistics for each record in memory
    // close the file
    // write file statistics into DB
    // if writing in DB fails, log an error and continue
    // rename the file (append .done extension to the file)

    List<String> records = null;

    try (BufferedReader reader = Files
        .newBufferedReader(file, StandardCharsets.UTF_8))
    {

      // Adding lines in memory
      records = reader.lines().collect(Collectors.toList());

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    // Iterate through records
    if (records != null)
    {
      for (String record : records)
      {
        String processRecord = recordProcessor.processRecord(record);

        if (processRecord.equals(RecordProcessor.VALIDATION_SUCCESS))
        {
          logger.info(recordProcessor.toString());
        }

      }
    }

  }

}
