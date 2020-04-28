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

import java.math.BigDecimal;

@Service
@Slf4j
@AllArgsConstructor
public class TicketService {

    private final PurchasedTicketRepo purchasedTicketRepo;
    private final FlightRepo flightRepo;
    private final RouteRepo routeRepo;

    private static final String TICKET_NOT_FOUND = "Bilet Bulunamadı.";
    private static final String FLIGHT_NOT_FOUND = "Uçuş Bulunamadı.";
    private static final String TICKET_SOLD_OUT= "Bilet Tükenmiştir.";

    @Transactional
    public void purchaseTicket(PurchasableTicketReq purchasableTicketReq) {
        if (!flightRepo.existsById(purchasableTicketReq.getFlightId())) {
            throw new ValidationException(FLIGHT_NOT_FOUND);
        }
        Flight flight = flightRepo.findById(purchasableTicketReq.getFlightId()).get();

        if(flight.getAvailableSeat() == 0){
            throw new ValidationException(TICKET_SOLD_OUT);
        }

        PurchasedTicket purchasedTicket = PurchasedTicket.builder()
                .name(purchasableTicketReq.getName())
                .surname(purchasableTicketReq.getSurname())
                .createdDate(System.currentTimeMillis())
                .flightId(purchasableTicketReq.getFlightId())
                .price(flight.getPrice())
                .tckn(purchasableTicketReq.getTckn()).build();

        purchasedTicketRepo.save(purchasedTicket);
        int availableSeat = flight.getAvailableSeat() - 1 ;
        BigDecimal price = calculatePrice(availableSeat, flight.getTotalSeat(), flight.getPrice());
        flightRepo.updateAvailableSeat(purchasableTicketReq.getFlightId(), price);
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


    public BigDecimal calculatePrice(int availableSeat, int totalSeat, BigDecimal price){
        int purchasedSeat = totalSeat - availableSeat;

        BigDecimal newPrice = price.add(price.multiply(new BigDecimal(0.1)));

        if(purchasedSeat >= totalSeat * 0.1 && purchasedSeat < totalSeat * 0.2){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.2 && purchasedSeat < totalSeat * 0.3){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.3 && purchasedSeat < totalSeat * 0.4){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.4 && purchasedSeat < totalSeat * 0.5){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.5 && purchasedSeat < totalSeat * 0.6){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.6 && purchasedSeat < totalSeat * 0.7){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.7 && purchasedSeat < totalSeat * 0.8){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.8 && purchasedSeat < totalSeat * 0.9){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.9){
            return newPrice;
        }else{
            return price ;
        }
    }


}
