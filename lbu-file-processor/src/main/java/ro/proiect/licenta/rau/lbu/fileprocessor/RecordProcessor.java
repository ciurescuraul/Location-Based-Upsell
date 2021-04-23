package ro.proiect.licenta.rau.lbu.fileprocessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RecordProcessor
{

  public static final int HEADER             = 1;
  public static final int BODY               = 2;
  public static final int TRAILER            = 3;
  static final String     VALIDATION_FAILED  = "FAILED";
  static final String     VALIDATION_SUCCESS = "SUCCESS";

  private final Logger logger = LoggerFactory.getLogger(RecordProcessor.class);

  private int recordType;

  private String        fileName;
  private LocalDateTime createdDate;

  @Size(min = 8, max = 36)
  private String uniqueId;

  private LocalDateTime timeStamp;

  @Size(max = 11)
  private String aNumber;

  @Size(max = 15)
  private String bNumber;

  @Size(min = 0, max = 7200)
  private Integer duration;

  @Size(min = 10, max = 20)
  private String cellId;

  private String numRecsTotal;
  private String numCallsToShortNumbers;
  private String totalDuration;

  /**
   * Constructors
   */
  public RecordProcessor()
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
      setFileName(splitArray[0]);
      setCreatedDate(LocalDateTime.parse(splitArray[1], format));
      setRecordType(HEADER);
    }

    if (splitArray.length == 6)
    {
      setUniqueId(splitArray[0]);
      setTimeStamp(LocalDateTime.parse(splitArray[1], format));
      setaNumber(splitArray[2]);
      setbNumber(splitArray[3]);
      setDuration(Integer.valueOf(splitArray[4]));
      setCellId(splitArray[5]);
      setRecordType(BODY);
    }

    if (splitArray.length == 3)
    {
      setNumRecsTotal(splitArray[0]);
      setNumCallsToShortNumbers(splitArray[1]);
      setTotalDuration(splitArray[2]);
      setRecordType(TRAILER);
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
    numRecsTotal = getNumRecsTotal();
    numCallsToShortNumbers = getNumCallsToShortNumbers();
    totalDuration = getTotalDuration();

    if ((numRecsTotal != null) && (numCallsToShortNumbers != null) &&
        (totalDuration != null))
    {
      return true;
    }
    return false;
  }

  private boolean headerIsPresent()
  {
    fileName = getFileName();
    createdDate = getCreatedDate();

    if ((fileName != null) && (createdDate != null))
    {
      return true;
    }
    return false;
  }

  /**
   * Getters and Setters
   * @return
   */
  public int getRecordType()
  {
    return recordType;
  }

  public void setRecordType(int recordType)
  {
    this.recordType = recordType;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  public LocalDateTime getCreatedDate()
  {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate)
  {
    this.createdDate = createdDate;
  }

  public String getUniqueId()
  {
    return uniqueId;
  }

  public void setUniqueId(String uniqueId)
  {
    this.uniqueId = uniqueId;
  }

  public LocalDateTime getTimeStamp()
  {
    return timeStamp;
  }

  public void setTimeStamp(LocalDateTime timeStamp)
  {
    this.timeStamp = timeStamp;
  }

  public String getaNumber()
  {
    return aNumber;
  }

  public void setaNumber(String aNumber)
  {
    this.aNumber = aNumber;
  }

  public String getbNumber()
  {
    return bNumber;
  }

  public void setbNumber(String bNumber)
  {
    this.bNumber = bNumber;
  }

  public Integer getDuration()
  {
    return duration;
  }

  public void setDuration(Integer duration)
  {
    this.duration = duration;
  }

  public String getCellId()
  {
    return cellId;
  }

  public void setCellId(String cellId)
  {
    this.cellId = cellId;
  }

  public String getNumRecsTotal()
  {
    return numRecsTotal;
  }

  public void setNumRecsTotal(String numRecsTotal)
  {
    this.numRecsTotal = numRecsTotal;
  }

  public String getNumCallsToShortNumbers()
  {
    return numCallsToShortNumbers;
  }

  public void setNumCallsToShortNumbers(String numCallsToShortNumbers)
  {
    this.numCallsToShortNumbers = numCallsToShortNumbers;
  }

  public String getTotalDuration()
  {
    return totalDuration;
  }

  public void setTotalDuration(String totalDuration)
  {
    this.totalDuration = totalDuration;
  }

  @Override
  public String toString()
  {
    return "RecordProcessor{" + "recordType=" + recordType + ", fileName='" +
           fileName + '\'' + ", createdDate=" + createdDate + ", uniqueId='" +
           uniqueId + '\'' + ", timeStamp=" + timeStamp + ", aNumber='" +
           aNumber + '\'' + ", bNumber='" + bNumber + '\'' + ", duration=" +
           duration + ", cellId='" + cellId + '\'' + ", numRecsTotal='" +
           numRecsTotal + '\'' + ", numCallsToShortNumbers='" +
           numCallsToShortNumbers + '\'' + ", totalDuration='" + totalDuration +
           '\'' + '}';
  }
}
