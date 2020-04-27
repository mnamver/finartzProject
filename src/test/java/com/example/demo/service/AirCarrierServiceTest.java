package com.example.demo.service;

import com.example.demo.controller.model.AirCarrierRequest;
import com.example.demo.entitiy.AirCarrier;
import com.example.demo.repository.AirCarrierRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AirCarrierServiceTest {

    private AirCarrierService airCarrierService;

    @Mock
    private AirCarrierRepo airCarrierRepo;


    @Before
    public void setUp() {
        airCarrierService = new AirCarrierService(airCarrierRepo);
    }

    @Test
    public void testGetAirCarrierInfo() {
        AirCarrier airCarrier = AirCarrier.builder().id(1L)
                .name("pegasus")
                .numberOfDestination(1234)
                .numberOfAircraft(12)
                .phone("7869").build();

        when(airCarrierRepo.findById(1L)).thenReturn(Optional.of(airCarrier));
        AirCarrier airc = airCarrierService.getAirCarrierInfo(1L);
        assertEquals(12,airc.getNumberOfAircraft());
        assertEquals("pegasus",airc.getName());
        assertEquals(1234,airc.getNumberOfDestination());

    }

    @Test
    public void testCreateAirCarrierInfo() {
        AirCarrierRequest airCarrierReq = AirCarrierRequest.builder()
                .name("pegasus")
                .numberOfDestinations(1500)
                .numberOfAircraft(120)
                .phone("7869").build();

        airCarrierService.createAirCarrier(airCarrierReq);

        AirCarrier airCarrier = AirCarrier.builder()
                .name("pegasus")
                .numberOfDestination(1500)
                .numberOfAircraft(120)
                .phone("7869").build();

        verify(airCarrierRepo, times(1)).save(airCarrier);

    }


}