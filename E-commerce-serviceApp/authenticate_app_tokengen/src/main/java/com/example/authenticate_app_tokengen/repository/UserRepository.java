package com.example.authenticate_app_tokengen.repository;

import com.example.authenticate_app_tokengen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
