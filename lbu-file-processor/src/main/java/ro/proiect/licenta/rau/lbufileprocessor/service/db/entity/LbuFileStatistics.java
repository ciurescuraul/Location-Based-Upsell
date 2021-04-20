package ro.proiect.licenta.rau.lbufileprocessor.service.db.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ro.proiect.licenta.rau.lbu.core.cdr.FileStatistics;

@Entity
public class LbuFileStatistics
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String origin;

  private String        fileName;
  private ZonedDateTime startDate;
  private ZonedDateTime endDate;
  private Boolean       header;
  private Boolean       trailer;
  private Integer       total;
  private Integer       success;
  private Integer       failed;
  private Integer       notDecoded;
  private Integer       notValidated;

  public LbuFileStatistics()
  {
    // required by ORM frameworks
  }

  public LbuFileStatistics(String origin, String fileName)
  {
    this.origin = origin;
    this.fileName = fileName;
    this.startDate = ZonedDateTime.now();
    this.endDate = ZonedDateTime.now();
    this.header = false;
    this.trailer = false;
    this.total = 0;
    this.success = 0;
    this.failed = 0;
    this.notDecoded = 0;
    this.notValidated = 0;
  }

  public LbuFileStatistics(FileStatistics cdr)
  {
    this.fileName = cdr.getFileName();
    this.startDate = cdr.getDateProcessingStarted();
    this.endDate = cdr.getDateProcessingEnd();
    this.header = cdr.hasHeaderRecord();
    this.trailer = cdr.hasTrailerRecord();
    this.total = cdr.getNumRecsTotal();
    this.success = cdr.getNumRecsSuccess();
    this.failed = this.total - this.success;
    this.notDecoded = cdr.getErrors().getNumDecodingFailed();
    this.notValidated = cdr.getErrors().getNumNotSupported();
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  public ZonedDateTime getStartDate()
  {
    return startDate;
  }

  public void setStartDate(ZonedDateTime startDate)
  {
    this.startDate = startDate;
  }

  public ZonedDateTime getEndDate()
  {
    return endDate;
  }

  public void setEndDate(ZonedDateTime endDate)
  {
    this.endDate = endDate;
  }

  public Boolean getHeader()
  {
    return header;
  }

  public void setHeader(Boolean header)
  {
    this.header = header;
  }

  public Boolean getTrailer()
  {
    return trailer;
  }

  public void setTrailer(Boolean trailer)
  {
    this.trailer = trailer;
  }

  public Integer getTotal()
  {
    return total;
  }

  public void setTotal(Integer total)
  {
    this.total = total;
  }

  public Integer getSuccess()
  {
    return success;
  }

  public void setSuccess(Integer success)
  {
    this.success = success;
  }

  public Integer getFailed()
  {
    return failed;
  }

  public void setFailed(Integer failed)
  {
    this.failed = failed;
  }

  public Integer getNotDecoded()
  {
    return notDecoded;
  }

  public void setNotDecoded(Integer notDecoded)
  {
    this.notDecoded = notDecoded;
  }

  public Integer getNotValidated()
  {
    return notValidated;
  }

  public void setNotValidated(Integer notValidated)
  {
    this.notValidated = notValidated;
  }
}
