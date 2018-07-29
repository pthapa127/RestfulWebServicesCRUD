package com.soft.app.RestfulWebServicesCRUD.serviceImpl;

import com.soft.app.RestfulWebServicesCRUD.DAO.UserDAO;
import com.soft.app.RestfulWebServicesCRUD.model.User;
import com.soft.app.RestfulWebServicesCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);

    }

    @Transactional
    @Override
    public void removeUser(int userId) {
        userDAO.removeUser(userId);

    }

    @Transactional
    @Override
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);

    }
}
