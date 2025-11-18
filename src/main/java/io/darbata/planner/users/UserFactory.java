package io.darbata.planner.users;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserFactory {

    public UserFactory() {}

    public User create(String email, String name) {
        return new User(null, email, name, null, null);
    }

    public User create(String id, String email, String name, LocalDateTime createdAt) {
        return new User(id, email, name, createdAt, null);
    }
}