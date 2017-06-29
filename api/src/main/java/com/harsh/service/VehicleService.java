package com.harsh.service;

import com.harsh.entity.Vehicle;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle vehicle);

    List<Vehicle> update(List<Vehicle> vehicles);

    void delete(String id);

}