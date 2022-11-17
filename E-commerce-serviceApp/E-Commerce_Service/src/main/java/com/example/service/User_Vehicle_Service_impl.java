package com.example.service;

import com.example.model.User;
import com.example.model.Vehicle;
import com.example.proxy.Userproxy;
import com.example.model.CommonUser;
import com.example.model.User_Dto;
import com.example.repository.User_Repository;
import com.example.repository.Vehicle_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class User_Vehicle_Service_impl implements User_Vehicle_Service{

    @Autowired
    private Vehicle_Repository vehicle_repository;

    @Autowired
    private User_Repository userRepository;

    @Autowired
    private Userproxy userproxy;

    @Override
    public User addUser(CommonUser user) {
        User user1=new User();
        user1.setUser_name(user.getUser_name());
        user1.setPhoneNo(user.getPhoneNo());
        user1.setAddress(user.getAddress());
        user1.setEmail_id(user.getEmail_id());
        user1.setCart(new ArrayList<>());

        User_Dto userDto=new User_Dto(user.getUser_name(),user.getEmail_id(),user.getPassword());
        userproxy.sendAuthenticatedata(userDto);

        return userRepository.insert(user1);

    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
      return vehicle_repository.insert(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
       return vehicle_repository.save(vehicle);
    }

    @Override
    public Boolean removeVehicle(String vehicleId) {
       vehicle_repository.deleteById(vehicleId);
       return  true;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
       List<Vehicle> vehicleList= vehicle_repository.findAll();
       return vehicleList;
    }

    @Override
    public User getUser(String emailId) {
        return  userRepository.findById(emailId).get();
    }

    @Override
    public User addToCart(String emailId,Vehicle vehicle) {
     User user=userRepository.findById(emailId).get();
     user.getCart().add(vehicle);
     return  userRepository.save(user);
    }

    @Override
    public List<Vehicle> userViewCart(String emailId) {
        User user=userRepository.findById(emailId).get();
        return user.getCart();
    }

//    @Override
//    public User deleteCartItem(String emailId, String vehicleId) {
//        User user=userRepository.findById(emailId).get();
//        List<Vehicle> vehicleList=user.getCart();
//        List<Vehicle> vehicleList1=vehicleList.stream().filter(v-> {
//            if (v.getVehicleId() == vehicleId) {
//                vehicle_repository.deleteById(v.getVehicleId());
//            }
//        return true;}).collect(Collectors.toList());
//        for (Vehicle v:vehicleList1) {
//            System.out.println(v);
//        }
//       user.setCart(vehicleList1);
//        userRepository.save(user);
//        return user;
//    }


}
