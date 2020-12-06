package krook1024.sharksAPI.user.repository;

import krook1024.sharksAPI.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
}
