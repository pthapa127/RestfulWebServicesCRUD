package com.soft.app.RestfulWebServicesCRUD.controller;

import com.soft.app.RestfulWebServicesCRUD.model.User;
import com.soft.app.RestfulWebServicesCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value="/users",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/users",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @RequestMapping(value="/users/{userId}",method =RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user,@PathVariable("userId")int userId){
        User u=userService.getUserById(userId);
        u.setFirstname(user.getFirstname());
        u.setMiddlename(user.getMiddlename());
        u.setLastname(user.getLastname());
        u.setAddress(user.getAddress());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userService.updateUser(u);
    }

    @RequestMapping(value="/users/{userId}",method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
    public void removeUser(@PathVariable("userId")int userId){
        System.out.println(userId);
        userService.removeUser(userId);
    }

    @RequestMapping(value="/users/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("userId")int userId){
        return userService.getUserById(userId);
    }
}
