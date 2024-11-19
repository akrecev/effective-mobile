package ru.akrecev.testTask.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import ru.akrecev.testTask.model.Priority;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.TaskStatus;

public interface TaskRepository extends ListCrudRepository<Task, Long> {
    Page<Task> findByAuthorId(Long authorId, Pageable pageable);

    Page<Task> findByAssigneeId(Long assigneeId, Pageable pageable);

    Page<Task> findByStatus(TaskStatus status, Pageable pageable);

    Page<Task> findByPriority(Priority priority, Pageable pageable);

    Page<Task> findAll(Pageable pageable);
}
