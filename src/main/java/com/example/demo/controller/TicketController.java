package com.example.demo.controller;

import com.example.demo.controller.model.PurchasableTicketReq;
import com.example.demo.controller.model.TicketResponse;
import com.example.demo.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ticket")
@RestController
@AllArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    @PostMapping()
    public ResponseEntity purchaseTicket(@RequestBody PurchasableTicketReq purchasableTicketReq){
        ticketService.purchaseTicket(purchasableTicketReq);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity removeTicket(@RequestParam(value = "ticketId") long ticketId){
        ticketService.removeTicketId(ticketId);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<TicketResponse> findTicket(@RequestParam(value = "ticketId") long ticketId){
        return ResponseEntity.ok(ticketService.findTicket(ticketId));
    }

}
