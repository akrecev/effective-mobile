package ru.akrecev.testTask.model;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Getter
@ToString
@Builder(toBuilder = true)
public class User {
    @Id
    @Column("id")
    private final Long id;

    @Nonnull
    private final String email;

    @Nonnull
    private final String password;

    @Nonnull
    private final String name;

    @Nonnull
    private final Role role; // ADMIN, USER

    @PersistenceCreator
    public User(Long id, String email, String password, String name, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(String email, String password, String name, Role role) {
        this(null, email, password, name, role);
    }
}
