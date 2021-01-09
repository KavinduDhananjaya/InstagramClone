package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.entity.Post;
import org.springframework.stereotype.Service;

@Service
public interface ReactService {

    void addReact(int reactType, long postId);

}
