package com.shourovfoisal.assesment.manager.gender;

import com.shourovfoisal.assesment.component.QueryBuilder;
import com.shourovfoisal.assesment.dto.gender.GenderDTO;
import com.shourovfoisal.assesment.entity.gender.Gender;
import com.shourovfoisal.assesment.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class GenderManager {

    @Autowired
    private GenderService genderService;

    @Autowired
    private QueryBuilder queryBuilder;

    public void createGender(Gender payload) {
        genderService.createGender(payload);
    }

    public List<GenderDTO> getGenderList() {

        String conditions = "";
        List<Object> args = new LinkedList<>();
        List<Integer> argTypes = new LinkedList<>();

        String query = queryBuilder.getQueryParamOfGender(conditions);

        return genderService.getGenderList(query, args.toArray(), argTypes.stream().mapToInt(i -> i).toArray());
    }
}
