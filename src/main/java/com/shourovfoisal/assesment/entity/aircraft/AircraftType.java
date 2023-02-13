package com.shourovfoisal.assesment.entity.aircraft;

import com.shourovfoisal.assesment.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "aircraft_type")
public class AircraftType extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
