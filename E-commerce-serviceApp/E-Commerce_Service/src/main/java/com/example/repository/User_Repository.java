package com.example.repository;

import com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Repository extends MongoRepository<User,String> {
}
