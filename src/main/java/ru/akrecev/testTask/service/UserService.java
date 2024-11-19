package ru.akrecev.testTask.service;

import java.util.Optional;
import ru.akrecev.testTask.model.User;

public interface UserService {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
