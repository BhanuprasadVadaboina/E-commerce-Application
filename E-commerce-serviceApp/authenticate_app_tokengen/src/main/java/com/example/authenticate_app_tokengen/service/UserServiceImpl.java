package com.example.authenticate_app_tokengen.service;

import com.example.authenticate_app_tokengen.model.User;
import com.example.authenticate_app_tokengen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User CheckUser(User user) {
        if(userRepository.findById(user.getUser_id()).isPresent()){
            User details=userRepository.findById(user.getUser_id()).get();
            if(details.getPassword().equals(user.getPassword())){
                return details;
            }
            else return null;
        }
        return null;
    }
}
