package ro.proiect.licenta.rau.engine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LbuEngineConfig
{
    @Value("${lbu.user_name}")
    String userName;

    @Value("${lbu.engine.sleep_time_no_file_found}")
    int sleepTimeNoFileFound;

    public String getApplicationUser() {
        return userName;
    }

    public int getSleepTimeNoFileFound() {
        return sleepTimeNoFileFound;
    }
}
