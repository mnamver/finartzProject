package com.example.demo.repository;

import com.example.demo.entitiy.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepo extends JpaRepository<Flight, Long> {

    @Modifying
    @Query(value = "UPDATE FLIGHTS f SET available_seat = available_seat - 1 WHERE f.id =:id  ", nativeQuery = true)
    void updateAvailableSeat(@Param("id") long id);

}
