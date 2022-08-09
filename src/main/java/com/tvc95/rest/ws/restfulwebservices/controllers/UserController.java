package com.tvc95.rest.ws.restfulwebservices.controllers;

import com.tvc95.rest.ws.restfulwebservices.beans.Post;
import com.tvc95.rest.ws.restfulwebservices.beans.User;
import com.tvc95.rest.ws.restfulwebservices.beans.dao.PostDaoService;
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

    @Autowired
    private PostDaoService postDaoService;

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

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);

        if (user == null) {
            throw new ResourceNotFoundException("[404] - User not found");
        }
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

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPosts(@PathVariable String id) {
        return postDaoService.findAllPostsByUserId(Integer.parseInt(id));
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> newPost(@PathVariable String id, @RequestBody Post post) {
        post.setUserId(Integer.parseInt(id));

        Post savedPost = postDaoService.createNewPost(post.getUserId(), post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(savedPost.getPostId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post retrievePost(@PathVariable String id, @PathVariable String postId) {
        return postDaoService.findOne(Integer.parseInt(id), Integer.parseInt(postId));
    }
}
