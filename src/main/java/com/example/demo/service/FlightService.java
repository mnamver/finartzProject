package com.example.demo.service;

import com.example.demo.controller.model.FlightRequest;
import com.example.demo.controller.model.FlightResponse;
import com.example.demo.entitiy.Flight;
import com.example.demo.entitiy.Route;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.FlightRepo;
import com.example.demo.repository.RouteRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@AllArgsConstructor
public class FlightService {

    private final FlightRepo flightRepo;
    private final RouteRepo routeRepo;

    private static final String FLIGHT_NOT_FOUND = "Uçuş Bulunamadı.";

    public FlightResponse getFlightInfo(long flightId) throws Exception {

        if (!flightRepo.existsById(flightId)) {
            throw new ValidationException(FLIGHT_NOT_FOUND);
        }

        Flight flight = flightRepo.findById(flightId).get();
        Route route = routeRepo.findByRouteCode(flight.getRouteCode()).get();

        FlightResponse flightResponse = FlightResponse.builder()
                .route(route)
                .flightCode(flight.getFlightCode())
                .price(flight.getPrice())
                .build();

        return flightResponse;
    }


    public void createFlight(FlightRequest flightRequest) {
        Flight flight = Flight.builder()
                .flightCode(flightRequest.getFlightCode())
                .routeCode(flightRequest.getRouteCode())
                .availableSeat(flightRequest.getAvailableSeat())
                .totalSeat(flightRequest.getTotalSeat())
                .price(flightRequest.getPrice())
                .build();

        flightRepo.save(flight);
    }
}
