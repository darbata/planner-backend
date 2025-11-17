package io.darbata.planner.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// time blocks
@Document("tasks")
public record Task(
        @Id String id,
        String description,
        LocalDateTime start,
        LocalDateTime end,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}