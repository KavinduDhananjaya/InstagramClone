package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.entity.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<Post> getAllPost(Pageable page);

    Post addPost(Post post);

    Post getSinglePost(long id);


}
