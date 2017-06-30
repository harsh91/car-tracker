package com.harsh.service;

import com.harsh.entity.Alert;
import com.harsh.entity.Reading;
import com.harsh.entity.Tire;
import com.harsh.entity.Vehicle;
import com.harsh.exception.BadRequestException;
import com.harsh.exception.ResourceNotFoundException;
import com.harsh.helper.Constant;
import com.harsh.repository.AlertRepository;
import com.harsh.repository.ReadingRepository;
import com.harsh.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Harsh on 6/29/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    TireRepository tireRepository;

    @Autowired
    AlertRepository alertRepository;

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return readingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Reading findOne(String id) {
        Reading existing = readingRepository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with rid " + id + " doesn't exists");
        }
        return existing;
    }

    @Transactional
    public Reading create(Reading reading) {
        System.out.println("Incoming - " + reading);

        Vehicle existing = readingRepository.findVehicleByVin(reading.getVin());

        if (existing == null) {
            throw new BadRequestException("Vehicle with vin " + reading.getVehicle().getVin() + " doesn't exists");
        }

        reading.setVehicle(existing);
        Alert alert = checkAlertExists(reading);
        if (alert != null) {
            alert = alertRepository.create(alert);
            reading.setAlert(alert);
        }

        Tire tire = tireRepository.create(reading.getTires());
        reading.setTires(tire);

        return readingRepository.create(reading);
    }

    private Alert checkAlertExists(Reading reading) {
        Alert alert = new Alert(reading.getTimestamp());
        if (reading.getEngineRpm() > reading.getVehicle().getRedlineRpm()) {
            alert.setPriority(Constant.ALERT_PRIORITY.HIGH.toString());
            alert.setMessage(Constant.ALERT_MESSAGE_FOR_REDLINE_RPM);
            alert.setType(Constant.ALERT_TYPE.ENGINE_RPM.toString());
        } else if (reading.getFuelVolume() < getMinFuelVolumeRequired(reading.getVehicle().getMaxFuelVolume())) {
            alert.setPriority(Constant.ALERT_PRIORITY.MEDIUM.toString());
            alert.setMessage(Constant.ALERT_MESSAGE_FOR_MIN_FUEL_LEVEL);
            alert.setType(Constant.ALERT_TYPE.FUEL.toString());
        } else if (checkTirePressure(reading.getTires())) {
            alert.setPriority(Constant.ALERT_PRIORITY.LOW.toString());
            alert.setMessage(Constant.ALERT_MESSAGE_FOR_TIRE_PRESSURE);
            alert.setType(Constant.ALERT_TYPE.TIRE_PRESSURE.toString());
        } else if (reading.isEngineCoolantLow()) {
            alert.setPriority(Constant.ALERT_PRIORITY.LOW.toString());
            alert.setMessage(Constant.ALERT_MESSAGE_FOR_LOW_ENGINE_COOLANT);
            alert.setType(Constant.ALERT_TYPE.COOLANT.toString());
        } else if (reading.isCheckEngineLightOn()) {
            alert.setPriority(Constant.ALERT_PRIORITY.LOW.toString());
            alert.setMessage(Constant.ALERT_MESSAGE_FOR_LOW_ENGINE_LIGHT);
            alert.setType(Constant.ALERT_TYPE.ENGINE_LIGHT.toString());
        }
        return alert.getType() == null ? null : alert;
    }

    private int getMinFuelVolumeRequired(int maxFuelVolume) {
        return (Constant.MIN_FUEL_REQUIRED_PERCENTAGE * maxFuelVolume) / 100;
    }

    private boolean checkTirePressure(Tire tire) {
        if (tire.getFrontLeft() < Constant.MIN_TIRE_PRESSURE_ALLOWED ||
                tire.getFrontLeft() > Constant.MAX_TIRE_PRESSURE_ALLOWED ||
                tire.getFrontRight() < Constant.MIN_TIRE_PRESSURE_ALLOWED ||
                tire.getFrontRight() > Constant.MAX_TIRE_PRESSURE_ALLOWED ||
                tire.getRearLeft() < Constant.MIN_TIRE_PRESSURE_ALLOWED ||
                tire.getRearLeft() > Constant.MAX_TIRE_PRESSURE_ALLOWED ||
                tire.getRearRight() < Constant.MIN_TIRE_PRESSURE_ALLOWED ||
                tire.getRearRight() > Constant.MAX_TIRE_PRESSURE_ALLOWED) {
            return false;
        }
        return true;
    }

    public Reading update(Reading reading) {
        Reading existing = readingRepository.findOne(reading.getRid());
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with rid " + reading.getRid() + " doesn't exists");
        }
        return readingRepository.update(reading);
    }

    public void delete(String id) {
        Reading existing = readingRepository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with rid " + id + " doesn't exists");
        }
        readingRepository.delete(existing);
    }
}
