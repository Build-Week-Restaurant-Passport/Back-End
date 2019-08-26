package com.lambda.restaurant;

import com.lambda.restaurant.model.Role;
import com.lambda.restaurant.model.User;
import com.lambda.restaurant.model.UserRoles;
import com.lambda.restaurant.service.RoleService;
import com.lambda.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");

        roleService.save(r1);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        User u1 = new User("admin", "password", admins);

        userService.save(u1);
    }
}
