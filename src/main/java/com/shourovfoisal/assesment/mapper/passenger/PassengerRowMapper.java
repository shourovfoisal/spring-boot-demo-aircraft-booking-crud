package com.shourovfoisal.assesment.mapper.passenger;

import com.shourovfoisal.assesment.dto.gender.GenderDTO;
import com.shourovfoisal.assesment.dto.passenger.PassengerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerRowMapper implements RowMapper<PassengerDTO> {
    public PassengerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        PassengerDTO entity = new PassengerDTO();
        entity.setId(rs.getInt("p.id"));
        entity.setName(rs.getString("p.name"));
        entity.setAge(rs.getInt("p.age"));

        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setId(rs.getInt("g.id"));
        genderDTO.setName(rs.getString("g.name"));
        entity.setGender(genderDTO);

        return entity;
    }
}
