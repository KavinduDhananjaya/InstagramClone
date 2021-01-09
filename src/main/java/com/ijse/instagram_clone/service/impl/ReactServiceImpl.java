package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.controller.ReactController;
import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.repository.ReactRepository;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactServiceImpl implements ReactService {

    @Autowired
    private ReactRepository reactRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void addReact(int reactType, long postId) {

        Post post = postRepository.findPostById(postId);
        User currentUser = userRepository.findUserByEmail("");

        React react = new React(reactType, post, currentUser);

        reactRepository.save(react);
    }

    @Override
    public List<React> getReactList(long postId) {
        return reactRepository.findReactsByPost(postId);
    }
}
