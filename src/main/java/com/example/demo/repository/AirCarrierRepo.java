package com.example.demo.repository;

import com.example.demo.entitiy.AirCarrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirCarrierRepo extends JpaRepository<AirCarrier, Long> {
    List<AirCarrier> findAll();
}
