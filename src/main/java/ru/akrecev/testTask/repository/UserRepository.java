package ru.akrecev.testTask.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.akrecev.testTask.model.User;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

    List<User> findByIdIn(List<Long> idList);
}
