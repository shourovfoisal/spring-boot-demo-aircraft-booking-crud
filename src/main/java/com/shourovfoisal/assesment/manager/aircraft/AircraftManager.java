package com.shourovfoisal.assesment.manager.aircraft;

import com.shourovfoisal.assesment.component.QueryBuilder;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.service.aircraft.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class AircraftManager {

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private QueryBuilder queryBuilder;

    // Create
    public AircraftDTO createAircraft(Aircraft payload) {
        Aircraft savedAircraft = aircraftService.createAircraft(payload);
        return getAircraftById(savedAircraft.getId());
    }

    public List<AircraftDTO> getAircraftList() {

        String conditions = "";
        List<Object> parameters = new LinkedList<>();

        int[] argTypes = { };

        String query = queryBuilder.getQueryParamOfAircraft(conditions);

        List<AircraftDTO> fetchedAircraft = aircraftService.getAircraftList(query, parameters.toArray(), argTypes);

        return fetchedAircraft;

    }

    public AircraftDTO getAircraftById(Integer id) {

        String conditions = "";
        List<Object> parameters = new LinkedList<>();

        conditions += " AND a.id=? ";
        parameters.add(id);

        int[] argTypes = { java.sql.Types.INTEGER };

        String query = queryBuilder.getQueryParamOfAircraft(conditions);

        List<AircraftDTO> fetchedAircrafts = aircraftService.getAircraftList(query, parameters.toArray(), argTypes);

        return fetchedAircrafts.get(0);
    }


    public AircraftDTO updateAircraft(Aircraft aircraft, Aircraft payload) {

        aircraft.setName(payload.getName());
        aircraft.setAircraftType(payload.getAircraftType());

        Aircraft updatedAircraft =  aircraftService.updateAircraft(aircraft);
        return getAircraftById(updatedAircraft.getId());
    }

    public AircraftDTO deleteAircraft(Aircraft aircraft) {

        AircraftDTO deletedAircraft = getAircraftById(aircraft.getId());
        aircraftService.deleteAircraft(aircraft);
        return deletedAircraft;
    }
}
