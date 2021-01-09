package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.entity.Comment;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.service.impl.CommentServiceImpl;
import com.ijse.instagram_clone.service.impl.ReactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    private CommentServiceImpl commentServiceImpl;


    @PostMapping("/addComment/{id}")
    public void addComment(String text, @PathVariable(value = "id") long postId) {
        commentServiceImpl.addComment(text, postId);
    }

    @GetMapping("/getAll/{id}")
    public List<Comment> getAll(@PathVariable(value = "id") long postId) {
        return commentServiceImpl.getCommentList(postId);
    }


}
