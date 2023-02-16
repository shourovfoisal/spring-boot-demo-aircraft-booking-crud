package com.shourovfoisal.assesment.controller.aircraft;

import com.shourovfoisal.assesment.entity.aircraft.AircraftType;
import com.shourovfoisal.assesment.manager.aircraft.AircraftTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aircraft-types")
public class AircraftTypeController {

    @Autowired
    private AircraftTypeManager aircraftTypeManager;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public void createAircraftType(@Validated @RequestBody AircraftType payload) {
        aircraftTypeManager.createAircraftType(payload);
    }
}
