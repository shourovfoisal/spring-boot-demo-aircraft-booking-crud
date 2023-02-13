package com.shourovfoisal.assesment.controller.aircraft;

import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.manager.aircraft.AircraftManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aircraft")
public class AircraftController {

    @Autowired
    private AircraftManager aircraftManager;

    // POST
    @RequestMapping(method = RequestMethod.POST)
    public AircraftDTO createAircraft(@Validated @RequestBody Aircraft payload) {
        AircraftDTO savedAircraft = aircraftManager.createAircraft(payload);
        return savedAircraft;
    }


}
