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
@Table(name = "purchased_ticket")
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "flight_id")
    private long flightId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "created_date")
    private long createdDate;

}
