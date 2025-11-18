package io.darbata.planner.tasks;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TaskFactory {

    public TaskFactory() {}

    public Task create(String description, LocalDate date, Boolean isComplete) {
        if (description.isEmpty()) {
            throw new InvalidParameterException("Description is empty");
        }

        return new Task("default", description, date, isComplete, LocalDateTime.now(), LocalDateTime.now());
    }
}