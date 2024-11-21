package ru.akrecev.testTask.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.akrecev.testTask.exception.DataNotFoundException;
import ru.akrecev.testTask.model.Comment;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.repository.CommentRepository;
import ru.akrecev.testTask.repository.TaskRepository;
import ru.akrecev.testTask.repository.UserRepository;
import ru.akrecev.testTask.service.CommentService;
import ru.akrecev.testTask.utility.MyPageRequest;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByTaskId(Long taskId, int from, int size) {
        List<Comment> comments =
                commentRepository.findByTaskId(taskId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                        .toList();
        List<Long> authorIdList = comments.stream().map(Comment::getAuthorId).toList();
        Map<Long, User> userMap =
                userRepository.findByIdIn(authorIdList).stream().collect(Collectors.toMap(User::getId, a -> a));

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new DataNotFoundException("Task id=" + taskId));

        return comments.stream()
                .map(comment -> comment.toBuilder()
                        .task(task)
                        .author(userMap.get(comment.getAuthorId()))
                        .build())
                .toList();
    }
}
