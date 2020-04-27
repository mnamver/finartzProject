package com.example.demo.controller.model;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Data
public class FlightRequest {

    @NotEmpty(message = "name may not be empty")
    private String flightCode;

    @NotEmpty(message = "name may not be empty")
    private String routeCode;

    @NotNull(message = "Name may not be null")
    private BigDecimal price;

    @NotNull(message = "Name may not be null")
    private int availableSeat;

    @NotNull(message = "Name may not be null")
    private int totalSeat;

}
