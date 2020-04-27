package com.example.demo.controller.model;

import com.example.demo.entitiy.Route;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FlightResponse {
    private String flightCode;
    private Route route;
    private BigDecimal price;
}
