package io.darbata.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class PlannerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlannerBackendApplication.class, args);
    }

}
