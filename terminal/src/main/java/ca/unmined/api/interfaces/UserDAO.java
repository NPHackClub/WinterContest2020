package ca.unmined.api.interfaces;

import ca.unmined.api.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> get();
    User get(int id);

    void save(User User);
    void delete(int id);
}
