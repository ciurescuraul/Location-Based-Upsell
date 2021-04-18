package ro.proiect.licenta.rau.lbufileprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LbuConfig
{

  @Autowired
  @Value("${lbu.fp.input_dir}")
  String inputDir;

  @Autowired
  @Value("${lbu.fp.sleep_time_no_file_found}")
  int sleepTimeNoFileFound;

  public String getInputDir() {
    return inputDir;
  }

  public int getSleepTimeNoFileFound() {
    return sleepTimeNoFileFound;
  }
}
