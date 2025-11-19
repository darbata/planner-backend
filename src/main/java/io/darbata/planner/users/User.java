package io.darbata.planner.users;

import io.darbata.planner.tasks.Task;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Document(collection="users")
public record User(
    @Id String id,
    String email,
    String username,
    HashMap<LocalDate, List<String>> tasks, // store lists of taskIds, accessible by days keys
    @CreatedDate LocalDateTime createdAt,
    @LastModifiedDate LocalDateTime updatedAt
) {}