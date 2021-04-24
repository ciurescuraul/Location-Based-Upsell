package ro.proiect.licenta.rau.lbu.fileprocessor.service.record;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Record
{

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

  public Record()
  {
  }

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
  public String toString() {
    return "Record{" +
            "recordType=" + recordType +
            ", fileName='" + fileName + '\'' +
            ", createdDate=" + createdDate +
            ", uniqueId='" + uniqueId + '\'' +
            ", timeStamp=" + timeStamp +
            ", aNumber='" + aNumber + '\'' +
            ", bNumber='" + bNumber + '\'' +
            ", duration=" + duration +
            ", cellId='" + cellId + '\'' +
            ", numRecsTotal='" + numRecsTotal + '\'' +
            ", numCallsToShortNumbers='" + numCallsToShortNumbers + '\'' +
            ", totalDuration='" + totalDuration + '\'' +
            '}';
  }
}
