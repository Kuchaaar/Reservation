package com.Airlines.Reservation.models;

import com.Airlines.Reservation.enums.SeatClass;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatID;


    @Column(nullable = false, length = 5)
    private String seatNumber;

    @Column(nullable = false, length = 20)
    private SeatClass seatClass;

    @Column(nullable = false)
    private Boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "reservationID")
    private Reservation reservation;

    public Boolean getAvailable(){
        return isAvailable;
    }

    public void setAvailable(Boolean available){
        isAvailable = available;
    }

    public Reservation getReservation(){
        return reservation;
    }

    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }

    public Long getSeatID() {
        return seatID;
    }

    public void setSeatID(Long seatID) {
        this.seatID = seatID;
    }


    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

