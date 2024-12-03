package ru.akrecev.testTask.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.akrecev.testTask.dto.CommentDto;
import ru.akrecev.testTask.mapper.CommentMapper;
import ru.akrecev.testTask.model.Comment;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.repository.CommentRepository;
import ru.akrecev.testTask.service.CommentService;
import ru.akrecev.testTask.service.TaskService;
import ru.akrecev.testTask.service.UserService;
import ru.akrecev.testTask.utility.MyPageRequest;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final TaskService taskService;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto saveComment(Comment comment) {
        return commentMapper.map(commentRepository.save(comment));
    }

    @Override
    public List<CommentDto> findByTaskId(Long taskId, int from, int size) {
        List<Comment> comments =
                commentRepository.findByTaskId(taskId, new MyPageRequest(from, size, Sort.unsorted())).stream()
                        .toList();
        List<Long> authorIdList = comments.stream().map(Comment::getAuthorId).toList();
        Map<Long, User> userMap =
                userService.findByIdIn(authorIdList).stream().collect(Collectors.toMap(User::getId, a -> a));

        Task task = taskService.findById(taskId);

        return comments.stream()
                .map(comment -> comment.toBuilder()
                        .task(task)
                        .author(userMap.get(comment.getAuthorId()))
                        .build())
                .map(commentMapper::map)
                .toList();
    }
}
