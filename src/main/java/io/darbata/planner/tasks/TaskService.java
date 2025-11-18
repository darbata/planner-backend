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

    public Task createTask(CreateTaskRequestDTO dto) {
        Task newTask = taskFactory.create(dto.userId(), dto.description(), dto.date());
        return taskRepository.save(newTask);
    }

}