package ro.proiect.licenta.rau.lbu.fileprocessor.service.fs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileServiceImpl implements FileService
{

  Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

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
    // check if directory exists
    // if not exists create directory

    Path currentPath = Paths.get(path);
    boolean exists = Files.exists(currentPath);

    if (!exists)
    {
      try
      {
        Files.createDirectory(currentPath.normalize().toRealPath());
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    try
    {
      currentPath.normalize().toRealPath();
    }
    catch (IOException e)
    {
      try
      {
        throw new NoSuchFileException(path);
      }
      catch (NoSuchFileException noSuchFileException)
      {
        logger.error(noSuchFileException.getMessage(), noSuchFileException);
        return false;
      }
    }

    return true;
  }
}
