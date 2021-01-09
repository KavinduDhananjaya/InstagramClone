package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.controller.ReactController;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.repository.ReactRepository;
import com.ijse.instagram_clone.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReactServiceImpl implements ReactService {

    @Autowired
    private ReactRepository reactRepository;


    @Override
    public void addReact(int reactType) {

        final React react = new React();

        reactRepository.save(react);


    }
}
