package com.example.demo.controller.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AirCarrierResponse {

    private long id;
    private String name;
    private String phone;
    private int numberOfDestinations;
    private int numberOfAircraft;

}
