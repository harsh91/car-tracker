package com.harsh.repository;

import com.harsh.entity.Reading;
import com.harsh.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public Reading findOne(String id) {
        System.out.println("Find One Repository");
        return entityManager.find(Reading.class, id);
    }

    public Vehicle findVehicleByVin(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Reading create(Reading reading) {
        System.out.println("Reading Repository");
        entityManager.persist(reading);
        return reading;
    }

    public Reading update(Reading reading) {
        System.out.println("Update Repository");
        return entityManager.merge(reading);
    }

    public void delete(Reading reading) {
        entityManager.remove(reading);
    }
}
