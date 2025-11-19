package io.darbata.planner.tasks;

import io.darbata.planner.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskRequestDTO dto) {
        try {
            Task newTask = taskService.createTask(dto);
            userService.giveUserTask(dto.userId(), dto.date(), newTask.id());
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
