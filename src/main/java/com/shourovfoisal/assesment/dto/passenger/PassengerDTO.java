package com.shourovfoisal.assesment.dto.passenger;

import com.shourovfoisal.assesment.dto.BaseDTO;
import com.shourovfoisal.assesment.dto.gender.GenderDTO;

public class PassengerDTO extends BaseDTO {

    private String name;
    private Integer age;
    private GenderDTO gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderDTO getGender() {
        return gender;
    }

    public void setGender(GenderDTO gender) {
        this.gender = gender;
    }
}
