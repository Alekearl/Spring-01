package spring.core.service;

import java.util.List;
import spring.core.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
