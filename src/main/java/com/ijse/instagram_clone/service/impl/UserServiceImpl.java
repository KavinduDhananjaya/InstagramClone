package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

//        return userRepository.findAll( ).stream( ).map(this::addUser).collect(Collectors.toList( ));

        return userRepository.findAll();
    }


    @Override
    public User addUser(User user) {
       User usr= userRepository.findUserByEmail(user.getEmail());

       if(usr==null){
           return userRepository.save(user);
       }
       return null;
    }


    @Override
    public User findUser(int id) {
        userRepository.findById(id);
        return null;
    }


}
