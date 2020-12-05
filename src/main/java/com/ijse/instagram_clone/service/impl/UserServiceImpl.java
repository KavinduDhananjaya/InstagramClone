package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.UserService;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    @Override
    public User addUser(User user) {
        User existingUser = userRepository.findUserByEmail(user.getEmail());
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        if (existingUser == null) {
            return userRepository.save(user);
        }else throw new CustomException(401,"We have found another account for this email");
    }


    @Override
    public User findUser(int id) {
        userRepository.findById(id);
        return null;
    }


}
