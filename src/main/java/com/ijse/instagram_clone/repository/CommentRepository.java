package com.ijse.instagram_clone.repository;

import com.ijse.instagram_clone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByPost(long postId);
}
