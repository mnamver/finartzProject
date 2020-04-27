package com.example.demo.controller;


import com.example.demo.controller.model.AirCarrierRequest;
import com.example.demo.controller.model.AirCarrierResponse;
import com.example.demo.entitiy.AirCarrier;
import com.example.demo.service.AirCarrierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/air-carrier")
@RestController
@AllArgsConstructor
@Slf4j
public class AirCarrierController {

    private final AirCarrierService airCarrierService;

    @GetMapping()
    public ResponseEntity<List<AirCarrierResponse>> getAll() {
        return ResponseEntity.ok(airCarrierService.getAllAirCarrierInfo());
    }

    @GetMapping("/id")
    public ResponseEntity<AirCarrier> getById(@RequestParam(value = "id") long id){
        return ResponseEntity.ok(airCarrierService.getAirCarrierInfo(id));
    }

    @PostMapping()
    public ResponseEntity createAirCarrier(@RequestBody @Valid AirCarrierRequest airCarrierRequest){
        airCarrierService.createAirCarrier(airCarrierRequest);
        return ResponseEntity.ok().build();
    }

}
