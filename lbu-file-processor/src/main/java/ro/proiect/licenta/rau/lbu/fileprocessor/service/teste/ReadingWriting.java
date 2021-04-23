package ro.proiect.licenta.rau.lbu.fileprocessor.service.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ReadingWriting
{

  public static void main(String[] args)
  {
    // Start reading
    long start = System.currentTimeMillis();

    Path relativePath = Paths.get("data", "call_20210420_21.cdr");
    Path writerPath = Paths
        .get("data", "callDate_" + System.currentTimeMillis() + ".cdr");

    Map<String, LocalDateTime> header = new HashMap<>();
    Map<String, String> record = new HashMap<>();
    Map<String, String> tail = new HashMap<>();

    try
    {
      BufferedReader bufferedReader = Files
          .newBufferedReader(relativePath, StandardCharsets.US_ASCII);

      String line = null;

      while ((line = bufferedReader.readLine()) != null)
      {
        String[] splitArray = line.split("(\\s*[|]\\s*)+");

        for (int i = 0; i < splitArray.length; i++)
        {
          // System.out.println(i + " " + Thread.currentThread().getName() + " "
          // +
          // splitArray[i]);

          if (splitArray.length == 2)
          {
            String fileName = splitArray[0];

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH);

            String createdDate = splitArray[1];

            LocalDateTime parsedCreatedDate = LocalDateTime.parse(createdDate,format);


            header.put(fileName, parsedCreatedDate);
          }

          // else if (splitArray.length == 6)
          // {
          // String uniqueId = splitArray[0];
          // String timeStamp = splitArray[1];
          // String aNumber = splitArray[2];
          // String bNumber = splitArray[3];
          // String duration = splitArray[4];
          // String cellId = splitArray[5];
          //
          // record.put(uniqueId, "uniqueId");
          // record.put(timeStamp, "timeStamp");
          // record.put(aNumber, "aNumber");
          // record.put(bNumber, "bNumber");
          // record.put(duration, "duration");
          // record.put(cellId, "cellId");
          //
          // }
          // else if (splitArray.length == 3)
          // {
          // String numRecsTotal = splitArray[0];
          // String numCallsToShortNumbers = splitArray[1];
          // String totalDuration = splitArray[2];
          //
          // tail.put("numRecsTotal", numRecsTotal);
          // tail.put("numCallsToShortNumbers", numCallsToShortNumbers);
          // tail.put("totalDuration", totalDuration);

        }
      }
    }
    catch (IOException ioException)
    {
      ioException.printStackTrace();
    }

    System.out.println();
    System.out.println("Header");
    System.out.println();

    for (Map.Entry<String, LocalDateTime> entry : header.entrySet())
    {
      System.out.println(entry.getKey() + "/" + entry.getValue());
    }

    System.out.println();
    System.out.println("Record ");
    System.out.println();

    // for (Map.Entry<String, String> entry : record.entrySet())
    // {
    // System.out.println(entry.getKey() + " - " + entry.getValue());
    // }
    //

    System.out.println();
    System.out.println("Tail");
    System.out.println();

    // for (Map.Entry<String, String> entry : tail.entrySet())
    // {
    // System.out.println(entry.getKey() + "/" + entry.getValue());
    //

    long end = System.currentTimeMillis();
    long total = end - start;

    System.out.println("Total time: " + total);
  }

}
