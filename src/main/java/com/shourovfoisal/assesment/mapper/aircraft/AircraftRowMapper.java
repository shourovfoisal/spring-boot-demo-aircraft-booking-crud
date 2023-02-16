package com.shourovfoisal.assesment.mapper.aircraft;

import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AircraftRowMapper implements RowMapper<AircraftDTO> {
    public AircraftDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AircraftDTO entity = new AircraftDTO();
        entity.setId(rs.getInt("a.id"));
        entity.setName(rs.getString("a.name"));

        AircraftTypeDTO aircraftType = new AircraftTypeDTO();
        aircraftType.setId(rs.getInt("at.id"));
        aircraftType.setName(rs.getString("at.name"));
        entity.setAircraftType(aircraftType);

        return entity;
    }
}
