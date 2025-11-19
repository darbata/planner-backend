package io.darbata.planner.users;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}