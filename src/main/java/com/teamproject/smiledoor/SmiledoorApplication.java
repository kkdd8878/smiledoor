package com.teamproject.smiledoor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class SmiledoorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmiledoorApplication.class, args);
    }

}
