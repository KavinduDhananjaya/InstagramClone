package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;


    @Override
    public List<Post> getAllPost(Pageable page) {
        return postRepository.findAll(page).getContent();
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }


    @Override
    public Post getSinglePost(long id) {
        return postRepository.findPostById(id);
    }
}
