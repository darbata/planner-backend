package io.darbata.planner.task;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskFactory taskFactory;
    private final TaskRepository taskRepository;

    public TaskService(TaskFactory taskFactory, TaskRepository taskRepository) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
    }

    public Task createTask(String description, LocalDateTime start, LocalDateTime end) {
        Task task = taskFactory.create(description, start, end);
        task = taskRepository.save(task);
        return task;
    }

}