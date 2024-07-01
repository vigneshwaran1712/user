package com.example.user.controller;

import com.example.user.dto.LoginRequest;
import com.example.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
        System.out.println("LoginRequest received:");
        System.out.println("Username: " + loginRequest.getUsername());
        System.out.println("Password: " + loginRequest.getPassword());
        return authService.authenticate(loginRequest);
    }
}
