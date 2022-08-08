package com.tvc95.rest.ws.restfulwebservices.beans;

import java.util.Date;

public class Post {

    private Integer userId;
    private Integer postId;
    private String content;
    private Date postDate;

    protected Post() {}

    public Post(Integer userId, Integer postId, String content, Date postDate) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.postDate = postDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user=" + userId +
                ", id=" + postId +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
