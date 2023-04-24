package ru.job4j.cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdMain {
    private static final Logger LOG = LoggerFactory.getLogger(AdMain.class);

    public static void main(String[] args) {
        SpringApplication.run(AdMain.class, args);
        LOG.info("Go to http://localhost:8080/ads");
    }
}