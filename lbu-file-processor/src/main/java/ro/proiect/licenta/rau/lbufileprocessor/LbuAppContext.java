package ro.proiect.licenta.rau.lbufileprocessor;

import org.springframework.stereotype.Component;
import ro.proiect.licenta.rau.lbufileprocessor.service.db.DbService;
import ro.proiect.licenta.rau.lbufileprocessor.service.fs.FileService;
import ro.proiect.licenta.rau.lbufileprocessor.service.fs.FileServiceImpl;
import ro.proiect.licenta.rau.lbufileprocessor.service.jms.JmsService;

@Component
public class LbuAppContext {

    private static LbuConfig lbuConfig;

    private static FileService fileService;
    private static DbService dbService;
    private static JmsService jmsService;

    public LbuAppContext(LbuConfig lbuConfig, DbService dbService, JmsService jmsService) {
        LbuAppContext.lbuConfig = lbuConfig;
        LbuAppContext.dbService = dbService;
        LbuAppContext.jmsService = jmsService;

        LbuAppContext.fileService = new FileServiceImpl(lbuConfig.getInputDir());
    }

    public static LbuConfig getConfig() {
        return lbuConfig;
    }

    public static FileService getFileService() {
        return fileService;
    }

    public static DbService getDbService() {
        return dbService;
    }

    public static JmsService getJmsService() {
        return jmsService;
    }
}
