package com.Airlines.Reservation.models;

import com.Airlines.Reservation.enums.FlightStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightID;

    @Column(nullable = false, length = 10)
    private String flightNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airlineID")
    private Airline airlineID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aircraftID")
    private Aircraft aircraftID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originAirportID")
    private Airport originAirportID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinationAirportID")
    private Airport destinationAirportID;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airline getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(Airline airlineID) {
        this.airlineID = airlineID;
    }

    public Aircraft getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(Aircraft aircraftID) {
        this.aircraftID = aircraftID;
    }

    public Airport getOriginAirportID() {
        return originAirportID;
    }

    public void setOriginAirportID(Airport originAirportID) {
        this.originAirportID = originAirportID;
    }

    public Airport getDestinationAirportID() {
        return destinationAirportID;
    }

    public void setDestinationAirportID(Airport destinationAirportID) {
        this.destinationAirportID = destinationAirportID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}
