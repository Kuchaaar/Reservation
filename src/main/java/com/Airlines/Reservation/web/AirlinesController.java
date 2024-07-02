package com.Airlines.Reservation.web;

import com.Airlines.Reservation.domain.AirlinesService;
import com.Airlines.Reservation.models.Airport;
import com.Airlines.Reservation.models.Flight;
import com.Airlines.Reservation.models.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class AirlinesController{
    private final AirlinesService airlinesService;

    public AirlinesController(AirlinesService airlinesService){
        this.airlinesService = airlinesService;
    }
//    @GetMapping("/available")
//    public List<Seat> getAvailableSeats(@RequestParam String origin,
//                                        @RequestParam String destination,
//                                        @RequestParam String departureTime) {
//        LocalDateTime departure = LocalDateTime.parse(departureTime);
//        return airlinesService.getAvailableSeats(origin, destination, departure);
//    }
    @GetMapping("/all")
    public List<Seat> getAllSeats() {
        return airlinesService.getAll();
    }
    @GetMapping("/flightId")
    public List<Seat> getAllByFlightId(@RequestParam Long id){
        return airlinesService.getByFlightID(id);
    }
    @PostMapping("/v1/flights/client")
    public List<Flight> getAllFlightByAirportsAndTime(@RequestBody Airport originAirportID,
                                                      Airport destinationAirportID,
                                                      LocalDateTime departureTimeStart,
                                                      LocalDateTime departureTimeEnd){
        System.out.println(originAirportID);
        return airlinesService.getFlightForDateAndAirports(originAirportID,destinationAirportID,departureTimeStart,departureTimeEnd);
    }



}
