package ru.akrecev.testTask.mapper;

import lombok.experimental.UtilityClass;
import ru.akrecev.testTask.dto.TaskDto;
import ru.akrecev.testTask.dto.TaskShortDto;
import ru.akrecev.testTask.model.Task;

@UtilityClass
public class TaskMapper {
    public static TaskDto toDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .author(UserMapper.toDto(task.getAuthor()))
                .assignee(UserMapper.toDto(task.getAssignee()))
                .comments(task.getComments().stream().map(CommentMapper::toDto).toList())
                .build();
    }

    public static TaskShortDto toShortDto(Task task) {
        return new TaskShortDto(task.getId(), task.getTitle(), task.getDescription());
    }
}
