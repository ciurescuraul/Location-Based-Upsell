package ro.proiect.licenta.rau.lbu.fileprocessor.service.fs;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileServiceImpl implements FileService
{

  private static final Logger logger = LoggerFactory
      .getLogger(FileServiceImpl.class);

  private final Path   parentDir;

  public FileServiceImpl(String parentDirName)
  {
    this.parentDir = Paths.get(parentDirName);
  }

  @Override
  public Path getNextFile()
  {
    List<Path> pathList;

    try
    {
      pathList = Files.list(parentDir).filter(p -> !Files.isDirectory(p))
          .filter(p -> p.toString().endsWith(".cdr"))
          .filter(Files::isRegularFile)
          .sorted(Comparator.comparingLong(p -> p.toFile().lastModified()))
          .map(Path::toAbsolutePath).collect(Collectors.toList());
    }
    catch (IOException e)
    {
      logger.warn(e.getMessage(), e);
      return null;
    }

    return pathList.stream().findFirst().orElse(null);
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
    boolean exists = Files.exists(Paths.get(path));

    if (!exists)
    {
      logger.warn("Creating directory '{}' ...", Paths.get(path));
      try
      {

        Path directory = Files.createDirectories(Paths.get(path));

        logger.warn("Directory '{}' was created successfully", directory);
        exists = true;
      }
      catch (FileAlreadyExistsException fileAlreadyExistsException)
      {
        logger.warn("Directory already exists !");
      }
      catch (IOException e)
      {
        logger.error(e.getMessage(), e);
      }
    }

    return exists;
  }
}
