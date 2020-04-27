package com.example.demo.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteRequest {

    @NotEmpty(message = "name may not be empty")
    private String routeCode;

    @NotEmpty(message = "name may not be empty")
    private String departure;

    @NotEmpty(message = "name may not be empty")
    private String destination;

    @NotNull
    private Date departureDate;

    @NotNull
    private Date arrivalDate;

    private String distance;

}
