package io.darbata.planner.users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public User createUser(User user) {
        User newUser = this.userFactory.create(user.email(), user.username());
        return this.userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User updateUser(String id, User user) {
        User updatedUser = this.userFactory.create(id, user.email(), user.username(), user.createdAt());
        return this.userRepository.save(updatedUser);
    }

    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }
}