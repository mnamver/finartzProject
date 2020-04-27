package com.example.demo.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "flight_code")
    private String flightCode;

    @Column(name = "route_code")
    private String routeCode;

    @Column(name = "available_seat")
    private int availableSeat;

    @Column(name = "total_seat")
    private int totalSeat;

    @Column(name = "price")
    private BigDecimal price;



}
