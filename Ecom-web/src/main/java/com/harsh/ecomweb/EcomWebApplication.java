package com.harsh.ecomweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EcomWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomWebApplication.class, args);
    }

}
