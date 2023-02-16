package com.shourovfoisal.assesment.controller.passenger;

import com.shourovfoisal.assesment.dao.passenger.PassengerDAO;
import com.shourovfoisal.assesment.dto.passenger.PassengerDTO;
import com.shourovfoisal.assesment.entity.passenger.Passenger;
import com.shourovfoisal.assesment.manager.passenger.PassengerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {
    
    @Autowired
    private PassengerManager passengerManager;
    
    @Autowired
    private PassengerDAO passengerDAO;

    // POST
    @RequestMapping(method = RequestMethod.POST)
    public PassengerDTO createPassenger(@Validated @RequestBody Passenger payload) {

        return passengerManager.createPassenger(payload);
    }

    // Get List
    @RequestMapping(method = RequestMethod.GET)
    public List<PassengerDTO> getPassengerList(@RequestParam(value = "gender_id", required = false) Integer genderId) {

        return passengerManager.getPassengerList(genderId);
    }

    // Get Single
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public PassengerDTO getPassengerById(@PathVariable(value = "id") Integer id ) {

        return passengerManager.getPassengerById(id);
    }

    // Update
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public PassengerDTO updatePassenger(@RequestBody Passenger payload,
                                      @PathVariable(value = "id") Integer id ) {

        Passenger aircraft = passengerDAO.findById(id).get();
        return passengerManager.updatePassenger(aircraft, payload);
    }

    // Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public PassengerDTO updatePassenger(@PathVariable(value = "id") Integer id ) {

        Passenger aircraft = passengerDAO.findById(id).get();
        return passengerManager.deletePassenger(aircraft);
    }
}
