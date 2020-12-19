package com.ijse.instagram_clone.repository;

import com.ijse.instagram_clone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(long id);
}
