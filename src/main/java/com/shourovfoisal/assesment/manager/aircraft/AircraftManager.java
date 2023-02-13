package com.shourovfoisal.assesment.manager.aircraft;

import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.service.aircraft.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AircraftManager {

    @Autowired
    private AircraftService aircraftService;

    // Create
    public AircraftDTO createAircraft(Aircraft payload) {
        Aircraft savedAircraft = aircraftService.createAircraft(payload);
        return new AircraftDTO();
    }

}
