package com.example.user.service;

import com.example.user.dto.LoginRequest;
import com.example.user.model.User;
import com.example.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    public boolean authenticate(LoginRequest loginRequest) {
        System.out.println("Authenticating user...");
        Optional<User> userOptional = userRepo.findByUsername(loginRequest.getUsername());
        System.out.println(userOptional.isPresent());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(loginRequest.getPassword());
        }
        return false;
    }
}
