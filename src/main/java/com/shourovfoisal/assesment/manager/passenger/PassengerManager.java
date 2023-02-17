package com.shourovfoisal.assesment.manager.passenger;

import com.shourovfoisal.assesment.component.QueryBuilder;
import com.shourovfoisal.assesment.dto.passenger.PassengerDTO;
import com.shourovfoisal.assesment.entity.passenger.Passenger;
import com.shourovfoisal.assesment.service.passenger.PassengerService;
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
public class PassengerManager {

    private static final Logger logger = LoggerFactory.getLogger(PassengerManager.class);
    
    @Autowired
    private PassengerService passengerService;
    
    @Autowired
    private QueryBuilder queryBuilder;

    public PassengerDTO createPassenger(Passenger payload) {
        Passenger savedPassenger = passengerService.createPassenger(payload);
        return getPassengerById(savedPassenger.getId());
    }

    public List<PassengerDTO> getPassengerList(String name, Integer genderId) {

        String conditions = "";
        List<Object> args = new LinkedList<>();
        List<Integer> argTypes = new LinkedList<>();

        if(name != null) {
            conditions += " AND p.name LIKE ?";
            name = "%"+name+"%";
            args.add(name);
            argTypes.add(Types.VARCHAR);
        }

        if(genderId != null) {
            conditions += " AND g.id=? ";
            args.add(genderId);
            argTypes.add(Types.INTEGER);
        }

        String query = queryBuilder.getQueryParamOfPassenger(conditions);

        return passengerService.getPassengerList(query, args.toArray(), argTypes.stream().mapToInt(i -> i).toArray());
    }

    public PassengerDTO getPassengerById(Integer id) {

        String conditions = "";
        List<Object> parameters = new LinkedList<>();
        List<Integer> argTypes = new LinkedList<>();

        conditions += " AND p.id=? ";
        parameters.add(id);
        argTypes.add(Types.INTEGER);

        String query = queryBuilder.getQueryParamOfPassenger(conditions);

        List<PassengerDTO> fetchedPassengers = passengerService.getPassengerList(query, parameters.toArray(), argTypes.stream().mapToInt(i -> i).toArray());

        return fetchedPassengers.get(0);
    }


    public PassengerDTO updatePassenger(Passenger passenger, Passenger payload) {

        if(payload.getName() != null)
            passenger.setName(payload.getName());

        if(payload.getAge() != 0)
            passenger.setAge(payload.getAge());

        if(!Objects.isNull(payload.getGender()) && payload.getGender().getId() != null)
            passenger.setGender(payload.getGender());

        Passenger updatedPassenger =  passengerService.updatePassenger(passenger);
        return getPassengerById(updatedPassenger.getId());
    }

    public PassengerDTO deletePassenger(Passenger passenger) {

        PassengerDTO deletedPassenger = getPassengerById(passenger.getId());
        passengerService.deletePassenger(passenger);
        return deletedPassenger;
    }
    
}
