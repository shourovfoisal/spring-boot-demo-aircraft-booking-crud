package com.shourovfoisal.assesment.manager.aircraft;

import com.shourovfoisal.assesment.component.QueryBuilder;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.service.aircraft.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<AircraftDTO> getAircraftList(Integer aircraftTypeId) {

        String conditions = "";
        List<Object> args = new LinkedList<>();
        List<Integer> argTypes = new ArrayList<>();

        if(aircraftTypeId != null) {
            conditions += " AND at.id=? ";
            args.add(aircraftTypeId);
            argTypes.add(Types.INTEGER);
        }

        String query = queryBuilder.getQueryParamOfAircraft(conditions);

        List<AircraftDTO> fetchedAircraft = aircraftService.getAircraftList(query, args.toArray(), argTypes.stream().mapToInt(i -> i).toArray());

        return fetchedAircraft;

    }

    public AircraftDTO getAircraftById(Integer id) {

        String conditions = "";
        List<Object> parameters = new LinkedList<>();
        List<Integer> argTypes = new ArrayList<>();

        conditions += " AND a.id=? ";
        parameters.add(id);
        argTypes.add(Types.INTEGER);

        String query = queryBuilder.getQueryParamOfAircraft(conditions);

        List<AircraftDTO> fetchedAircrafts = aircraftService.getAircraftList(query, parameters.toArray(), argTypes.stream().mapToInt(i -> i).toArray());

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
