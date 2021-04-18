package ro.proiect.licenta.rau.lbufileprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class VoiceCallFileProcessor  extends FileProcessor{

    static final Logger log = LoggerFactory.getLogger(VoiceCallFileProcessor.class);

    public VoiceCallFileProcessor(Path file) {
        super(file);
    }

    @Override
    public void doProcess() {

        log.info("Going to process file: '{}'", file.getFileName());

        // TODO: implement this part
        // - open the file
        // - read the file record by record
        // - process each record
        //      - use a RecordProcessor similar with FileProcessor
        //      - parse, validate, create corresponding VoiceCallDetails object and enqueue it
        //      - write unit tests for record validation procedures
        //      - if record validation fails, write the record into an .error file
        //      - if enqueue fails (ActiveMQ is down), repeat unlimited with a one second sleep (configurable) between retries
        // - update file statistics for each record in memory
        // - close the file
        // - write file statistics into DB
        // - if writing in DB fails, log an error and continue
        // - rename the file (append .done extension to the file)

    }
}
