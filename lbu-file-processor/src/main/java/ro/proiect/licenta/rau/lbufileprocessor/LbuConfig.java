package ro.proiect.licenta.rau.lbufileprocessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LbuConfig
{

  @Value("${lbu.fp.input_dir}")
  private String inputDir;

  @Value("${lbu.fp.sleep_time_no_file_found}")
  private int sleepTimeNoFileFound;

  public String getInputDir()
  {
    return inputDir;
  }

  public int getSleepTimeNoFileFound()
  {
    return sleepTimeNoFileFound;
  }
}
