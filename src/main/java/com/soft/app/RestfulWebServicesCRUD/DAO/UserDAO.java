package com.soft.app.RestfulWebServicesCRUD.DAO;

import com.soft.app.RestfulWebServicesCRUD.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();  //will fetch all the users from database and return the result as a list
    public void saveUser(User user); //save user
    public void updateUser(User user); //update user
    public void removeUser(int userId); //remove user hard delete by user id
    public User getUserById(int userId); //get single user by user id
}
