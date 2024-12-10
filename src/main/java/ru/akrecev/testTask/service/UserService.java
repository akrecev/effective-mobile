package ru.akrecev.testTask.service;

import java.util.List;
import ru.akrecev.testTask.dto.UserDto;
import ru.akrecev.testTask.model.User;

public interface UserService {
    UserDto saveUser(User user);

    User getByEmail(String email);

    User getById(Long id);

    List<User> getByIdIn(List<Long> idList);
}
