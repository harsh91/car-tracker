package com.harsh.service;

import com.harsh.entity.Tire;
import com.harsh.exception.ResourceNotFoundException;
import com.harsh.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
@Service
public class TireServiceImpl implements TireService {

    @Autowired
    TireRepository tireRepository;

    public List<Tire> findAll() {
        return tireRepository.findAll();
    }

    public Tire findOne(String id) {
        Tire existing = tireRepository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with rid " + id + " doesn't exists");
        }
        return existing;
    }

    public Tire create(Tire tire) {
        System.out.println("Tire service");
        return tireRepository.create(tire);
    }

    public Tire update(Tire tire) {
        return tireRepository.update(tire);
    }

    public void delete(String id) {
        tireRepository.delete(id);
    }
}