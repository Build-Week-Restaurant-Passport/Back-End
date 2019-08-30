package com.lambda.restaurant.repo;

import com.lambda.restaurant.model.City;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CityRepo extends CrudRepository<City,Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE from City where cityid = :id")
    void deletecityById(long id);


}
