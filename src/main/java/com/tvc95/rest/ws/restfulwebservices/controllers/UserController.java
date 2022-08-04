package com.tvc95.rest.ws.restfulwebservices.controllers;

import com.tvc95.rest.ws.restfulwebservices.beans.User;
import com.tvc95.rest.ws.restfulwebservices.beans.dao.UserDaoService;
import com.tvc95.rest.ws.restfulwebservices.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User foundUser = userDaoService.findOne(Integer.parseInt(id));

        if (foundUser == null) {
            throw new ResourceNotFoundException("[404] - User not found");
        }

        return foundUser;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> newUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

        // returns the URI of the recently created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        // return status CREATED
        return ResponseEntity.created(location).build();
    }
}
