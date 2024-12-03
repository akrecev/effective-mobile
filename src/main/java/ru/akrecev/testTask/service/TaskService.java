package ru.akrecev.testTask.service;

import java.util.List;
import ru.akrecev.testTask.dto.TaskDto;
import ru.akrecev.testTask.model.Task;

public interface TaskService {
    TaskDto saveTask(Task task);

    Task findById(Long id);

    List<Task> findAll(int from, int size);

    List<Task> findByAuthorId(Long authorId, int from, int size);

    List<Task> findByAssigneeId(Long assigneeId, int from, int size);

    void deleteTask(Long id);
}
