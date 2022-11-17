package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    private String vehicleId;

    private String vehicle_name;
    private String color;
    private String fuelType;
    private int noOfSeats;
    private String safety;
}
