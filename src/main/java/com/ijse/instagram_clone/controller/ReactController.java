package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.service.impl.ReactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/react")
public class ReactController {


    @Autowired
    private ReactServiceImpl reactServiceImpl;


    @PostMapping("/addReact/{id}")
    public void addReact(int reactType, @PathVariable(value = "id") long postId) {
        reactServiceImpl.addReact(reactType, postId);
    }

}
