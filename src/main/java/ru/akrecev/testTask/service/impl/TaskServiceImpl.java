package ru.akrecev.testTask.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.akrecev.testTask.dto.TaskDto;
import ru.akrecev.testTask.exception.DataNotFoundException;
import ru.akrecev.testTask.mapper.TaskMapper;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.repository.TaskRepository;
import ru.akrecev.testTask.service.TaskService;
import ru.akrecev.testTask.service.UserService;
import ru.akrecev.testTask.utility.MyPageRequest;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto saveTask(Task task) {
        return taskMapper.map(taskRepository.save(task));
    }

    @Override
    public Task getById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Task id=" + id));
        User author = userService.getById(task.getAuthorId());
        User assignee = userService.getById(task.getAssigneeId());

        return task.toBuilder().author(author).assignee(assignee).build();
    }

    @Override
    public List<Task> getAll(int from, int size) {
        return taskRepository.findAll(new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }

    @Override
    public List<Task> getByAuthorId(Long authorId, int from, int size) {
        return taskRepository.findByAuthorId(authorId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }

    @Override
    public List<Task> getByAssigneeId(Long assigneeId, int from, int size) {
        return taskRepository.findByAssigneeId(assigneeId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
