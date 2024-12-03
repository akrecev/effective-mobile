package ru.akrecev.testTask.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.akrecev.testTask.dto.CommentDto;
import ru.akrecev.testTask.model.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto map(Comment comment);

    @InheritInverseConfiguration
    Comment map(CommentDto commentDto);
}
