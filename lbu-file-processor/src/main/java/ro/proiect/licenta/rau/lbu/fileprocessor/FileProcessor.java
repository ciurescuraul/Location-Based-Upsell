package ro.proiect.licenta.rau.lbu.fileprocessor;

import java.nio.file.Path;

public abstract class FileProcessor
{

  /**
   * This is the main processing method for a file.
   * All exceptions must be handled internally.
   */

  public abstract void doProcess(Path file);
}
