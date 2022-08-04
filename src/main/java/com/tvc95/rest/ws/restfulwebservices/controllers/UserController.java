package com.tvc95.rest.ws.restfulwebservices.controllers;

import com.tvc95.rest.ws.restfulwebservices.beans.User;
import com.tvc95.rest.ws.restfulwebservices.beans.dao.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable String id) {
        return userDaoService.findOne(Integer.parseInt(id));
    }

    @PostMapping("/users")
    public void newUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
    }
}
