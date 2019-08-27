package com.lambda.restaurant;

import com.lambda.restaurant.model.Role;
import com.lambda.restaurant.model.User;
import com.lambda.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

//@Transactional
//@Component
public class SeedData implements CommandLineRunner {


    @Autowired
    UserService userService;

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");


        User u1 = new User("admin", "password","email");

        userService.save(u1);
    }
}
