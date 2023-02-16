package com.shourovfoisal.assesment.manager.aircraft;

import com.shourovfoisal.assesment.entity.aircraft.AircraftType;
import com.shourovfoisal.assesment.service.aircraft.AircraftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AircraftTypeManager {

    @Autowired
    private AircraftTypeService aircraftTypeService;

    public void createAircraftType(AircraftType payload) {
        aircraftTypeService.createAircraftType(payload);
    }
}
