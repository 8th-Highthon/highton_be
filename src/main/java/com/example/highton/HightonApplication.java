package com.example.highton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HightonApplication {
    public static void main(String[] args)   {
        SpringApplication.run(HightonApplication.class, args);
    }

}
