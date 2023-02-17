package com.shourovfoisal.assesment.controller.aircraft;

import com.shourovfoisal.assesment.dao.aircraft.AircraftDAO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.manager.aircraft.AircraftManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/aircrafts")
public class AircraftController {

    private static final Logger logger = LoggerFactory.getLogger(AircraftController.class);

    @Autowired
    private AircraftManager aircraftManager;

    @Autowired
    private AircraftDAO aircraftDAO;

    // POST
    @RequestMapping(method = RequestMethod.POST)
    public AircraftDTO createAircraft(@Validated @RequestBody Aircraft payload) {
        AircraftDTO savedAircraft = aircraftManager.createAircraft(payload);
        return savedAircraft;
    }

    // Get List
    @RequestMapping(method = RequestMethod.GET)
    public List<AircraftDTO> getAircraftList(@RequestParam(value = "type_id", required = false) Integer aircraftTypeId) {

        List<AircraftDTO> fetchedAircrafts = aircraftManager.getAircraftList(aircraftTypeId);
        return fetchedAircrafts;
    }

    // Get Single
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AircraftDTO getAircraftById(@PathVariable(value = "id") Integer id ) {

        AircraftDTO fetchedAircraft = aircraftManager.getAircraftById(id);
        return fetchedAircraft;
    }

    // Update
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AircraftDTO updateAircraft(@RequestBody Aircraft payload,
                                      @PathVariable(value = "id") Integer id ) {

        Aircraft aircraft = aircraftDAO.findById(id).get();
        AircraftDTO updatedAircraft = aircraftManager.updateAircraft(aircraft, payload);
        return updatedAircraft;
    }

    // Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public AircraftDTO updateAircraft(@PathVariable(value = "id") Integer id ) {

        Aircraft aircraft = aircraftDAO.findById(id).get();
        AircraftDTO deletedAircraft = aircraftManager.deleteAircraft(aircraft);
        return deletedAircraft;
    }
}
