package ro.proiect.licenta.rau.lbu.fileprocessor.service.db.repository;

import org.springframework.data.repository.CrudRepository;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.db.entity.LbuFileStatistics;

public interface LbuFileStatisticsRepo extends
                                             CrudRepository<LbuFileStatistics, Integer>
{
}
