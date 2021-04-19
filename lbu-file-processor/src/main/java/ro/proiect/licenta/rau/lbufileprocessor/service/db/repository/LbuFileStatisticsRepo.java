package ro.proiect.licenta.rau.lbufileprocessor.service.db.repository;

import org.springframework.data.repository.CrudRepository;
import ro.proiect.licenta.rau.lbufileprocessor.service.db.entity.LbuFileStatistics;

public interface LbuFileStatisticsRepo extends
                                             CrudRepository<LbuFileStatistics, Integer>
{
}
