package ca.unmined.api.implementations;

import ca.unmined.api.interfaces.UserDAO;
import ca.unmined.api.interfaces.UserService;
import ca.unmined.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> get() {
        return userDAO.get();
    }

    @Transactional
    @Override
    public User get(int id) {
        return userDAO.get(id);
    }

    @Transactional
    @Override
    public void save(User User) {
        userDAO.save(User);

    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
