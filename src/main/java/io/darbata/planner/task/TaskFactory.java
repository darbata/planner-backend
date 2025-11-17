package io.darbata.planner.task;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@Component
public class TaskFactory {

    public TaskFactory() {}

    public TaskModel create(String description, LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new InvalidParameterException("Start must be before end");
        }

        if (description.isEmpty()) {
            throw new InvalidParameterException("Description is empty");
        }

        return new TaskModel("default", description, start, end, LocalDateTime.now(), LocalDateTime.now());
    }
}