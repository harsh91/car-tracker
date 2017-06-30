package com.harsh.service;

import com.harsh.entity.Reading;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
public interface ReadingService {

    List<Reading> findAll();

    Reading findOne(String id);

    Reading create(Reading reading);

    Reading update(Reading reading);

    void delete(String id);

}
