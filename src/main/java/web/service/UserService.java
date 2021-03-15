package web.service;

import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    void editUser(User user);

    public User showUserByUsername(String email);
//перенес логику в RoleDao
/*
    Role getRoleByName(String name);

    List<Role> getListRole();*/

}

