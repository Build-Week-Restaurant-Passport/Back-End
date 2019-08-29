package com.lambda.restaurant.repo;

import com.lambda.restaurant.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City,Long> {
//    @Query(value = "SELECT * FROM cities", nativeQuery = true)
//    ArrayList<citycount> getcitycount();
}
