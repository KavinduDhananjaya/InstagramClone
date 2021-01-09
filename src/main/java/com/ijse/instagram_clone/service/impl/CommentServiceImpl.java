package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.entity.Comment;
import com.ijse.instagram_clone.repository.CommentRepository;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void addComment(String comment, long postId) {

        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setCommentTime(LocalDateTime.now());
        commentRepository.save(newComment);
    }

    @Override
    public List<Comment> getCommentList(long postId) {

        return commentRepository.findCommentsByPost(postId);
    }
}
