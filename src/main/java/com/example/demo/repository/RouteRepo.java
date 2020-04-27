package com.example.demo.repository;

import com.example.demo.entitiy.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepo extends JpaRepository<Route, Long> {
    Optional<Route> findByRouteCode(String routeCode);

    boolean existsByRouteCode(String routeCode);
}
