package com.scalar.producrservice25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //for date time in basemodel createdAt, updatedAt.
public class ProducrService25Application {

    public static void main(String[] args) {
        SpringApplication.run(ProducrService25Application.class, args);
    }

}
