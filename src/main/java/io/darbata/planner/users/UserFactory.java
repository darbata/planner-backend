package io.darbata.planner.users;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;

@Component
public class UserFactory {

    public UserFactory() {}

    public User create(String email, String username) {
        return new User(null, email, username, new HashMap<>(), null, null);
    }

}