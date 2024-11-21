package ru.akrecev.testTask.service;

import ru.akrecev.testTask.model.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);

    List<Comment> findByTaskId(Long taskId, int from, int size);
}
