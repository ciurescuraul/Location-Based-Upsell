package ro.proiect.licenta.rau.lbu.fileprocessor.service.teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchDirectory
{

  public static void main(String[] args)
  {

    List<Path> pathList = new ArrayList<>();

    try
    {
      pathList = Files.list(Paths.get("data"))
          .filter(p -> !Files.isDirectory(p))
          .filter(p -> p.toString().endsWith(".cdr"))
          .filter(Files::isRegularFile)
          .sorted(Comparator.comparingLong(p -> p.toFile().lastModified()))
          .map(Path::toAbsolutePath).collect(Collectors.toList());

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    pathList.forEach(System.out::println);

  }
}
