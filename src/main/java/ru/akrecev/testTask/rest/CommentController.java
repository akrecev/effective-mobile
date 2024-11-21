package ru.akrecev.testTask.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.akrecev.testTask.dto.CommentDto;
import ru.akrecev.testTask.exception.DataNotFoundException;
import ru.akrecev.testTask.model.Comment;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.service.CommentService;
import ru.akrecev.testTask.service.TaskService;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final TaskService taskService;

    @PostMapping("/{taskId}")
    public CommentDto addComment(@PathVariable Long taskId, @RequestBody Comment comment, User currentUser) {
        Task task = taskService.findById(taskId).orElseThrow(() -> new DataNotFoundException("Task id=" + taskId));
        comment = comment.toBuilder().task(task).author(currentUser).build();
        return commentService.saveComment(comment);
    }

    @GetMapping("/{taskId}")
    public List<CommentDto> getCommentsByTask(
            @PathVariable Long taskId,
            @RequestParam(value = "from", defaultValue = "0") Integer from,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        return commentService.findByTaskId(taskId, from, size);
    }
}
