package com.shourovfoisal.assesment.entity.aircraft;

import com.shourovfoisal.assesment.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aircraft")
public class Aircraft extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "aircraft_type_id")
    private AircraftType aircraftType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }
}
