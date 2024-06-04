package vitaliy.grab.doners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DonerCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonerCloudApplication.class, args);
        System.out.println("http://localhost:8080");
    }

}
