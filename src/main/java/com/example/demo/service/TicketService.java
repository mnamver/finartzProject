package com.example.demo.service;

import com.example.demo.controller.model.PurchasableTicketReq;
import com.example.demo.controller.model.TicketResponse;
import com.example.demo.entitiy.Flight;
import com.example.demo.entitiy.PurchasedTicket;
import com.example.demo.entitiy.Route;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.FlightRepo;
import com.example.demo.repository.PurchasedTicketRepo;
import com.example.demo.repository.RouteRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class TicketService {

    private final PurchasedTicketRepo purchasedTicketRepo;
    private final FlightRepo flightRepo;
    private final RouteRepo routeRepo;

    private static final String TICKET_NOT_FOUND = "Bilet Bulunamadı.";
    private static final String FLIGHT_NOT_FOUND = "Uçuş Bulunamadı.";

    @Transactional
    public void purchaseTicket(PurchasableTicketReq purchasableTicketReq) {
        if (!flightRepo.existsById(purchasableTicketReq.getFlightId())) {
            throw new ValidationException(FLIGHT_NOT_FOUND);
        }
        Flight flight = flightRepo.findById(purchasableTicketReq.getFlightId()).get();

        PurchasedTicket purchasedTicket = PurchasedTicket.builder()
                .name(purchasableTicketReq.getName())
                .surname(purchasableTicketReq.getSurname())
                .createdDate(System.currentTimeMillis())
                .flightId(purchasableTicketReq.getFlightId())
                .price(flight.getPrice())
                .tckn(purchasableTicketReq.getTckn()).build();

        purchasedTicketRepo.save(purchasedTicket);
        flightRepo.updateAvailableSeat(purchasableTicketReq.getFlightId());
    }

    public void removeTicketId(long ticketId) {
        if (!purchasedTicketRepo.existsById(ticketId)) {
            throw new ValidationException(TICKET_NOT_FOUND);
        }
        purchasedTicketRepo.deleteById(ticketId);
    }

    public TicketResponse findTicket(long ticketId) {
        if (!purchasedTicketRepo.existsById(ticketId)) {
            throw new ValidationException(TICKET_NOT_FOUND);
        }
        PurchasedTicket purchasedTicket = purchasedTicketRepo.findById(ticketId).get();
        Flight flight = flightRepo.findById(purchasedTicket.getFlightId()).get();
        Route route = routeRepo.findByRouteCode(flight.getRouteCode()).get();

        return TicketResponse.builder()
                .price(flight.getPrice())
                .ticketId(purchasedTicket.getId())
                .createdDate(purchasedTicket.getCreatedDate())
                .name(purchasedTicket.getName())
                .surname(purchasedTicket.getSurname())
                .tckn(purchasedTicket.getTckn())
                .route(route).build();
    }


}
