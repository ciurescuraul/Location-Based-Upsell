package ro.proiect.licenta.rau.lbu.fileprocessor.service.nio2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class NIO
{

  // System.out.println("Absolute path: " + path.toAbsolutePath());
  // System.out.println("Relative path: " + path);
  // System.out.println("FileSystem: " + path.getFileSystem());
  // System.out.println("parent: " + path.getParent());
  // System.out.println("root: " + path.getRoot());
  // System.out.println("Name count: " + path.getNameCount());
  // System.out.println("URI: " + path.toUri());
  // System.out.println("Real path: " + path.toRealPath());

  static Path absolutePath = Paths.get("D:",
                                       "RAU_License_Project_2021",
                                       "lbu-project",
                                       "data",
                                       "call_20210420_21.cdr");
  static Path relativePath = Paths.get("data", "call_20210420_21.cdr");
  static Path relativePath2 = Paths.get("dummy", "call_20210420_21.cdr");
  static Path fileName     = relativePath.getFileName();
  static Path parentPath   = relativePath.getParent();

  public static void main(String[] args)
  {

    System.out.println("#############################################");
//    System.out.println("Absolute path: " + absolutePath);
//    System.out.println("Relative path: " + relativePath);
//    System.out.println("Absolute Root name: " + absolutePath.getRoot());
//    System.out.println("Relative Root name: " + relativePath.getRoot());
//    System.out.println("Relativize path: " + relativePath.relativize(relativePath2));
//    System.out.println("Normalize path: " + relativePath.resolve(relativePath.relativize(relativePath2)));

    try {
      Path realPath = relativePath.toRealPath();
      System.out.println(realPath);
    } catch (IOException e) {
      try {
        throw new NoSuchFieldException();
      } catch (NoSuchFieldException noSuchFieldException) {
        System.out.println("This file does not exist !!! Try again ...");
      }
    }
//    System.out.println("Parent name: " + parentPath);
//    System.out.println("File name: " + fileName);
    System.out.println("#############################################");
//
//    for (int i = 0; i < relativePath.getNameCount(); i++)
//    {
//      System.out
//          .println(" Element name " + i + " is: " + relativePath.getName(i));
//    }
//    System.out.println(absolutePath.subpath(1, 3));
//    System.out.println();
//    System.out.println("=========== Path Information ==============");
//    printPathInformation(absolutePath);
//    printPathInformation(relativePath);
  }

  public static void printPathInformation(Path path)
  {

    Path currentParent = path;

    if (path.isAbsolute())
    {
      System.out.println("-----");
      System.out.println("Path is absolute");
      System.out.println("File name is " + path.getFileName());
      System.out.println("Root is " + path.getRoot());
    }
    else
    {
      System.out.println("-----");
      System.out.println("Path is relative");
      System.out.println("File name is " + path.getFileName());
      System.out.println("Root is " + path.getRoot());
    }
    while ((currentParent = currentParent.getParent()) != null)
    {
      System.out.println("  Current parent is: " + currentParent);
    }

  }

}
