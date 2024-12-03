package ru.akrecev.testTask.service;

import java.util.List;
import ru.akrecev.testTask.dto.UserDto;
import ru.akrecev.testTask.model.User;

public interface UserService {
    UserDto saveUser(User user);

    User findByEmail(String email);

    User findById(Long id);

    List<User> findByIdIn(List<Long> idList);
}
