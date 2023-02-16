package com.shourovfoisal.assesment.service.gender;

import com.shourovfoisal.assesment.dao.gender.GenderDAO;
import com.shourovfoisal.assesment.entity.gender.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GenderService {

    @Autowired
    private GenderDAO genderDAO;

    public void createGender(Gender payload) {
        payload.setCreatedTime(LocalDateTime.now());
        genderDAO.save(payload);
    }
}
