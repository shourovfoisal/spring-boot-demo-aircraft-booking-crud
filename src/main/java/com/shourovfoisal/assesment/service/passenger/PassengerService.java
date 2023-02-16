package com.shourovfoisal.assesment.service.passenger;

import com.shourovfoisal.assesment.dao.passenger.PassengerDAO;
import com.shourovfoisal.assesment.dto.passenger.PassengerDTO;
import com.shourovfoisal.assesment.entity.passenger.Passenger;
import com.shourovfoisal.assesment.mapper.passenger.PassengerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private JdbcTemplate template;
    
    @Autowired
    private PassengerDAO passengerDAO;

    public Passenger createPassenger(Passenger payload) {
        payload.setCreatedTime(LocalDateTime.now());
        return passengerDAO.save(payload);
    }

    public List<PassengerDTO> getPassengerList(String query, Object[] parameters, int[] argTypes) {
        return this.template.query(query, parameters, argTypes, new PassengerRowMapper());
    }

    public Passenger updatePassenger(Passenger passenger) {
        passenger.setUpdatedTime(LocalDateTime.now());
        return passengerDAO.save(passenger);
    }

    public void deletePassenger(Passenger passenger) {
        passengerDAO.delete(passenger);
    }
}
