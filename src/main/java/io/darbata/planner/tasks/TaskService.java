package io.darbata.planner.tasks;

import io.darbata.planner.users.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class TaskService {

    private final TaskFactory taskFactory;
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskFactory taskFactory, TaskRepository taskRepository, UserService userService) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public Task createTask(CreateTaskRequestDTO dto) {

        if (dto.userId() == null || dto.date() == null || dto.description() == null) {
            return null;
        }

        Task newTask = taskFactory.create(dto.description());

        Task savedTask = taskRepository.insert(newTask);

        userService.giveUserTask(dto.userId(), dto.date(), savedTask.id());

        return savedTask;
    }
}