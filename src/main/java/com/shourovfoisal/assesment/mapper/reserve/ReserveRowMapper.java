package com.shourovfoisal.assesment.mapper.reserve;

import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import com.shourovfoisal.assesment.dto.gender.GenderDTO;
import com.shourovfoisal.assesment.dto.passenger.PassengerDTO;
import com.shourovfoisal.assesment.dto.reserve.ReserveDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReserveRowMapper implements RowMapper<ReserveDTO> {

    public ReserveDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReserveDTO entity = new ReserveDTO();
        entity.setId(rs.getInt("r.id"));
        entity.setDateOfFly(rs.getDate("r.date_of_fly").toLocalDate());
        entity.setSource(rs.getString("r.source"));
        entity.setDestination(rs.getString("r.destination"));

        AircraftDTO aircraftDTO = new AircraftDTO();
        aircraftDTO.setId(rs.getInt("a.id"));
        aircraftDTO.setName(rs.getString("a.name"));

        AircraftTypeDTO aircraftTypeDTO = new AircraftTypeDTO();
        aircraftTypeDTO.setId(rs.getInt("at.id"));
        aircraftTypeDTO.setName(rs.getString("at.name"));
        aircraftDTO.setAircraftType(aircraftTypeDTO);

        entity.setAircraft(aircraftDTO);

        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(rs.getInt("p.id"));
        passengerDTO.setAge(rs.getInt("p.age"));
        passengerDTO.setName(rs.getString("p.name"));

        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setId(rs.getInt("g.id"));
        genderDTO.setName(rs.getString("g.name"));
        passengerDTO.setGender(genderDTO);

        entity.setPassenger(passengerDTO);

        return entity;
    }
}
