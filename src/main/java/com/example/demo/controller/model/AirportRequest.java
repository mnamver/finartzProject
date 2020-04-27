package com.example.demo.controller.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class AirportRequest {

    @NotEmpty(message = "name may not be empty")
    private String name;

    @NotEmpty(message = "name may not be empty")
    private String phone;

    @NotEmpty(message = "name may not be empty")
    private String city;

    @NotEmpty(message = "name may not be empty")
    private String address;
}
