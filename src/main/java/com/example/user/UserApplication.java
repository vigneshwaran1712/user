package com.example.user;

import com.example.user.model.User;
import com.example.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UserApplication implements ApplicationRunner {

    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = userRepo.findAll();
        System.out.println("Printing all users from the database:");
        users.forEach(user -> {
            System.out.println(user.getUsername() + " - " + user.getPassword()); // Adjust based on your User model
        });
    }
}
