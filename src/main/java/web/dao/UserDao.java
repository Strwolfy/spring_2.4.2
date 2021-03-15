package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    void editUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    User showUserByUsername(String email);

}

