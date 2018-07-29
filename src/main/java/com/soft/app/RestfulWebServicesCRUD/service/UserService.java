package com.soft.app.RestfulWebServicesCRUD.service;

import com.soft.app.RestfulWebServicesCRUD.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public void updateUser(User user);
    public void removeUser(int userId);
    public User getUserById(int userId);
}
