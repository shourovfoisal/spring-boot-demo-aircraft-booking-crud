package com.shourovfoisal.assesment.controller.reserve;


import com.shourovfoisal.assesment.dao.reserve.ReserveDAO;
import com.shourovfoisal.assesment.dto.reserve.ReserveDTO;
import com.shourovfoisal.assesment.entity.reserve.Reserve;
import com.shourovfoisal.assesment.manager.reserve.ReserveManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserves")
public class ReserveController {
    
    @Autowired
    private ReserveManager reserveManager;
    
    @Autowired
    private ReserveDAO reserveDAO;

    // POST
    @RequestMapping(method = RequestMethod.POST)
    public ReserveDTO createReserve(@Validated @RequestBody Reserve payload) {

        return reserveManager.createReserve(payload);
    }

    // Get List
    @RequestMapping(method = RequestMethod.GET)
    public List<ReserveDTO> getReserveList(@RequestParam(value = "aircraft_type_id", required = false) Integer aircraftTypeId,
                                           @RequestParam(value = "passenger_name", required = false) String passengerName) {

        return reserveManager.getReserveList(aircraftTypeId, passengerName);
    }

    // Get Single
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ReserveDTO getReserveById(@PathVariable(value = "id") Integer id ) {

        return reserveManager.getReserveById(id);
    }

    // Update
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ReserveDTO updateReserve(@RequestBody Reserve payload,
                                        @PathVariable(value = "id") Integer id ) {

        Reserve aircraft = reserveDAO.findById(id).get();
        return reserveManager.updateReserve(aircraft, payload);
    }

    // Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ReserveDTO updateReserve(@PathVariable(value = "id") Integer id ) {

        Reserve aircraft = reserveDAO.findById(id).get();
        return reserveManager.deleteReserve(aircraft);
    }
    
}
