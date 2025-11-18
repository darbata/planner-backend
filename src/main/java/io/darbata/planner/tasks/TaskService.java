package io.darbata.planner.tasks;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskService {

    private final TaskFactory taskFactory;
    private final TaskRepository taskRepository;

    public TaskService(TaskFactory taskFactory, TaskRepository taskRepository) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        Task newTask = taskFactory.create(task.description(), task.date(), task.isComplete());
        return taskRepository.save(newTask);
    }

}