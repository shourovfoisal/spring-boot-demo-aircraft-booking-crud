package com.shourovfoisal.assesment.dto.aircraft;

import com.shourovfoisal.assesment.dto.BaseDTO;

public class AircraftDTO extends BaseDTO {

    private String name;
    private AircraftTypeDTO aircraftType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AircraftTypeDTO getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftTypeDTO aircraftType) {
        this.aircraftType = aircraftType;
    }
}
