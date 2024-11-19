package ru.akrecev.testTask.mapper;

import lombok.experimental.UtilityClass;
import ru.akrecev.testTask.dto.UserDto;
import ru.akrecev.testTask.model.User;

@UtilityClass
public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getRole());
    }
}
