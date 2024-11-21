package ru.akrecev.testTask.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.akrecev.testTask.model.Comment;
import ru.akrecev.testTask.repository.CommentRepository;
import ru.akrecev.testTask.service.CommentService;
import ru.akrecev.testTask.utility.MyPageRequest;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByTaskId(Long taskId, int from, int size) {
        return commentRepository.findByTaskId(taskId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                .toList();
    }
}
