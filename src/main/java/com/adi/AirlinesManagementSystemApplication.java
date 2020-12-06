package com.adi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.adi.persistence.repo")
@EntityScan("com.adi.persistence.model")
@SpringBootApplication
public class AirlinesManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlinesManagementSystemApplication.class, args);
    }

}
