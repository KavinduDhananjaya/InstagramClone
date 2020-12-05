package com.ijse.instagram_clone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    private String id;
    private String imgUrl;
    private String text;

    public Post() {
    }

    public Post(String id, String imgUrl, String text) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

