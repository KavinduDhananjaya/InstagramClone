package com.ijse.instagram_clone.entity;


import javax.persistence.*;

@Entity
public class React {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int reactType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public React() {
    }

    public React(int reactType, Post post, User user) {
        this.reactType = reactType;
        this.post = post;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getReactType() {
        return reactType;
    }

    public void setReactType(int reactType) {
        this.reactType = reactType;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "React{" +
                "id=" + id +
                ", reactType=" + reactType +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
