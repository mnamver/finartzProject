package com.example.demo.service;

import com.example.demo.controller.model.AirCarrierRequest;
import com.example.demo.controller.model.AirCarrierResponse;
import com.example.demo.entitiy.AirCarrier;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AirCarrierRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class AirCarrierService {

    public static String AIR_CARRIER_NOT_FOUND = "Hava yolu şirketi bulunamadı.";

    private final AirCarrierRepo airCarrierRepo;

    public List<AirCarrierResponse> getAllAirCarrierInfo() {
        List<AirCarrier> airCarriers = airCarrierRepo.findAll();

        return airCarriers.stream().map(airCarrier -> AirCarrierResponse.builder()
                .id(airCarrier.getId())
                .name(airCarrier.getName())
                .numberOfAircraft(airCarrier.getNumberOfAircraft())
                .numberOfDestinations(airCarrier.getNumberOfDestination())
                .phone(airCarrier.getPhone())
                .build()).collect(Collectors.toList());

    }

    public AirCarrier getAirCarrierInfo(long id){
        return airCarrierRepo.findById(id).filter(airCarrier -> Objects.nonNull(airCarrier))
                .orElseThrow(() -> new ValidationException(AIR_CARRIER_NOT_FOUND));
    }

    public void createAirCarrier(AirCarrierRequest airCarrierRequest){

        AirCarrier airCarrier = AirCarrier.builder()
                .name(airCarrierRequest.getName())
                .numberOfAircraft(airCarrierRequest.getNumberOfAircraft())
                .numberOfDestination(airCarrierRequest.getNumberOfDestinations())
                .phone(airCarrierRequest.getPhone())
                .build();

        airCarrierRepo.save(airCarrier);
    }
}
