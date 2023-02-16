package com.shourovfoisal.assesment.manager.aircraft;

import com.shourovfoisal.assesment.component.QueryBuilder;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import com.shourovfoisal.assesment.entity.aircraft.AircraftType;
import com.shourovfoisal.assesment.service.aircraft.AircraftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class AircraftTypeManager {

    @Autowired
    private AircraftTypeService aircraftTypeService;

    @Autowired
    private QueryBuilder queryBuilder;

    public void createAircraftType(AircraftType payload) {
        aircraftTypeService.createAircraftType(payload);
    }

    public List<AircraftTypeDTO> getAircraftTypeList() {

        String conditions = "";
        List<Object> args = new LinkedList<>();
        List<Integer> argTypes = new LinkedList<>();

        String query = queryBuilder.getQueryParamOfAircraftType(conditions);

        return aircraftTypeService.getAircraftTypeList(query, args.toArray(), argTypes.stream().mapToInt(i -> i).toArray());
    }
}
