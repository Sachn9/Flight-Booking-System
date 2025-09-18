package com.FBS.API.Flight_Api.controller;

import com.FBS.API.Flight_Api.dto.FlightRequestDto;
import com.FBS.API.Flight_Api.exception.FlightNotFoundException;
import com.FBS.API.Flight_Api.exception.InternalServerError;
import com.FBS.API.Flight_Api.models.Flight;
import com.FBS.API.Flight_Api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {
    FlightService flightService;
    @Autowired
    public FlightController(FlightService flightService){
        this.flightService=flightService;
    }

    //create flight
    @PostMapping("/create")
    public ResponseEntity createFlight(@RequestBody FlightRequestDto flightRequestDto){
        try{
            Flight flight=flightService.createFlight(flightRequestDto);
            return new ResponseEntity<>(flight,HttpStatus.CREATED);
        }catch(InternalServerError e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    /**
     * Get flight base on the flight id
     *
     */
    @GetMapping("/{flightId}")
    public ResponseEntity getFlightById(@PathVariable UUID flightId){
        try {
            Flight flight = flightService.getFlightById(flightId);
            return new ResponseEntity<>(flight,HttpStatus.OK);
        }catch (FlightNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get all Flight
     */
    @GetMapping("/all")
    public ResponseEntity getAllFlights(){
        try {
            List<Flight> flights = flightService.getAllFlights();
            return new ResponseEntity<>(flights,HttpStatus.OK);
        }catch (FlightNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * if we do update a particular Flight
     * Then we need flightId and DetailsDto
     */

    @PutMapping("/{flightId}")
    public ResponseEntity updateFlightById(@RequestBody FlightRequestDto flightRequestDto,
                                           @PathVariable UUID flightId){
        try{
            Flight flight=flightService.updateFlightById( flightRequestDto,flightId);
            return new ResponseEntity<>(flight,HttpStatus.OK);
        }catch (InternalServerError e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * If we delete flight
     * Then we will do  delete flight bases on the flightId
     */
    @DeleteMapping("/flightId")
    public void deleteFlightById(@PathVariable UUID flightId){
        flightService.deleteFlight(flightId);
    }





}
