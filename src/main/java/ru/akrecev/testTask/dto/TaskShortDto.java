package ru.akrecev.testTask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskShortDto {
    private Long id;
    private String title;
    private String description;
}
