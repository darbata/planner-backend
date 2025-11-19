package io.darbata.planner.users;

import java.time.LocalDate;

public record GetUserTasksByDateDTO(String userId, LocalDate date) {
}