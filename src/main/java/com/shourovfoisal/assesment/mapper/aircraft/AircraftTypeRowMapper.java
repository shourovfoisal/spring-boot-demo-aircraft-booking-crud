package com.shourovfoisal.assesment.mapper.aircraft;

import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AircraftTypeRowMapper implements RowMapper<AircraftTypeDTO> {

    public AircraftTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AircraftTypeDTO entity = new AircraftTypeDTO();
        entity.setId(rs.getInt("at.id"));
        entity.setName(rs.getString("at.name"));
        return entity;
    }
}
