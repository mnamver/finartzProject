package com.example.demo.repository;

import com.example.demo.entitiy.PurchasedTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedTicketRepo extends JpaRepository<PurchasedTicket, Long> {

}
