package com.example.demo.controller;

import com.example.demo.controller.model.FlightRequest;
import com.example.demo.controller.model.FlightResponse;
import com.example.demo.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/flight")
@RestController
@AllArgsConstructor
@Slf4j
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/flight-id")
    public ResponseEntity<FlightResponse> getByFlightCode(@RequestParam(value = "flightId") long flightId) throws Exception {
        return ResponseEntity.ok(flightService.getFlightInfo(flightId));
    }

    @PostMapping()
    public ResponseEntity createFlight(@RequestBody FlightRequest flightRequest){
        flightService.createFlight(flightRequest);
        return ResponseEntity.ok().build();
    }
}
