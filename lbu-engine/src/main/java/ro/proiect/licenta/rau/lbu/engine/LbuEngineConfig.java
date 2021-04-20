package ro.proiect.licenta.rau.lbu.engine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LbuEngineConfig
{

  @Value("${lbu.engine.user_name}")
  private String userName;

  @Value("${lbu.engine.sleep_time_queue_is_empty}")
  private int sleepTimeIfFileNotFound;

  public String getApplicationUser()
  {
    return userName;
  }

  public int getSleepTimeIfFileNotFound()
  {
    return sleepTimeIfFileNotFound;
  }
}
