package ru.akrecev.testTask.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.akrecev.testTask.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends ListCrudRepository<Comment, Long> {
    List<Comment> findByTaskId(Long taskId);
}
