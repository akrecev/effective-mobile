package ru.akrecev.testTask.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private Long id;
    private String content;
    private TaskShortDto task;
    private UserDto author;
}
