package com.ijse.instagram_clone.controller;


import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")

public class PostController {


    @Autowired
    private PostServiceImpl postService;


    @PostMapping("/add")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @GetMapping("/all")
    public List<Post> getAllPost(Pageable page) {
        return postService.getAllPost(page);
    }

    @PostMapping("/comment")
    public Post commentPost() {
        return null;
    }

    @GetMapping("/find-id/{id}")
    public Post getSinglePost(@PathVariable(value = "id") long id) {
        return postService.getSinglePost(id);
    }

}
