package ro.proiect.licenta.rau.lbufileprocessor.service.fs;

import java.nio.file.Path;

public interface FileService
{

  Path getNextFile();

  boolean directoryExists(String path);

}
