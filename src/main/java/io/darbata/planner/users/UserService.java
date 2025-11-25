package io.darbata.planner.users;

import io.darbata.planner.tasks.Task;
import io.darbata.planner.tasks.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public User createUser(CreateUserDTO dto) {
        User newUser = this.userFactory.create(dto.email(), dto.username());
        return this.userRepository.insert(newUser);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    public void giveUserTask(String userId, LocalDate date, String taskId) {
        this.userRepository.findById(userId).ifPresent(user -> {
            List<String> dayTasks = user.tasks().getOrDefault(date, new ArrayList<>());
            dayTasks.add(taskId);
            user.tasks().put(date, dayTasks);
            this.userRepository.save(user);
        });
    }

    public List<String> getUserTasksIdsByDate(String userId, LocalDate date) {
        Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty()) {
            return new ArrayList<>();
        }

        return user.get().tasks().getOrDefault(date, new ArrayList<>());

    }

    public Map<LocalDate, List<String>> getTaskIdsByWeek(String userId, LocalDate monday) {
        Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty()) {
            return new HashMap<>();
        }

        HashMap<LocalDate, List<String>> map = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            LocalDate date = monday.plusDays(i);
            List<String> taskIds = user.get().tasks().getOrDefault(date, new ArrayList<>());
            map.put(date, taskIds);
        }

        return map;
    }
}