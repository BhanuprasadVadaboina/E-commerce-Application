package com.example.authenticate_app_tokengen.service;

import com.example.authenticate_app_tokengen.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGenImpl implements SecurityTokenGen{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result=new HashMap<>();
        Map<String,Object> data=new HashMap<>();
        data.put("UserObject",user);
        String jwtToken= Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecurekey").compact();
        result.put("token",jwtToken);
        result.put("message","user successfully logged in");
        return result;
    }
}
