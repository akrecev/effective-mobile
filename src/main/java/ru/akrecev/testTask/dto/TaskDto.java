package ru.akrecev.testTask.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import ru.akrecev.testTask.model.Priority;
import ru.akrecev.testTask.model.TaskStatus;

@Data
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private UserDto author;
    private UserDto assignee;
    private List<CommentDto> comments;
}
