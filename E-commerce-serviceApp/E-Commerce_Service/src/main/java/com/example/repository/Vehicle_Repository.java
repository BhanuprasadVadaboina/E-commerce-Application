package com.example.repository;

import com.example.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Vehicle_Repository extends MongoRepository<Vehicle,String> {
}
