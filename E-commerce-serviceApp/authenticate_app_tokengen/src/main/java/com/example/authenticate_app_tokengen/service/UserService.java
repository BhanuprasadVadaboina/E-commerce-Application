package com.example.authenticate_app_tokengen.service;

import com.example.authenticate_app_tokengen.model.User;

public interface  UserService {
    public User addUser(User user);
    public User CheckUser(User user);
}
