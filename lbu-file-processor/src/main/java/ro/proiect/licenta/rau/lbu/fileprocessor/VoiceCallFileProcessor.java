package ro.proiect.licenta.rau.lbu.fileprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.proiect.licenta.rau.lbu.core.cdr.FileStatistics;
import ro.proiect.licenta.rau.lbu.core.cdr.FileStatsError;
import ro.proiect.licenta.rau.lbu.core.cdr.VoiceCallDetails;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.jms.JmsConfig;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.jms.JmsServiceImpl;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.jms.VoiceCallDetailsJms;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.record.Record;

public class VoiceCallFileProcessor extends FileProcessor
{

  static final Logger logger = LoggerFactory
      .getLogger(VoiceCallFileProcessor.class);

  public void doProcess(Path file)
  {
    logger.info("Going to process file: '{}'", file.getFileName());

    // TODO: implement this part
    // - open the file
    // - read the file record by record
    // - process each record
    // - use a RecordProcessor similar with FileProcessor
    // - parse, validate
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

    // create a list of all records
    List<Record> recordList = new ArrayList<>();
    List<VoiceCallDetails> voiceCallDetailsList = new ArrayList<>();
    List<FileStatistics> fileStatisticsList = new ArrayList<>();

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss",
                                                           Locale.ENGLISH);

    ZonedDateTime processingStartedTime = null;
    ZonedDateTime processingEndedTime = null;

    // Initialize FileStatistics for Database
    FileStatistics fileStatistics = new FileStatistics(file.toString());
    FileStatsError fileStatsError = new FileStatsError();

    boolean isValid = true;

    try
    {
      List<String> lines = Files.readAllLines(file);
      // opening the file
      processingStartedTime = ZonedDateTime.now();

      // read file record by record
      for (String line : lines)
      {
        String[] splitArray = line.split("(\\s*[|]\\s*)+");

        if (splitArray.length == 2)
        {
          Record record = new Record();

          // if validation pass add record in memory
          if (isValid)
          {
            record.setRecordType(Record.HEADER);
            record.setFileName(splitArray[0]);
            record.setCreatedDate(LocalDateTime.parse(splitArray[1], format));

            recordList.add(record);

            fileStatistics.incrementSuccess();
          }
          else
          {
            isValid = false;
            fileStatistics.incrementError();

            // increment file stats
            fileStatsError.incrementNumDecodingFailed();
            fileStatsError.incrementNumNotSupported();
          }
        }

        if (splitArray.length == 6)
        {
          Record record = new Record();

          // if validation pass add record in memory
          if (isValid)
          {
            record.setRecordType(Record.BODY);
            record.setUniqueId(splitArray[0]);
            record.setTimeStamp(LocalDateTime.parse(splitArray[1], format));
            record.setaNumber(splitArray[2]);
            record.setbNumber(splitArray[3]);
            record.setDuration(Integer.valueOf(splitArray[4]));
            record.setCellId(splitArray[5]);

            recordList.add(record);

            // increment statistics success
            fileStatistics.incrementSuccess();

            JmsConfig jmsConfig = new JmsConfig();

            // create VoiceCallDetails Object for ActiveMQ
            VoiceCallDetailsJms voiceCallDetails = new VoiceCallDetailsJms(record
                .getaNumber());
            voiceCallDetails.setLocation(record.getCellId());
            voiceCallDetails.setCallStartTime(record.getTimeStamp());
            voiceCallDetails.setDuration(record.getDuration());

            // add voice call details in memory list
            voiceCallDetailsList.add(voiceCallDetails);

            /**
             * send VoiceCall to ActiveMQ Queue
             */
            JmsServiceImpl jmsService = new JmsServiceImpl(jmsConfig);
            jmsService.enqueueCall(voiceCallDetails);
          }
          else
          {
            isValid = false;
            fileStatistics.incrementError();

            // increment file stats
            fileStatsError.incrementNumDecodingFailed();
            fileStatsError.incrementNumNotSupported();
          }
        }

        if (splitArray.length == 3)
        {
          Record record = new Record();

          // if validation pass add record in memory
          if (isValid)
          {
            record.setRecordType(Record.TRAILER);
            record.setNumRecsTotal(splitArray[0]);
            record.setNumCallsToShortNumbers(splitArray[1]);
            record.setTotalDuration(splitArray[2]);

            recordList.add(record);

            // increment statistics success
            fileStatistics.incrementSuccess();
          }
          else
          {
            isValid = false;
            fileStatistics.incrementError();

            // increment file stats
            fileStatsError.incrementNumDecodingFailed();
            fileStatsError.incrementNumNotSupported();
          }

        }
      }
      processingEndedTime = ZonedDateTime.now();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    /**
     * // List records
     * for (Record r : recordList)
     * {
     * if (r != null)
     * {
     * fileStatistics.setDateProcessingStarted(processingStartedTime);
     * fileStatistics.setDateProcessingEnd(processingEndedTime);
     * if (r.getRecordType().equals(Record.HEADER))
     * {
     * fileStatistics.setHeaderRecordExists(true);
     * }
     * if (r.getRecordType().equals(Record.TRAILER))
     * {
     * fileStatistics.setTrailerRecordExists(true);
     * fileStatistics.setNumRecsTotal(Integer.parseInt(r.getNumRecsTotal()));
     * fileStatistics.setNumRecsSuccess(fileStatistics.getNumRecsSuccess());
     * fileStatistics.setNumRecsError(fileStatistics.getNumRecsError());
     * }
     * // add file statistics in memory list
     * fileStatisticsList.add(fileStatistics);
     * logger.info(r.toString());
     * }
     * }
     * // list Voice call details
     * for (VoiceCallDetails v : voiceCallDetailsList)
     * {
     * logger.info(v.toString());
     * }
     * // list file statistics
     * for (FileStatistics s : fileStatisticsList)
     * {
     * logger.info(s.toString());
     * }
     */

  }

}
