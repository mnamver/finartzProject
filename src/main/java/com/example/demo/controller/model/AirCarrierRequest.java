package com.example.demo.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AirCarrierRequest {

    @NotEmpty(message = "name may not be empty")
    private String name;

    @NotEmpty(message = "name may not be empty")
    private String phone;

    private int numberOfDestinations;
    private int numberOfAircraft;
}
