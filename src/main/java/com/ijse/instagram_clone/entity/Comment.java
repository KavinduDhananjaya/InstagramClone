package com.ijse.instagram_clone.entity;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;



}
