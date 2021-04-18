package ro.proiect.licenta.rau.lbufileprocessor;


import java.nio.file.Path;

public abstract class FileProcessor {

    Path file;

    public FileProcessor(Path file) {
        this.file = file;
    }

    /**
     *  This is the main processing method for a file.
     *  All exceptions must be handled internally.
     */

    public abstract void doProcess();
}
