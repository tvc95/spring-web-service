package com.tvc95.rest.ws.restfulwebservices.beans.dao;

import com.tvc95.rest.ws.restfulwebservices.beans.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(1, 1, "Esse é meu primeiro post", new Date()));
        posts.add(new Post(1, 2, "Bozoniro é meu presidente", new Date()));
        posts.add(new Post(1, 3, "Fora petralhas!", new Date()));
        posts.add(new Post(3, 1, "Te lascar, veado!", new Date()));
        posts.add(new Post(3, 2, "Tu é um fresco véi!", new Date()));
        posts.add(new Post(2, 1, "Eae glr", new Date()));
    }

    /**
     * Retrieve all posts for a User
     * @param userId
     * @return
     */
    public List<Post> findAllPostsByUserId(int userId) {
        List<Post> list = new ArrayList<>();
        for (Post post : posts) {
            if (post.getUserId() == userId) {
                list.add(post);
            }
        }

        return list;
    }

    /**
     * Create a new post for a specific User
     * @param userId
     * @param post
     * @return
     */
    public Post createNewPost(int userId, Post post) {
        List<Post> postsList = findAllPostsByUserId(userId);
        if (post.getPostId() == null) {
            post.setPostId(postsList.size() + 1);
        }

        posts.add(post);
        return post;
    }

    /**
     * Retrieve details of a post
     * @param userId
     * @param postId
     * @return
     */
    public Post findOne(int userId, int postId) {
        for (Post post : posts) {
            if (post.getPostId() == postId && post.getUserId() == userId) {
                return post;
            }
        }
        return null;
    }
}
