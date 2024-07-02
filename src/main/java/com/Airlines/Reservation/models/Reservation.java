package com.Airlines.Reservation.models;

import com.Airlines.Reservation.enums.ReservationStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationID;

    @ManyToOne
    @JoinColumn(name = "passengerID")
    private Passenger passengerID;

    @ManyToOne
    @JoinColumn(name = "flightID")
    private Flight flightID;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }

    public Passenger getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Passenger passengerID) {
        this.passengerID = passengerID;
    }

    public Flight getFlightID() {
        return flightID;
    }

    public void setFlightID(Flight flightID) {
        this.flightID = flightID;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
