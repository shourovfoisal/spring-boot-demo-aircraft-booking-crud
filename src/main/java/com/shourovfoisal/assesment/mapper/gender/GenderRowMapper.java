package com.shourovfoisal.assesment.mapper.gender;

import com.shourovfoisal.assesment.dto.gender.GenderDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderRowMapper implements RowMapper<GenderDTO> {

    public GenderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        GenderDTO entity = new GenderDTO();
        entity.setId(rs.getInt("g.id"));
        entity.setName(rs.getString("g.name"));
        return entity;
    }
}
