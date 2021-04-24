package ro.proiect.licenta.rau.lbu.fileprocessor.service.record;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordProcessorImpl implements RecordProcessor {

  public static final int HEADER             = 1;
  public static final int BODY               = 2;
  public static final int TRAILER            = 3;
  public static final String     VALIDATION_FAILED  = "FAILED";
  public static final String     VALIDATION_SUCCESS = "SUCCESS";
  private final Logger    logger             = LoggerFactory
      .getLogger(RecordProcessorImpl.class);

  @Autowired
  private final Record record = new Record();

  public RecordProcessorImpl()
  {
  }

  public String processRecord(String line)
  {

    try
    {
      parseLine(line);

      if (!passValidations())
      {
        return VALIDATION_FAILED;
      }
    }
    catch (Exception e)
    {
      logger.error("Validation failed because of: {}", e.toString());
    }
    return VALIDATION_SUCCESS;
  }

  /**
   * Parsing the file line by line
   * Formatting dates
   * 
   * @param line
   */
  private void parseLine(String line)
  {
    String[] splitArray = line.split("(\\s*[|]\\s*)+");
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss",
                                                           Locale.ENGLISH);

    if (splitArray.length == 2)
    {
      record.setFileName(splitArray[0]);
      record.setCreatedDate(LocalDateTime.parse(splitArray[1], format));
      record.setRecordType(HEADER);
    }

    if (splitArray.length == 6)
    {
      record.setUniqueId(splitArray[0]);
      record.setTimeStamp(LocalDateTime.parse(splitArray[1], format));
      record.setaNumber(splitArray[2]);
      record.setbNumber(splitArray[3]);
      record.setDuration(Integer.valueOf(splitArray[4]));
      record.setCellId(splitArray[5]);
      record.setRecordType(BODY);
    }

    if (splitArray.length == 3)
    {
      record.setNumRecsTotal(splitArray[0]);
      record.setNumCallsToShortNumbers(splitArray[1]);
      record.setTotalDuration(splitArray[2]);
      record.setRecordType(TRAILER);
    }
  }

  /**
   * Validations
   * 
   * @return
   */

  private boolean passValidations()
  {
    if (headerIsPresent())
      return true;

    if (tailIsPresent())
      return true;

    /**
     * TODO
     * if (bodyIsPresent()) return true;
     * if (uniqueIdHasMinMax()) return true;
     * if (dateIsFormatted(LocalDateTime createdDate)) return true;
     * if (aNumberHasExact(int digitsNumber)) return true;
     * if (bNumberHasMax(int digitsNumber)) return true;
     * if(callDurationHasMinMax(int min, int max)) return true;
     * if (cellIdBetweenMinMax(int min, int max)) return true;
     */

    return false;
  }

  private boolean tailIsPresent()
  {
    String numRecsTotal = record.getNumRecsTotal();
    String numCallsToShortNumbers = record.getNumCallsToShortNumbers();
    String totalDuration = record.getTotalDuration();

    if ((numRecsTotal != null) && (numCallsToShortNumbers != null) &&
        (totalDuration != null))
    {
      return true;
    }
    return false;
  }

  private boolean headerIsPresent()
  {
    String fileName = record.getFileName();
    LocalDateTime createdDate = record.getCreatedDate();

    if ((fileName != null) && (createdDate != null))
    {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "RecordProcessor{" +
            "record=" + record +
            '}';
  }
}
