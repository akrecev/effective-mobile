package ru.akrecev.testTask.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.repository.TaskRepository;
import ru.akrecev.testTask.service.TaskService;
import ru.akrecev.testTask.utility.MyPageRequest;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll(int from, int size) {
        return taskRepository.findAll(new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }

    @Override
    public List<Task> findByAuthorId(Long authorId, int from, int size) {
        return taskRepository.findByAuthorId(authorId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }

    @Override
    public List<Task> findByAssigneeId(Long assigneeId, int from, int size) {
        return taskRepository.findByAssigneeId(assigneeId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
