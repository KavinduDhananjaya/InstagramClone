package com.ijse.instagram_clone.controller;


import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")

public class PostController {


    @Autowired
    private PostServiceImpl postService;


    @PostMapping("/add")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }


}
