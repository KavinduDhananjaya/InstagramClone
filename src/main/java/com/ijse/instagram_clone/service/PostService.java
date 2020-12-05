package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    Post addPost(Post post);

}
