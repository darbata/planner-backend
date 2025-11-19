package io.darbata.planner.tasks;

import io.darbata.planner.users.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskFactory taskFactory;
    private final TaskRepository taskRepository;

    public TaskService(TaskFactory taskFactory, TaskRepository taskRepository) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
    }

    public Task createTask(CreateTaskRequestDTO dto) {

        if (dto.userId() == null || dto.date() == null || dto.description() == null) {
            return null;
        }

        Task newTask = taskFactory.create(dto.description());

        return taskRepository.insert(newTask);
    }

    public List<Task> getAllTasksById(List<String> taskIds) {
        return taskRepository.findAllById(taskIds);
    }
}