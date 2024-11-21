package ru.akrecev.testTask.service;

import java.util.List;
import ru.akrecev.testTask.model.Comment;

public interface CommentService {
    Comment saveComment(Comment comment);

    List<Comment> findByTaskId(Long taskId, int from, int size);
}
