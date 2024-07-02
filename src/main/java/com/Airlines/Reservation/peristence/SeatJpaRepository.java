package com.Airlines.Reservation.peristence;

import com.Airlines.Reservation.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatJpaRepository extends JpaRepository<Seat, Long>{
    List<Seat> findByReservation_FlightID_FlightIDAndIsAvailableTrue(Long id);
}