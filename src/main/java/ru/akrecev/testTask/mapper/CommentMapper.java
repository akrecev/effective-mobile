package ru.akrecev.testTask.mapper;

import lombok.experimental.UtilityClass;
import ru.akrecev.testTask.dto.CommentDto;
import ru.akrecev.testTask.model.Comment;

@UtilityClass
public class CommentMapper {
    public static CommentDto toDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .task(TaskMapper.toShortDto(comment.getTask()))
                .author(UserMapper.toDto(comment.getAuthor()))
                .build();
    }
}
