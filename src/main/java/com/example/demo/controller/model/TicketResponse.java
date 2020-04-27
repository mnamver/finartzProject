package com.example.demo.controller.model;

import com.example.demo.entitiy.Route;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TicketResponse {
    private long ticketId;
    private String name;
    private String surname;
    private String tckn;
    private long createdDate;
    private BigDecimal price;
    private Route route;
}
