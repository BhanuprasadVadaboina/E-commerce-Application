package com.example.authenticate_app_tokengen.controller;

import com.example.authenticate_app_tokengen.model.User;
import com.example.authenticate_app_tokengen.service.SecurityTokenGen;
import com.example.authenticate_app_tokengen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RequestMapping("/Userapp/v1")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityTokenGen securityTokenGen;
//"http:/localhost
    @PostMapping("/user-Register")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user.setRole("ROLE_User");
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.ACCEPTED);
    }


//    @PostMapping("/user-Register")
//    public ResponseEntity<?> addUser1(@RequestBody User user) {
//        user.setRole("ROLE_User");
//        return new ResponseEntity<>(userService.addUser(user), HttpStatus.ACCEPTED);
//    }

    @PostMapping("/user-check")
    public ResponseEntity<?> checkuser(@RequestBody User user) {
        User result = userService.CheckUser(user);
        if (result != null) {
            Map<String,String> key=securityTokenGen.generateToken(result);
            return new ResponseEntity<>(key, HttpStatus.OK);
        } else
            return new ResponseEntity<>("Authentication Failed", HttpStatus.NOT_FOUND);
    }
}
