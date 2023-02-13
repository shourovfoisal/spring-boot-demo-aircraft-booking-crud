package com.shourovfoisal.assesment.entity.passenger;

import com.shourovfoisal.assesment.entity.BaseEntity;
import com.shourovfoisal.assesment.entity.gender.Gender;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passenger")
public class Passenger extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
