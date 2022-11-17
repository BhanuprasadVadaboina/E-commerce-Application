package com.example.proxy;

import com.example.model.User_Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authenticate-app-service",url ="localhost:3000")
public interface Userproxy {
    @PostMapping("/Userapp/v1/user-Register")
    public ResponseEntity<?> sendAuthenticatedata(@RequestBody User_Dto userDTO);
}
