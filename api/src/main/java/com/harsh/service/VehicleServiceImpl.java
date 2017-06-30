package com.harsh.service;

import com.harsh.exception.BadRequestException;
import com.harsh.exception.ResourceNotFoundException;
import com.harsh.entity.Vehicle;
import com.harsh.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Vehicle existing = vehicleRepository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + id + " doesn't exists");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Vehicle existing = vehicleRepository.findOne(vehicle.getVin());
        if (existing != null) {
            throw new BadRequestException("Vehicle with vin " + existing.getVin() + " already exists");
        }
        return vehicleRepository.create(vehicle);
    }

    @Transactional
    public List<Vehicle> update(List<Vehicle> vehicles) {
        System.out.println("Service !!");
        List<Vehicle> mergeVehicles = new ArrayList<Vehicle>();
        for(Vehicle vehicle: vehicles) {
            Vehicle existing = vehicleRepository.findOne(vehicle.getVin());
            if (existing == null) {
                vehicleRepository.create(vehicle);
            }
            mergeVehicles.add(vehicleRepository.update(vehicle));
        }
        return mergeVehicles;
    }

    @Transactional
    public void delete(String id) {
        Vehicle existing = vehicleRepository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + id + " doesn't exists");
        }
        vehicleRepository.delete(existing);
    }

}
