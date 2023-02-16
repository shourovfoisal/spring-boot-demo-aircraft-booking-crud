package com.shourovfoisal.assesment.service.aircraft;

import com.shourovfoisal.assesment.dao.aircraft.AircraftDAO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.mapper.AircraftRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AircraftService {

    private static final Logger logger = LoggerFactory.getLogger(AircraftService.class);

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private AircraftDAO aircraftDAO;

    public Aircraft createAircraft(Aircraft payload) {
        payload.setCreatedTime(LocalDateTime.now());
        return aircraftDAO.save(payload);
    }

    public List<AircraftDTO> getAircraftList(String query, Object[] parameters, int[] argTypes) {
        List<AircraftDTO> aircraftList = this.template.query(query, parameters, argTypes, new AircraftRowMapper());
        return aircraftList;
    }

    public Aircraft updateAircraft(Aircraft aircraft) {
        aircraft.setUpdatedTime(LocalDateTime.now());
        return aircraftDAO.save(aircraft);
    }

    public void deleteAircraft(Aircraft aircraft) {
        aircraftDAO.delete(aircraft);
    }
}