package com.lambda.restaurant.service;

import com.lambda.restaurant.model.NewUse;

import java.util.List;

public interface newuseSer {

    List<NewUse> findAll();

    NewUse findUserById(long id);

    void delete(long id);

    NewUse save(NewUse newUse);

//    NewUse update(NewUse newuser, long id);
}
