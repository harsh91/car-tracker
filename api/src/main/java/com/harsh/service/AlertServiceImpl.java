package com.harsh.service;

import com.harsh.entity.Alert;
import com.harsh.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Harsh on 6/29/2017.
 */
@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    @Transactional
    public Alert create(Alert alert) {
        return alertRepository.create(alert);
    }

}