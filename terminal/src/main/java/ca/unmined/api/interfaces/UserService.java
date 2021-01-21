package ca.unmined.api.interfaces;

import ca.unmined.api.entities.User;

import java.util.List;

public interface UserService {
    List<User> get();

    User get(int id);

    void save(User employee);

    void delete(int id);
}
