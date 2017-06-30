package com.harsh.repository;

import com.harsh.entity.Vehicle;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
public interface VehicleRepository {

    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    void delete(Vehicle vehicle);

}
