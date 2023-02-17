package com.shourovfoisal.assesment.service.gender;

import com.shourovfoisal.assesment.dao.gender.GenderDAO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftTypeDTO;
import com.shourovfoisal.assesment.dto.gender.GenderDTO;
import com.shourovfoisal.assesment.entity.gender.Gender;
import com.shourovfoisal.assesment.mapper.aircraft.AircraftTypeRowMapper;
import com.shourovfoisal.assesment.mapper.gender.GenderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderDAO genderDAO;

    @Autowired
    private JdbcTemplate template;

    public void createGender(Gender payload) {
        payload.setCreatedTime(LocalDateTime.now());
        genderDAO.save(payload);
    }

    public List<GenderDTO> getGenderList(String query, Object[] parameters, int[] argTypes) {
        return this.template.query(query, parameters, argTypes, new GenderRowMapper());
    }
}
