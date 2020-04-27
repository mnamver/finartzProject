package com.example.demo.controller.model;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class PurchasableTicketReq {

    @NotNull(message = "Name may not be null")
    private long flightId;

    private String name;
    private String surname;
    private String tckn;

}
