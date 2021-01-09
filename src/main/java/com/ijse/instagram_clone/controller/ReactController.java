package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.service.impl.ReactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/react")
public class ReactController {


    @Autowired
    private ReactServiceImpl reactServiceImpl;


    @PostMapping("/addReact/{id}")
    public void addReact(int reactType, @PathVariable(value = "id") long postId) {
        reactServiceImpl.addReact(reactType, postId);
    }

    @GetMapping("/getAll/{id}")
    public List<React> getAll(@PathVariable(value = "id") long postId) {
        return reactServiceImpl.getReactList(postId);
    }

}
