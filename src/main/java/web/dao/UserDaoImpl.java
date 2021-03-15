package web.dao;



import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete User where id = "+ id).executeUpdate();
    }

    @Override
    public User showUserByUsername(String email) {
        return entityManager
                .createQuery("select u from User u where u.email =?1", User.class)
                .setParameter(1, email)
                .getSingleResult();
    }

//перенес логику в RoleDao
/*
    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select role from Role role where role.role=:name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Role> getListRole() {
        return entityManager.createQuery("from Role").getResultList();
    }

*/

}
