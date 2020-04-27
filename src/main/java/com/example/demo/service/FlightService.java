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


        BigDecimal price = calculatePrice(flight.getAvailableSeat(), flight.getTotalSeat(), flight.getPrice());

        FlightResponse flightResponse = FlightResponse.builder()
                .route(route)
                .flightCode(flight.getFlightCode())
                .price(price)
                .build();

        return flightResponse;
    }

    public BigDecimal calculatePrice(int availableSeat, int totalSeat, BigDecimal price){
        int purchasedSeat = totalSeat - availableSeat;
        if(purchasedSeat < totalSeat * 0.1 ){
            return price;
        }else if(purchasedSeat < totalSeat * 0.2){
            price = price.add(price.multiply(new BigDecimal(0.1))) ;
            return price ;
        }else if(purchasedSeat < totalSeat * 0.3){
            price = price.add(price.multiply(new BigDecimal(0.2))) ;
            return price ;
        }else if(purchasedSeat < totalSeat * 0.4){
            price = price.add(price.multiply(new BigDecimal(0.3))) ;
            return price ;
        }else if(purchasedSeat < totalSeat * 0.5){
            price = price.add(price.multiply(new BigDecimal(0.4))) ;
            return price ;
        }else{
            price = price.add(price.multiply(new BigDecimal(0.5))) ;
            return price ;
        }
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
