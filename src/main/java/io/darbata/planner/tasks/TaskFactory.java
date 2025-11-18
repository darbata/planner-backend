package io.darbata.planner.tasks;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TaskFactory {

    public TaskFactory() {}

    public Task create(String userId, String description, LocalDate date) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Description is empty");
        }

        return new Task(null, userId, description, date, false, null, null);
    }
}