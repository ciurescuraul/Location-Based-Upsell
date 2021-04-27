package ro.proiect.licenta.rau.lbu.core.cdr;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ro.proiect.licenta.rau.lbu.core.utils.ZonedDateTimeCustomDeserializer;
import ro.proiect.licenta.rau.lbu.core.utils.ZonedDateTimeCustomSerializer;

public class FileStatistics extends Cdr
{

  private String fileName;

  @JsonSerialize(using = ZonedDateTimeCustomSerializer.class)
  @JsonDeserialize(using = ZonedDateTimeCustomDeserializer.class)
  @JsonProperty("start")
  private ZonedDateTime dateProcessingStarted;

  @JsonSerialize(using = ZonedDateTimeCustomSerializer.class)
  @JsonDeserialize(using = ZonedDateTimeCustomDeserializer.class)
  @JsonProperty("end")
  private ZonedDateTime dateProcessingEnd;

  @JsonProperty("header")
  private boolean headerRecordExists;

  @JsonProperty("trailer")
  private boolean trailerRecordExists;

  @JsonProperty("total")
  private int numRecsTotal;

  @JsonProperty("success")
  private int numRecsSuccess;

  @JsonProperty("failed")
  private int numRecsError;

  private FileStatsError errors = new FileStatsError();

  public FileStatistics(String fileName)
  {
    super();
    this.fileName = fileName;
    this.dateProcessingStarted = ZonedDateTime.now();
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  public ZonedDateTime getDateProcessingStarted()
  {
    return dateProcessingStarted;
  }

  public void setDateProcessingStarted(ZonedDateTime dateProcessingStarted)
  {
    this.dateProcessingStarted = dateProcessingStarted;
  }

  public ZonedDateTime getDateProcessingEnd()
  {
    return dateProcessingEnd;
  }

  public void setDateProcessingEnd(ZonedDateTime dateProcessingEnd)
  {
    this.dateProcessingEnd = dateProcessingEnd;
  }

  public int getNumRecsTotal()
  {
    return numRecsTotal;
  }

  public void setNumRecsTotal(int numRecsTotal)
  {
    this.numRecsTotal = numRecsTotal;
  }

  public int getNumRecsSuccess()
  {
    return numRecsSuccess;
  }

  public void setNumRecsSuccess(int numRecsSuccess)
  {
    this.numRecsSuccess = numRecsSuccess;
  }

  public int getNumRecsError()
  {
    return numRecsError;
  }

  public void setNumRecsError(int numRecsError)
  {
    this.numRecsError = numRecsError;
  }

  public FileStatsError getErrors()
  {
    return errors;
  }

  public void setErrors(FileStatsError errors)
  {
    this.errors = errors;
  }

  public void incrementNumRecsTotal()
  {
    this.numRecsTotal++;
  }

  public void incrementNumRecsSuccess()
  {
    this.numRecsSuccess++;
  }

  public void incrementNumRecsError()
  {
    this.numRecsError++;
  }

  public void incrementNumDecodingFailed()
  {
    this.errors.incrementNumDecodingFailed();
  }

  public void incrementNumNotSupported()
  {
    this.errors.incrementNumNotSupported();
  }

  public boolean hasHeaderRecord()
  {
    return headerRecordExists;
  }

  public boolean hasTrailerRecord()
  {
    return trailerRecordExists;
  }

  public void setHeaderRecordExists(boolean headerRecordExists)
  {
    this.headerRecordExists = headerRecordExists;
  }

  public void setTrailerRecordExists(boolean trailerRecordExists)
  {
    this.trailerRecordExists = trailerRecordExists;
  }

  public void incrementSuccess()
  {
    incrementNumRecsTotal();
    incrementNumRecsSuccess();
  }

  public void incrementError()
  {
    incrementNumRecsTotal();
    incrementNumRecsError();
  }

  @Override
  public String toString()
  {
    return "FileStatistics{" + "fileName='" + fileName + '\'' +
           ", dateProcessingStarted=" + dateProcessingStarted +
           ", dateProcessingEnd=" + dateProcessingEnd +
           ", headerRecordExists=" + headerRecordExists +
           ", trailerRecordExists=" + trailerRecordExists + ", numRecsTotal=" +
           numRecsTotal + ", numRecsSuccess=" + numRecsSuccess +
           ", numRecsError=" + numRecsError + ", errors=" + errors + '}';
  }
}
