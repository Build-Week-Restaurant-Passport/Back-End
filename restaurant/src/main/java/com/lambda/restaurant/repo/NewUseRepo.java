package com.lambda.restaurant.repo;

import com.lambda.restaurant.model.NewUse;
import org.springframework.data.repository.CrudRepository;

public interface NewUseRepo extends CrudRepository<NewUse,Long> {
    NewUse findByEmail(String email);
}
