package com.harsh.repository;

import com.harsh.entity.Reading;
import com.harsh.entity.Vehicle;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
public interface ReadingRepository {

    List<Reading> findAll();

    Reading findOne(String id);

    Vehicle findVehicleByVin(String vin);

    Reading create(Reading reading);

    Reading update(Reading reading);

    void delete(Reading reading);

}
