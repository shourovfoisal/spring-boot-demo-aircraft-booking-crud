package com.shourovfoisal.assesment.controller.gender;

import com.shourovfoisal.assesment.entity.gender.Gender;
import com.shourovfoisal.assesment.manager.gender.GenderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/genders")
public class GenderController {

    @Autowired
    private GenderManager genderManager;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public void createGender(@Validated @RequestBody Gender payload) {
        genderManager.createGender(payload);
    }

}
