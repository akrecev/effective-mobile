package ru.akrecev.testTask.service;

import java.util.List;
import ru.akrecev.testTask.dto.TaskDto;
import ru.akrecev.testTask.model.Task;

public interface TaskService {
    TaskDto saveTask(Task task);

    Task getById(Long id);

    List<Task> getAll(int from, int size);

    List<Task> getByAuthorId(Long authorId, int from, int size);

    List<Task> getByAssigneeId(Long assigneeId, int from, int size);

    void deleteTask(Long id);
}
