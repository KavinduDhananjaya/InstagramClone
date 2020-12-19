package com.ijse.instagram_clone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    private long id;
    private String imgUrl;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> comments;


    public Post() {

    }

    public Post(long id, String imgUrl, String text, User user, List<Comment> comments) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.text = text;
        this.user = user;
        this.comments = comments;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}

