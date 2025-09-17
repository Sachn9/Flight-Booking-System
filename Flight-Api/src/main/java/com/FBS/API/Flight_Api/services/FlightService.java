package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.dto.FlightRequestDto;
import com.FBS.API.Flight_Api.dto.FlightResponseDto;
import com.FBS.API.Flight_Api.models.*;
import com.FBS.API.Flight_Api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightService {

    AirlineService airlineService;
    MappingUtility mappingUtility;
    AircraftService aircraftService;
    AirPortService airPortService;
    DataBaseService dataBaseService;
    @Autowired
    public FlightService(AirlineService airlineService,
                         MappingUtility mappingUtility,
                         AircraftService aircraftService,
                         AirPortService airPortService,
                         DataBaseService dataBaseService){
        this.airlineService=airlineService;
        this.mappingUtility=mappingUtility;
        this.aircraftService=aircraftService;
        this.airPortService=airPortService;
        this.dataBaseService=dataBaseService;
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
        flight=dataBaseService.createFlight(flight);
    }
}
