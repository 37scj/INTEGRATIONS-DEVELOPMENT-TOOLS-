package br.com.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DroneBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroneBackendApplication.class, args);
    }

}
