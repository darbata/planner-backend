package io.darbata.planner.tasks;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

// time blocks
@Document("tasks")
public record Task(
        @Id String id,
        String description,
        LocalDate date,
        Boolean isComplete,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}