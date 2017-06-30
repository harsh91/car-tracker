package com.harsh.repository;

import com.harsh.entity.Tire;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
@Repository
public class TireRepositoryImpl implements TireRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Tire> findAll() {
        return null;
    }

    public Tire findOne(String id) {
        return null;
    }

    public Tire create(Tire tire) {
        entityManager.persist(tire);
        return tire;
    }

    public Tire update(Tire tire) {
        return null;
    }

    public void delete(String id) {

    }
}