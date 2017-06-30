package com.harsh.repository;

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
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String id) {
        System.out.println("Find One Repository");
        return entityManager.find(Vehicle.class, id);
    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        System.out.println("Update Repository");
        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
