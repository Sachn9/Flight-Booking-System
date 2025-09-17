package com.FBS.API.Flight_Api.controller;

import com.FBS.API.Flight_Api.dto.FlightRequestDto;
import com.FBS.API.Flight_Api.models.Flight;
import com.FBS.API.Flight_Api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {
    FlightService flightService;
    @Autowired
    public FlightController(FlightService flightService){
        this.flightService=flightService;
    }

    @PostMapping("/create")
    public ResponseEntity createFlight(@RequestBody FlightRequestDto flightRequestDto){
        Flight flightDetailsDto1=flightService.createFlight(flightRequestDto);

    }
}
