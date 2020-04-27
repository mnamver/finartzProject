package com.example.demo.repository;

import com.example.demo.entitiy.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Long> {

}
