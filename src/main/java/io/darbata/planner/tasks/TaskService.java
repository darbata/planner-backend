package io.darbata.planner.tasks;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<LocalDate, List<Task>> getTaskWeekTaskByID(Map<LocalDate, List<String>> weekTasksIds) {

        Map<LocalDate, List<Task>> map = new HashMap<>();

        for (Map.Entry<LocalDate, List<String>> entry : weekTasksIds.entrySet()) {
            LocalDate date = entry.getKey();
            List<String> taskIds = entry.getValue();

            map.put(date, taskRepository.findAllById(taskIds));
        }

        return map;
    }
}