package com.lambda.restaurant.controllers;

import com.lambda.restaurant.model.NewUse;
import com.lambda.restaurant.service.newuseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class Addcontrol {


    @Autowired
    private newuseSer useser;

    @PostMapping("/add")
    NewUse newuser(@RequestBody NewUse newuser){
        return useser.save(newuser);
    }

    @DeleteMapping("/user/{id}")
    void deleteuser(@PathVariable Long id){
        useser.delete(id);
    }

}
