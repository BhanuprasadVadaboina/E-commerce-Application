package com.example.controller;

import com.example.model.Vehicle;
import com.example.model.CommonUser;
import com.example.service.User_Vehicle_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Vehicle-app/v1")
@RestController
public class Vehicle_controller {

    @Autowired
    User_Vehicle_Service user_vehicle_service;

    @PostMapping("/add-vehicle")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle){
      return new ResponseEntity<>(user_vehicle_service.addVehicle(vehicle),HttpStatus.OK);
    }

    @PutMapping("/update-vehicle")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(user_vehicle_service.updateVehicle(vehicle),HttpStatus.OK);
    }

    @GetMapping("/get-User/{emailId}")
    public ResponseEntity<?> getUser(@PathVariable String emailId){
        return new ResponseEntity<>(user_vehicle_service.getUser(emailId),HttpStatus.OK);
    }

    @DeleteMapping("/remove-Vehicle/{vehicleId}")
    public ResponseEntity<?> removeVehicle(@PathVariable String vehicleId){
        return new ResponseEntity<>(user_vehicle_service.removeVehicle(vehicleId),HttpStatus.OK);
    }


    @GetMapping("/get-all-vehicles")
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<>(user_vehicle_service.getAllVehicles(),HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody CommonUser user){
        return new ResponseEntity<>(user_vehicle_service.addUser(user),HttpStatus.OK);
    }

    @PutMapping("/add-to-cart/{emailId}")
    public ResponseEntity<?> addToCart(@PathVariable String emailId,@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(user_vehicle_service.addToCart(emailId,vehicle),HttpStatus.OK);
    }

    @GetMapping("/user-view-cart/{emailId}")
    public ResponseEntity<?> viewCart(@PathVariable String emailId){
        return new ResponseEntity<>(user_vehicle_service.userViewCart(emailId),HttpStatus.OK);
    }

//    @PutMapping("/delete-cart-item/{emailId}/{vehicleId}")
//    public ResponseEntity<?> deleteCartItem(@PathVariable String emailId,@PathVariable String vehicleId){
//        return new ResponseEntity<>(user_vehicle_service.deleteCartItem(emailId,vehicleId),HttpStatus.OK);
//    }

}
