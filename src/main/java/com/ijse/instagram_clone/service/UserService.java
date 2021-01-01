package com.ijse.instagram_clone.service;
import com.ijse.instagram_clone.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    User findUser(int id);

}
