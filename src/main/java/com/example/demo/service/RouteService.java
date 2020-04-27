package com.example.demo.service;

import com.example.demo.controller.model.RouteRequest;
import com.example.demo.entitiy.Route;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.RouteRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@AllArgsConstructor
public class RouteService {

    public static final String ROUTE_CODE_ALREADY_EXIST = "Rota kodu sistemde mevcut";
    private final RouteRepo routeRepo;

    public Route getRouteInfo(String routeCode) throws Exception {
        return routeRepo.findByRouteCode(routeCode).filter(route -> Objects.nonNull(route))
                .orElseThrow(() -> new Exception());
    }

    public void createRoute(RouteRequest routeRequest){
       if(routeRepo.existsByRouteCode(routeRequest.getRouteCode())){
           throw new ValidationException(ROUTE_CODE_ALREADY_EXIST);
       }

        Route route = Route.builder()
                .routeCode(routeRequest.getRouteCode())
                .destination(routeRequest.getDestination())
                .departure(routeRequest.getDistance())
                .distance(routeRequest.getDistance())
                .departureDate(routeRequest.getDepartureDate())
                .arrivalDate(routeRequest.getArrivalDate())
                .build();

        routeRepo.save(route);
    }

    public static Long localDateToEpochMilli(LocalDate localDate) {
        return TimeUnit.DAYS.toMillis(localDate.toEpochDay());
    }
}
