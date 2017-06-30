package com.harsh;

import com.harsh.entity.Reading;
import com.harsh.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
@RestController
@RequestMapping(value = "readings")
@CrossOrigin
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
        return readingService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOne(@PathVariable("id") String empID) {
        return readingService.findOne(empID);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading reading) {
        System.out.println("Reading Controller !!");
        System.out.println(reading);
        return readingService.create(reading);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading update(@RequestBody Reading reading) {
        System.out.println("Controller !!");
        return readingService.update(reading);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String empID) {
        readingService.delete(empID);
    }

}