package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.dto.FlightRequestDto;
import com.FBS.API.Flight_Api.exception.FlightNotFoundException;
import com.FBS.API.Flight_Api.models.*;
import com.FBS.API.Flight_Api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {

    AirlineService airlineService;
    MappingUtility mappingUtility;
    AircraftService aircraftService;
    AirPortService airPortService;
    DataBaseService dataBaseService;
    SubFlightService subFlightService;

    @Autowired
    public FlightService(AirlineService airlineService,
                         MappingUtility mappingUtility,
                         AircraftService aircraftService,
                         AirPortService airPortService,
                         DataBaseService dataBaseService,
                         SubFlightService subFlightService){
        this.airlineService=airlineService;
        this.mappingUtility=mappingUtility;
        this.aircraftService=aircraftService;
        this.airPortService=airPortService;
        this.dataBaseService=dataBaseService;
        this.subFlightService=subFlightService;
    }

    public Flight createFlight(FlightRequestDto flightRequestDto){


        /**
         * Get originAirPort and destinationAirport in the database
         * call the AirportService
         */
        Airport originAirport=airPortService.getAirportById(flightRequestDto.getOriginAirportId());
        Airport destinationAirport=airPortService.getAirportById(flightRequestDto.getDestinationAirportId());

        //get to airline by airlineId
        Airline airline=airlineService.getAirLineById(flightRequestDto.getAirlineId());

        //get aircraft by aircraftId
        Aircraft aircraft=aircraftService.getAircraftById(flightRequestDto.getAircraftId());


        Flight flight=mappingUtility.mapFlightRequestToFlight(flightRequestDto,originAirport,destinationAirport,airline,aircraft);
        flight=dataBaseService.createFlight(flight,
                flightRequestDto.getOriginAirportId(),
                flightRequestDto.getDestinationAirportId(),
                flightRequestDto.getAirlineId(),
                flightRequestDto.getAircraftId());
        return flight;
    }


    //Get flight
    public Flight getFlightById(UUID flightId){
        Flight flight=dataBaseService.getFlightById(flightId);
        return flight;
    }

    //Get all flight
    public List<Flight> getAllFlights(){
        List<Flight> flights=dataBaseService.getAllFlights();
        return flights;
    }

    //update flight
    public Flight updateFlightById(FlightRequestDto flightRequestDto,UUID flightId){
        Flight flight=dataBaseService.getFlightById(flightId);
        if(flight==null){
            throw new FlightNotFoundException("Flight with id" + flightId + "Not found");
        }

        /**
         * Get originAirPort and destinationAirport in the database
         * call the AirportService
         */
        Airport originAirport=airPortService.getAirportById(flightRequestDto.getOriginAirportId());
        Airport destinationAirport=airPortService.getAirportById(flightRequestDto.getDestinationAirportId());

        //get to airline by airlineId
        Airline airline=airlineService.getAirLineById(flightRequestDto.getAirlineId());

        //get aircraft by aircraftId
        Aircraft aircraft=aircraftService.getAircraftById(flightRequestDto.getAircraftId());

        flight=mappingUtility.mapFlightRequestToFlight(flightRequestDto,originAirport,destinationAirport,airline,aircraft);

        /**
         * Add the SubFlight inside the flight
         */

        List<SubFlight> matchFlight=new ArrayList<>();
        List<SubFlight> subFlights=subFlightService.getAllSubFlight();
        for(SubFlight subFlight:subFlights){
            if (flight.getFlightId().equals(subFlight.getFlight().getFlightId())){
                matchFlight.add(subFlight);
            }
        }

        flight.setSubFlights(matchFlight);



        flight=dataBaseService.flightUpdatedById(flight,flight.getFlightId());
        return flight;

    }

    //delete Flight
    public void deleteFlight(UUID flightId){
        Flight flight=dataBaseService.getFlightById(flightId);
        if(flight==null){
            throw new FlightNotFoundException("Flight with id" + flightId + "Not found");
        }
        dataBaseService.deleteFlight(flight);
    }

}
