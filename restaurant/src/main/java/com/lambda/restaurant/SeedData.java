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
    UserService userService;


    @Autowired
    RoleService roleService;

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        ArrayList<UserRoles> users = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));

        User u1 = new User("admin", "password", admins);

        User u2 = new User("guest","pass",users);

        User u3 = new User("guest2","pass2",users);

        users.add(new UserRoles(new User(),r2));

        userService.save(u2);
        userService.save(u1);
        userService.save(u3);

        System.out.println(u3.getAuthority());
        System.out.println();


    }
}
