package com.example.authenticate_app_tokengen.service;

import com.example.authenticate_app_tokengen.model.User;

import java.util.Map;

public interface SecurityTokenGen {
    public abstract Map<String, String> generateToken(User user);
 }
