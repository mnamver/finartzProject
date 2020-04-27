package com.example.demo.controller;

import com.example.demo.entitiy.AirCarrier;
import com.example.demo.service.AirCarrierService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AirCarrierController.class)
public class AirCarrierTest {

    @MockBean
    private AirCarrierService airCarrierService;

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new Gson();

    @Test
    public void whenGetByIdRequested_thenReturnAirCarrierResponse() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/air-carrier/id")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        AirCarrier airCarrier =AirCarrier.builder().id(1L)
                .name("pegasus")
                .numberOfDestination(1234)
                .numberOfAircraft(12)
                .phone("7869").build();
        given(airCarrierService.getAirCarrierInfo(1L)).willReturn(airCarrier);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(airCarrier)));
    }
}
