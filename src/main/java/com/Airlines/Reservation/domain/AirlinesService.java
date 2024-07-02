package com.Airlines.Reservation.domain;

import com.Airlines.Reservation.models.Airport;
import com.Airlines.Reservation.models.Flight;
import com.Airlines.Reservation.models.Seat;
import com.Airlines.Reservation.peristence.FlightJpaRepository;
import com.Airlines.Reservation.peristence.SeatJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AirlinesService{
    private final SeatJpaRepository seatJpaRepository;
    private final FlightJpaRepository flightJpaRepository;

    public AirlinesService(SeatJpaRepository seatJpaRepository, FlightJpaRepository flightJpaRepository){
        this.seatJpaRepository = seatJpaRepository;
        this.flightJpaRepository = flightJpaRepository;
    }
    
    public List<Seat> getAll(){
        return seatJpaRepository.findAll();
    }

    public List<Seat> getByFlightID(Long id){
        return seatJpaRepository.findByReservation_FlightID_FlightIDAndIsAvailableTrue(id);
    }

    public List<Flight> getFlightForDateAndAirports(Airport originAirportID,
                                                    Airport destinationAirportID,
                                                    LocalDateTime departureTimeStart,
                                                    LocalDateTime departureTimeEnd){
        return flightJpaRepository.findByOriginAirportIDAndDestinationAirportIDAndDepartureTimeBetween(
                originAirportID,
                destinationAirportID,
                departureTimeStart,
                departureTimeEnd);
    }
}
