package com.shourovfoisal.assesment.service.aircraft;

import com.shourovfoisal.assesment.dao.aircraft.AircraftTypeDAO;
import com.shourovfoisal.assesment.entity.aircraft.AircraftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AircraftTypeService {

    @Autowired
    private AircraftTypeDAO aircraftTypeDAO;

    public void createAircraftType(AircraftType payload) {
        payload.setCreatedTime(LocalDateTime.now());
        aircraftTypeDAO.save(payload);
    }
}
