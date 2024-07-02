package com.Airlines.Reservation.models;

import jakarta.persistence.*;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineID;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 2,name="iata_Code")
    private String iataCode;

    @Column(nullable = false, length = 3,name="icao_Code")
    private String icaoCode;

    @Column(length = 50)
    private String callsign;

    public Long getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(Long airlineID) {
        this.airlineID = airlineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }
}

