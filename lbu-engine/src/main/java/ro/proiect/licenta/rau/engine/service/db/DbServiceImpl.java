package ro.proiect.licenta.rau.engine.service.db;

import java.sql.SQLException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.proiect.licenta.rau.lbu.core.InterestArea;

public class DbServiceImpl implements DbService
{

  static final Logger logger = LoggerFactory.getLogger(DbServiceImpl.class);

  @Override
  public Optional<InterestArea> getAreaId(String cellId) throws SQLException
  {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  @Override
  public boolean hasRoamingPackage(String msisdn) throws SQLException
  {
    // TODO Auto-generated method stub
    return false;
  }
}
