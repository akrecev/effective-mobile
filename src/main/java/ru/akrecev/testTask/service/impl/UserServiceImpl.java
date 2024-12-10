package ru.akrecev.testTask.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akrecev.testTask.dto.UserDto;
import ru.akrecev.testTask.exception.DataNotFoundException;
import ru.akrecev.testTask.mapper.UserMapper;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.repository.UserRepository;
import ru.akrecev.testTask.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto saveUser(User user) {
        return userMapper.map(userRepository.save(user));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException("User with email=" + email));
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User id=" + id));
    }

    @Override
    public List<User> getByIdIn(List<Long> idList) {
        return userRepository.findByIdIn(idList);
    }
}
