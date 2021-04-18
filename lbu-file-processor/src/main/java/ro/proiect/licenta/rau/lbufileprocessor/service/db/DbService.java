package ro.proiect.licenta.rau.lbufileprocessor.service.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ro.proiect.licenta.rau.lbu.core.cdr.FileStatistics;

@Component
public class DbService
{

  static final Logger logger = LoggerFactory.getLogger(DbService.class);

  /**
   * For more information read this article
   * https://spring.io/guides/gs/accessing-data-mysql/
   */

  @Value("${spring.datasource.username}")
  String userName;

  @Autowired
  private LbuFileStatisticsRepository fileStatisticsRepo;

  public boolean saveFileStatistics(FileStatistics stats)
  {
    boolean saved = true;

    LbuFileStatistics entity = new LbuFileStatistics(stats);

    entity.setOrigin(userName);

    try
    {
      fileStatisticsRepo.save(entity);
    }
    catch (Exception e)
    {
      logger
          .warn("Could not save FileStatistics record in DB for '{}', because of: {}",
                stats.getFileName(),
                e.toString());
      logger.debug("Stack trace: ", e);
      saved = false;
    }

    return saved;
  }

}
