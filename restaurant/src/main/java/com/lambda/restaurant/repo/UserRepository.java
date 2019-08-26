package com.lambda.restaurant.repo;


import com.lambda.restaurant.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
