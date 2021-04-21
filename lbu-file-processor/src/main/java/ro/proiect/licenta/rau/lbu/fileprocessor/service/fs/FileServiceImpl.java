package ro.proiect.licenta.rau.lbu.fileprocessor.service.fs;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
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
    this.parentDir = Paths.get(parentDirName);
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
   * If directory doesn't exist is creating a new one
   * 
   * @param path
   * @return
   */

  @Override
  public boolean directoryExists(String path)
  {

    Path currentPath = Paths.get(path);
    boolean exists = Files.exists(currentPath);

    if (!exists)
    {
      logger.error("Creating directory '{}' ...", currentPath);
      try
      {

        Path directory = Files.createDirectories(currentPath);

        logger.info("Directory '{}' was created successfully", directory);
        exists = true;
      }
      catch (FileAlreadyExistsException fileAlreadyExistsException)
      {
        logger.info("Directory already exists !");
      }
      catch (IOException e)
      {
        logger.error(e.getMessage(), e);
      }
    }

    return exists;
  }
}
