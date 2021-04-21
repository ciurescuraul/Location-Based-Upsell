package ro.proiect.licenta.rau.lbu.fileprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.proiect.licenta.rau.lbu.fileprocessor.service.db.DbService;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.fs.FileServiceImpl;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.jms.JmsService;
import ro.proiect.licenta.rau.lbu.fileprocessor.service.jms.SpringJmsService;

@Component
public class LbuAppContext
{

  private final LbuConfig lbuConfig;

  private final FileServiceImpl fileService;
  private final DbService dbService;
  private final JmsService jmsService;

  @Autowired
  public LbuAppContext(LbuConfig lbuConfig,
                       DbService dbService,
                       SpringJmsService springJmsService)
  {
    this.lbuConfig = lbuConfig;
    this.dbService = dbService;
    this.jmsService = springJmsService;

    this.fileService = new FileServiceImpl(lbuConfig.getInputDir());
  }

  public LbuConfig getConfig()
  {
    return lbuConfig;
  }

  public FileServiceImpl getFileService()
  {
    return fileService;
  }

  public DbService getDbService()
  {
    return dbService;
  }

  public JmsService getJmsService()
  {
    return jmsService;
  }
}
