package com.technoload.techflow.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Bootstrap class for the TechFlow Backend application.
 *
 * <p>Initializes Spring Boot auto-configuration and JPA auditing infrastructure.</p>
 */
@EnableJpaAuditing
@SpringBootApplication
public class TechFlowBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechFlowBackendApplication.class, args);
    }

}
