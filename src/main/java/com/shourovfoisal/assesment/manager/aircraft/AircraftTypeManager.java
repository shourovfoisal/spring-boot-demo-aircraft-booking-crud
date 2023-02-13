package com.shourovfoisal.assesment.manager.aircraft;

import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import com.shourovfoisal.assesment.entity.aircraft.AircraftType;
import com.shourovfoisal.assesment.service.aircraft.AircraftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AircraftTypeManager {

    @Autowired
    private AircraftTypeService aircraftTypeService;

    // Create
    public AircraftTypeDTO createAircraftType(AircraftType payload) {
        AircraftType savedAircraftType = aircraftTypeService.createAircraftType(payload);
        return new AircraftTypeDTO();
    }

}
