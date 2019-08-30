package com.lambda.restaurant.service;

import com.lambda.restaurant.exceptions.ResourceNotFoundException;
import com.lambda.restaurant.model.City;
import com.lambda.restaurant.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    public City findCityId(long id) throws ResourceNotFoundException
    {
        return cityRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public City save( City city){

        City newcity = new City();
        newcity.setCityname(city.getCityname());

        return cityRepo.save(newcity);
    }

    @Override
    public void delete(long id)
    {

        if (cityRepo.findById(id).isPresent())
        {
            cityRepo.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public City update(City user, long id) {

        City current = cityRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
            if(id == current.getCityid()) {
                current.setCityname(user.getCityname());

            }
        return cityRepo.save(current);
    }



}