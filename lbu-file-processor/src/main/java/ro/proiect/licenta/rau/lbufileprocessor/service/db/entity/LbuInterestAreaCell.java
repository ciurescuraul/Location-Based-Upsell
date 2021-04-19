package ro.proiect.licenta.rau.lbufileprocessor.service.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LbuInterestAreaCell
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private int    areaId;
  private String cellId;

  public LbuInterestAreaCell()
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

  public int getAreaId()
  {
    return areaId;
  }

  public void setAreaId(int areaId)
  {
    this.areaId = areaId;
  }

  public String getCellId()
  {
    return cellId;
  }

  public void setCellId(String cellId)
  {
    this.cellId = cellId;
  }
}
