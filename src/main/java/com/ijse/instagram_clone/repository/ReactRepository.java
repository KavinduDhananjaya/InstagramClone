package com.ijse.instagram_clone.repository;

import com.ijse.instagram_clone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactRepository extends JpaRepository<Post, Long> {
}