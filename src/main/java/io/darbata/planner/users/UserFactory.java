package io.darbata.planner.users;

import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public UserFactory() {}

    public User create(String email, String name) {
        return new User("default", email, name);
    }

    public User create(String id, String email, String name) {
        return new User(id, email, name);
    }
}