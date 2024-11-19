package ru.akrecev.testTask.repository;

import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.akrecev.testTask.model.Comment;

@Repository
public interface CommentRepository extends ListCrudRepository<Comment, Long> {
    List<Comment> findByTaskId(Long taskId);
}
