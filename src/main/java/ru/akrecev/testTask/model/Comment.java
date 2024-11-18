package ru.akrecev.testTask.model;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("comments")
@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
public class Comment {
    @Id
    @Column("id")
    private final Long id;

    @Nonnull
    private final String content;

    @Nonnull
    private final Long taskId;

    @Nonnull
    private final Long authorId;

    @Transient
    private Task task;

    @Transient
    private User user;

    @PersistenceCreator
    public Comment(Long id, String content, Long taskId, Long authorId) {
        this.id = id;
        this.content = content;
        this.taskId = taskId;
        this.authorId = authorId;
    }

    public Comment(String content, Long taskId, Long authorId) {
        this(null, content, taskId, authorId);
    }
}
