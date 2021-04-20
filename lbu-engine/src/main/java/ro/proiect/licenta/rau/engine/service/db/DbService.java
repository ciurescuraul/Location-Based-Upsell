package ro.proiect.licenta.rau.engine.service.db;

import java.sql.SQLException;
import java.util.Optional;

import ro.proiect.licenta.rau.lbu.core.InterestArea;

public interface DbService
{

  Optional<InterestArea> getAreaId(String cellId) throws SQLException;

  boolean hasRoamingPackage(String msisdn) throws SQLException;
}
