package ro.proiect.licenta.rau.lbufileprocessor.service.fs;

import java.nio.file.Path;

public interface FileService {

    public Path getNextFile();

    public boolean directoryExists(String path);

}
