package ro.proiect.licenta.rau.lbufileprocessor.service.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LbuSubscriber
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String msisdn;
  private int    has_roaming;

  public LbuSubscriber()
  {
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getMsisdn()
  {
    return msisdn;
  }

  public void setMsisdn(String msisdn)
  {
    this.msisdn = msisdn;
  }

  public int getHas_roaming()
  {
    return has_roaming;
  }

  public void setHas_roaming(int has_roaming)
  {
    this.has_roaming = has_roaming;
  }
}
