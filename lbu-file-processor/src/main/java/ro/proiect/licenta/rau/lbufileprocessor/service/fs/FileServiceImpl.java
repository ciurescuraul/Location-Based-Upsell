package ro.proiect.licenta.rau.lbufileprocessor.service.fs;

import java.nio.file.Path;

public class FileServiceImpl implements FileService
{

  private String parentDirName;

  private Path parentDir;

  public FileServiceImpl(String parentDirName)
  {
    this.parentDirName = parentDirName;
    // we don't set the Path object at this point, because the path is not
    // validated yet
  }

  @Override
  public Path getNextFile()
  {

    // TODO:
    // - make sure to set the Path object, if it is not set already
    // - pick the oldest file from directory having .cdr extension
    // - if no file found return null
    // - if problems appear log errors/warnings and return null

    return null;
  }

  /**
   * It checks whether a specified path represents an existing directory
   * 
   * @param path
   * @return
   */

  @Override
  public boolean directoryExists(String path)
  {

    // TODO: implement this

    return true;
  }
}
