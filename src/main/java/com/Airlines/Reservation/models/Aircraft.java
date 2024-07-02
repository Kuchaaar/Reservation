package com.Airlines.Reservation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Aircraft{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftID;

    @Column(nullable = false, length = 100)
    private String model;

    @Column(nullable = false, length = 100)
    private String manufacturer;

    @Column(nullable = false)
    private Integer seatingCapacity;

    @Column(nullable = false)
    private Integer flyRange;

    @Column(nullable = false, length = 50)
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "airlineID")
    private Airline airlineID;

    public Long getAircraftID(){
        return aircraftID;
    }

    public void setAircraftID(Long aircraftID){
        this.aircraftID = aircraftID;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public Integer getSeatingCapacity(){
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity){
        this.seatingCapacity = seatingCapacity;
    }

    public Integer getFlyRange(){
        return flyRange;
    }

    public void setFlyRange(Integer flyRange){
        this.flyRange = flyRange;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public Airline getAirlineID(){
        return airlineID;
    }

    public void setAirlineID(Airline airlineID){
        this.airlineID = airlineID;
    }
}

