package com.example.demo.entitiy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "air_carrier")
@NoArgsConstructor
@AllArgsConstructor
public class AirCarrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "number_of_destination")
    private int numberOfDestination;

    @Column(name = "number_of_aircraft")
    private int numberOfAircraft;

}
