package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.React;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactService {

    void addReact(int reactType, long postId);

    List<React> getReactList(long postId);
}
