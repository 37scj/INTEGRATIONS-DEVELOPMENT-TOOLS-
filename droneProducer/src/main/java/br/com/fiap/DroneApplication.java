package br.com.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("br.com.fiap")
@SpringBootApplication
public class DroneApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroneApplication.class, args);
    }

}
