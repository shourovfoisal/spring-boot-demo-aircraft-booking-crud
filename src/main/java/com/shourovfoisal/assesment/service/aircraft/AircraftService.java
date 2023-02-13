package com.shourovfoisal.assesment.service.aircraft;

import com.shourovfoisal.assesment.dao.aircraft.AircraftDAO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AircraftService {

    @Autowired
    private AircraftDAO aircraftDAO;

    // Create
    public Aircraft createAircraft(Aircraft payload) {
        payload.setCreatedTime(LocalDateTime.now());
        Aircraft savedAircraft = aircraftDAO.save(payload);
        return savedAircraft;
    }

}
