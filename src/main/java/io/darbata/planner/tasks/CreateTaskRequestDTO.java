package io.darbata.planner.tasks;

import java.time.LocalDate;

public record CreateTaskRequestDTO(String userId, String description, LocalDate date) {
}
