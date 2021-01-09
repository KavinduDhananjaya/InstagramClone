package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.entity.Comment;
import com.ijse.instagram_clone.entity.React;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    void addComment(String comment, long postId);

    List<Comment> getCommentList(long postId);

}
