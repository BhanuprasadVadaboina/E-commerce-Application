package com.example.service;

import com.example.model.User;
import com.example.model.Vehicle;
import com.example.model.CommonUser;

import java.util.List;

public interface User_Vehicle_Service {
    public abstract User addUser(CommonUser user);
    public abstract Vehicle addVehicle(Vehicle vehicle);
    public abstract Vehicle updateVehicle(Vehicle vehicle);
    public abstract Boolean removeVehicle(String vehicleId);

    public abstract List<Vehicle> getAllVehicles();
    public abstract User getUser(String  emailId);
    public abstract User addToCart(String emailId,Vehicle vehicle);
    public abstract List<Vehicle> userViewCart(String emailId);
//    public abstract User deleteCartItem(String emailId,String vehicleId);
}
