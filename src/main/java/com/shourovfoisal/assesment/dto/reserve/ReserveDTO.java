package com.shourovfoisal.assesment.dto.reserve;

import com.shourovfoisal.assesment.dto.BaseDTO;
import com.shourovfoisal.assesment.dto.aircraft.AircraftDTO;
import com.shourovfoisal.assesment.dto.passenger.PassengerDTO;

import java.time.LocalDate;

public class ReserveDTO extends BaseDTO {

    private AircraftDTO aircraft;
    private PassengerDTO passenger;
    private LocalDate dateOfFly;
    private String source;
    private String destination;

    public AircraftDTO getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftDTO aircraft) {
        this.aircraft = aircraft;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    public LocalDate getDateOfFly() {
        return dateOfFly;
    }

    public void setDateOfFly(LocalDate dateOfFly) {
        this.dateOfFly = dateOfFly;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
