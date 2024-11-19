package ru.akrecev.testTask.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.akrecev.testTask.model.Priority;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends ListCrudRepository<Task, Long> {
    List<Task> findByAuthorId(Long authorId);

    List<Task> findByAssigneeId(Long assigneeId);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByPriority(Priority priority);
}
