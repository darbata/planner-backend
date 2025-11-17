package io.darbata.planner.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel task) {
        try {
            TaskModel created = taskService.createTask(
                    task.description(),
                    task.start(),
                    task.end()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Error saving task: " + e.getMessage(),
                    e
            );
        }
    }

    @GetMapping
    public List<TaskModel> getAllTasks() {
        throw new RuntimeException("Not implemented");
    }

    @PutMapping("/{id}")
    public TaskModel updateTask(@RequestBody TaskModel task, @PathVariable String id) {
        throw new RuntimeException("Not implemented");
    }

    @DeleteMapping("/{id}")
    public TaskModel deleteTask(@PathVariable String id) {
        throw new RuntimeException("Not implemented");
    }
}
