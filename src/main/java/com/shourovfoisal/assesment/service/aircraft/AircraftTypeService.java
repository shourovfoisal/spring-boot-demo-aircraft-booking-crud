package com.shourovfoisal.assesment.service.aircraft;

import com.shourovfoisal.assesment.dao.aircraft.AircraftTypeDAO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import com.shourovfoisal.assesment.entity.aircraft.AircraftType;
import com.shourovfoisal.assesment.mapper.aircraft.AircraftRowMapper;
import com.shourovfoisal.assesment.mapper.aircraft.AircraftTypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AircraftTypeService {

    @Autowired
    private AircraftTypeDAO aircraftTypeDAO;

    @Autowired
    private JdbcTemplate template;

    public void createAircraftType(AircraftType payload) {
        payload.setCreatedTime(LocalDateTime.now());
        aircraftTypeDAO.save(payload);
    }

    public List<AircraftTypeDTO> getAircraftTypeList(String query, Object[] parameters, int[] argTypes) {
        return this.template.query(query, parameters, argTypes, new AircraftTypeRowMapper());
    }
}
