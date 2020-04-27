package com.example.demo.controller;

import com.example.demo.controller.model.AirportRequest;
import com.example.demo.entitiy.Airport;
import com.example.demo.service.AirportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/airport")
@RestController
@AllArgsConstructor
@Slf4j
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/id")
    public ResponseEntity<Airport> getById(@RequestParam(value = "id") long id) throws Exception {
        return ResponseEntity.ok(airportService.getAirportInfo(id));
    }

    @PostMapping()
    public ResponseEntity createAirCarrier(@RequestBody @Valid AirportRequest airportRequest){
        airportService.createAirport(airportRequest);
        return ResponseEntity.ok().build();
    }
}
