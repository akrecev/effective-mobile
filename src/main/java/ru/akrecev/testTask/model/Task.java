package ru.akrecev.testTask.model;

import jakarta.annotation.Nonnull;
import java.util.List;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("tasks")
@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
public class Task {
    @Id
    @Column("id")
    private final Long id;

    @Nonnull
    private final String title;

    @Nonnull
    private final String description;

    private final TaskStatus status; // "PENDING", "IN_PROGRESS", "COMPLETED"
    private final Priority priority; // "HIGH", "MEDIUM", "LOW"
    private final Long authorId;
    private final Long assigneeId;

    @MappedCollection(idColumn = "task_id", keyColumn = "id")
    private final List<Comment> comments;

    @Transient
    private User author;

    @Transient
    private User assignee;

    @PersistenceCreator
    public Task(
            Long id,
            String title,
            String description,
            TaskStatus status,
            Priority priority,
            Long authorId,
            Long assigneeId,
            List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.authorId = authorId;
        this.assigneeId = assigneeId;
        this.comments = comments;
    }

    public Task(
            String title,
            String description,
            TaskStatus status,
            Priority priority,
            Long authorId,
            Long assigneeId,
            List<Comment> comments) {
        this(null, title, description, status, priority, authorId, assigneeId, comments);
    }
}
