package com.lambda.restaurant.controllers;

import com.lambda.restaurant.model.City;
import com.lambda.restaurant.model.NewUse;
import com.lambda.restaurant.service.CitySer;
import com.lambda.restaurant.service.newuseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group")
public class Addcontrol {


    @Autowired
    private newuseSer useser;

    @Autowired
    private CitySer cityser;

//    @GetMapping(value = "/city",
//            produces = {"application/json"})
//    public ResponseEntity<?> listAllcity()
//    {
//        List<City> allcities = cityser.findAll();
//        return new ResponseEntity<>(allcities, HttpStatus.OK);
//    }

    @GetMapping("/city")
    List<City> all() {
        return cityser.findAll();
    }


    @PostMapping("/city/add")
    City newc(@RequestBody City newc){
        return cityser.save(newc);
    }

    @PutMapping(value = "/city/{id}")
    public ResponseEntity<?> updateUser(HttpServletRequest request,
                                        @RequestBody
                                                User updateUser,
                                        @PathVariable
                                                long id)
    {

        cityser.update(updateUser, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PostMapping("/add")
    NewUse newuser(@RequestBody NewUse newuser){
        return useser.save(newuser);
    }

    @DeleteMapping("/delete/{id}")
    void deleteuser(@PathVariable Long id){
        useser.delete(id);
    }



}
