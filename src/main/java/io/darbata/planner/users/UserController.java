package io.darbata.planner.users;

import io.darbata.planner.tasks.Task;
import io.darbata.planner.tasks.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // CREATE
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO dto) {
        try {
            User newUser = userService.createUser(dto);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // READ
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> allUsers = userService.getAllUsers();
            return ResponseEntity.ok(allUsers);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getUserTasksByDate(@RequestParam String userId, @RequestParam LocalDate date) {
        try {
            List<String> taskIds = userService.getUserTasksIdsByDate(userId, date);
            List<Task> tasks = taskService.getAllTasksById(taskIds);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
/*
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
*/

    // DELETE
    @DeleteMapping("/id")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}