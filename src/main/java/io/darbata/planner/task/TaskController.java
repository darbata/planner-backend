package io.darbata.planner.task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        try {
            return taskRepository.save(task);
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
