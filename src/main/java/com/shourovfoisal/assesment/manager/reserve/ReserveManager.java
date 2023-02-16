package com.shourovfoisal.assesment.manager.reserve;

import com.shourovfoisal.assesment.component.QueryBuilder;
import com.shourovfoisal.assesment.dto.reserve.ReserveDTO;
import com.shourovfoisal.assesment.entity.reserve.Reserve;
import com.shourovfoisal.assesment.manager.passenger.PassengerManager;
import com.shourovfoisal.assesment.service.reserve.ReserveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Component
public class ReserveManager {

    private static final Logger logger = LoggerFactory.getLogger(ReserveManager.class);
    
    @Autowired
    private ReserveService reserveService;

    @Autowired
    private QueryBuilder queryBuilder;

    public ReserveDTO createReserve(Reserve payload) {
        Reserve savedReserve = reserveService.createReserve(payload);
        return getReserveById(savedReserve.getId());
    }

    public List<ReserveDTO> getReserveList(Integer aircraftTypeId, String passengerName) {

        String conditions = "";
        List<Object> args = new LinkedList<>();
        List<Integer> argTypes = new ArrayList<>();

        if(aircraftTypeId != null) {
            conditions += " AND at.id=? ";
            args.add(aircraftTypeId);
            argTypes.add(Types.INTEGER);
        }

        if(passengerName != null) {
            conditions += " AND p.name LIKE ?";
            passengerName = "%"+passengerName+"%";
            args.add(passengerName);
            argTypes.add(Types.VARCHAR);
        }

        String query = queryBuilder.getQueryParamOfReserve(conditions);

        return reserveService.getReserveList(query, args.toArray(), argTypes.stream().mapToInt(i -> i).toArray());
    }

    public ReserveDTO getReserveById(Integer id) {

        String conditions = "";
        List<Object> parameters = new LinkedList<>();
        List<Integer> argTypes = new LinkedList<>();

        conditions += " AND r.id=? ";
        parameters.add(id);
        argTypes.add(Types.INTEGER);

        String query = queryBuilder.getQueryParamOfReserve(conditions);

        List<ReserveDTO> fetchedReserves = reserveService.getReserveList(query, parameters.toArray(), argTypes.stream().mapToInt(i -> i).toArray());

        return fetchedReserves.get(0);
    }


    public ReserveDTO updateReserve(Reserve reserve, Reserve payload) {

        if(!Objects.isNull(payload.getAircraft()) && payload.getAircraft().getId() != null)
            reserve.setAircraft(payload.getAircraft());

        if(!Objects.isNull(payload.getPassenger()) && payload.getPassenger().getId() != null)
            reserve.setPassenger(payload.getPassenger());

        if(payload.getDateOfFly() != null)
            reserve.setDateOfFly(payload.getDateOfFly());

        if(payload.getSource() != null)
            reserve.setSource(payload.getSource());

        if(payload.getDestination() != null)
            reserve.setDestination(payload.getDestination());

        Reserve updatedReserve =  reserveService.updateReserve(reserve);
        return getReserveById(updatedReserve.getId());
    }

    public ReserveDTO deleteReserve(Reserve reserve) {

        ReserveDTO deletedReserve = getReserveById(reserve.getId());
        reserveService.deleteReserve(reserve);
        return deletedReserve;
    }

}
