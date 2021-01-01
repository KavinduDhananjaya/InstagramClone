package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userServiceImpl.getAllUsers();
    }

    @GetMapping("find/{uid}")
    public User findUser(@PathVariable int uid) {

        return userServiceImpl.findUser(uid);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
         userServiceImpl.addUser(user);
    }

}
