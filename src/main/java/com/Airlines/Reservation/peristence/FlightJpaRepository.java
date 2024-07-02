package com.Airlines.Reservation.peristence;

import com.Airlines.Reservation.models.Airport;
import com.Airlines.Reservation.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightJpaRepository extends JpaRepository<Flight, Long>{
    List<Flight> findByOriginAirportIDAndDestinationAirportIDAndDepartureTimeBetween(Airport originAirportID,
                                                                                     Airport destinationAirportID,
                                                                                     LocalDateTime departureTimeStart,
                                                                                     LocalDateTime departureTimeEnd);
}
