package com.example.demo.controller;

import com.example.demo.controller.model.RouteRequest;
import com.example.demo.entitiy.Route;
import com.example.demo.service.RouteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/route")
@RestController
@AllArgsConstructor
@Slf4j
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/route-code")
    public ResponseEntity<Route> getRouteByRouteCode(@RequestParam(value = "routeCode") String routeCode) throws Exception {
        return ResponseEntity.ok(routeService.getRouteInfo(routeCode));
    }

    @PostMapping()
    public ResponseEntity createRoute(@RequestBody RouteRequest routeRequest){
        routeService.createRoute(routeRequest);
        return ResponseEntity.ok().build();
    }
}
