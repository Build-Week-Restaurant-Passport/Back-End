package com.lambda.restaurant.service;

import com.lambda.restaurant.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface CitySer {
    List<City> findAll();
    City save(City city);

//    ArrayList<City> getcitycount();
}
