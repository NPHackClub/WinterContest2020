package ca.unmined.api.implementations;

import ca.unmined.api.interfaces.UserDAO;
import ca.unmined.api.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> get() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<User> query = currSession.createQuery("from User", User.class);
        List<User> list = query.getResultList();

        return list;
    }

    @Override
    public User get(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        User User = currSession.get(User.class, id);
        return User;
    }

    @Override
    public void save(User User) {

        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(User);
    }
    @Override
    public void delete(int id) {
        Session currSession = entityManager.unwrap(Session.class);
        User User = currSession.get(User.class, id);
        currSession.delete(User);
    }

}
