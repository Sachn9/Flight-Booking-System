package com.Flight_Booking_System.SubFlight.API.controller;

import com.Flight_Booking_System.SubFlight.API.dto.SubFlightCreateRequestDto;
import com.Flight_Booking_System.SubFlight.API.dto.SubFlightCreateResponseDto;
import com.Flight_Booking_System.SubFlight.API.exception.InternalServerErrorException;
import com.Flight_Booking_System.SubFlight.API.exception.InvalidOperationException;
import com.Flight_Booking_System.SubFlight.API.model.SubFlight;
import com.Flight_Booking_System.SubFlight.API.service.SubFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subflight")
public class SubFlightController {

    SubFlightService subFlightService;
    @Autowired
    public SubFlightController(SubFlightService subFlightService){
        this.subFlightService=subFlightService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createSubFlight(@RequestBody SubFlightCreateRequestDto subFlightRequestDto) {
        try {
            SubFlightCreateResponseDto subFlightCreateResponseDto = subFlightService.createSubFlight(subFlightRequestDto);
            return new ResponseEntity<>(subFlightCreateResponseDto, HttpStatus.CREATED);
        } catch (InternalServerErrorException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
