package com.harsh.repository;

import com.harsh.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Harsh on 6/29/2017.
 */
@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Alert create(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

}