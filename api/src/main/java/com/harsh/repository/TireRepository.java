package com.harsh.repository;

import com.harsh.entity.Tire;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
public interface TireRepository {

    List<Tire> findAll();

    Tire findOne(String id);

    Tire create(Tire tire);

    Tire update(Tire tire);

    void delete(String id);

}