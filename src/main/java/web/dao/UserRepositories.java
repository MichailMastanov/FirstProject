package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface UserRepositories  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
