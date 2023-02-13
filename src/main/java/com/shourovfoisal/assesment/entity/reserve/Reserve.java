package com.shourovfoisal.assesment.entity.reserve;

import com.shourovfoisal.assesment.entity.BaseEntity;
import com.shourovfoisal.assesment.entity.aircraft.Aircraft;
import com.shourovfoisal.assesment.entity.passenger.Passenger;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reserve")
public class Reserve extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Column(name = "date_of_fly")
    private LocalDate dateOfFly;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
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
