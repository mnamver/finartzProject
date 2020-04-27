package com.example.demo.service;


import com.example.demo.controller.model.AirportRequest;
import com.example.demo.entitiy.Airport;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AirportRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class AirportService {

    public static String AIRPORT_NOT_FOUND = "havalimanı bulunamadı!.";

    private final AirportRepo airportRepo;

    public Airport getAirportInfo(long id) throws Exception {
        return airportRepo.findById(id).filter(airport -> Objects.nonNull(airport))
                .orElseThrow(() -> new ValidationException(AIRPORT_NOT_FOUND));
    }

    public void createAirport(AirportRequest airportRequest){
        Airport airport = Airport.builder()
                .name(airportRequest.getName())
                .phone(airportRequest.getPhone())
                .city(airportRequest.getCity())
                .address(airportRequest.getAddress())
                .build();

        airportRepo.save(airport);
    }
}
