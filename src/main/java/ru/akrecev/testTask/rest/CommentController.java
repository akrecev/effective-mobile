package ru.akrecev.testTask.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.akrecev.testTask.dto.CommentDto;
import ru.akrecev.testTask.model.Comment;
import ru.akrecev.testTask.model.Task;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.service.CommentService;
import ru.akrecev.testTask.service.TaskService;

@Tag(name = "Comment Management", description = "APIs for managing comments")
@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final TaskService taskService;

    @PostMapping("/{taskId}")
    public CommentDto addComment(
            @PathVariable Long taskId, @RequestBody Comment comment, @AuthenticationPrincipal User currentUser) {
        Task task = taskService.findById(taskId);
        comment = comment.toBuilder().task(task).author(currentUser).build();
        return commentService.saveComment(comment);
    }

    @Operation(
            summary = "Get comments by task id",
            description = "Fetch a list of task's comments",
            responses = {
                @ApiResponse(responseCode = "200", description = "Successfully fetched comments"),
                @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                @ApiResponse(responseCode = "404", description = "Data not found", content = @Content)
            })
    @GetMapping("/{taskId}")
    public List<CommentDto> getCommentsByTask(
            @PathVariable Long taskId,
            @RequestParam(value = "from", defaultValue = "0") Integer from,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        return commentService.findByTaskId(taskId, from, size);
    }
}
