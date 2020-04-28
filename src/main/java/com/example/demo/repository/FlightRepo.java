package com.example.demo.repository;

import com.example.demo.entitiy.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface FlightRepo extends JpaRepository<Flight, Long> {

    @Modifying
    @Query(value = "UPDATE FLIGHTS f SET available_seat = available_seat - 1 " +
            ", f.price =:price WHERE f.id =:id  ", nativeQuery = true)
    void updateAvailableSeat(@Param("id") long id, @Param("price") BigDecimal price);

}
