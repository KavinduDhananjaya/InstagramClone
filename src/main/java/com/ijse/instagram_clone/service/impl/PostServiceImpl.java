package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;


    @Override
    public List<Post> getAllPost() {

        return null;
    }

    @Override
    public Post addPost(Post post) {

        return postRepository.save(post);
    }
}
