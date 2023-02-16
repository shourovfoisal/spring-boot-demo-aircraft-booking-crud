package com.shourovfoisal.assesment.manager.gender;

import com.shourovfoisal.assesment.entity.gender.Gender;
import com.shourovfoisal.assesment.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenderManager {

    @Autowired
    private GenderService genderService;

    public void createGender(Gender payload) {
        genderService.createGender(payload);
    }

}
