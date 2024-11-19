package ru.akrecev.testTask.service;

import java.util.List;
import java.util.Optional;
import ru.akrecev.testTask.model.Task;

public interface TaskService {
    Task saveTask(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll(int from, int size);

    List<Task> findByAuthorId(Long authorId, int from, int size);

    List<Task> findByAssigneeId(Long assigneeId, int from, int size);

    void deleteTask(Long id);
}
