package com.lambda.restaurant.service;

import com.lambda.restaurant.model.City;
import com.lambda.restaurant.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service(value = "city")
public class CitySerImpl implements CitySer{

    @Autowired
    private CityRepo cityRepo;

//    @Override
//    public ArrayList<citycount> getcitycount()
//    {
//        return cityRepo.getcitycount();
//    }

    @Override
    public List<City> findAll() {
        List<City> list = new ArrayList<>();
        cityRepo.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Transactional
    @Override
    public City save( City city){

        City newcity = new City();
        newcity.setCityname(city.getCityname());

        return cityRepo.save(newcity);
    }

}
