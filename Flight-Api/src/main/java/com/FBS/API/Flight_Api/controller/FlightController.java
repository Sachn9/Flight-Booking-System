package com.FBS.API.Flight_Api.controller;

import com.FBS.API.Flight_Api.dto.FlightDetailsDto;
import com.FBS.API.Flight_Api.models.Flight;
import com.FBS.API.Flight_Api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {
    FlightService flightService;
    @Autowired
    public FlightController(FlightService flightService){
        this.flightService=flightService;
    }

    @PostMapping("/create")
    public ResponseEntity createFlight(@RequestBody FlightDetailsDto flightDetailsDto){
        Flight flightDetailsDto1=flightService.createFlight(flightDetailsDto);

    }
}
