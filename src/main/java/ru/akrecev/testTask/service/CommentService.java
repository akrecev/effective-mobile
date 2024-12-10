package ru.akrecev.testTask.service;

import java.util.List;
import ru.akrecev.testTask.dto.CommentDto;
import ru.akrecev.testTask.model.Comment;

public interface CommentService {
    CommentDto saveComment(Comment comment);

    List<CommentDto> getByTaskId(Long taskId, int from, int size);
}
