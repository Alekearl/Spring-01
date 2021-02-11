package spring.core.dao;

import java.util.List;
import spring.core.model.User;

public interface UserDao {
    void add(User user);

    Optional<User> get(Long id);

    List<User> getAll();
}
