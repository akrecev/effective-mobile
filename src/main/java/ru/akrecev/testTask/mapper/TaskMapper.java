package ru.akrecev.testTask.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.akrecev.testTask.dto.TaskDto;
import ru.akrecev.testTask.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto map(Task task);

    @InheritInverseConfiguration
    Task map(TaskDto taskDto);
}
