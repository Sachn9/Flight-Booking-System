package com.Flight_Booking_System.SubFlight.API.service;

import com.Flight_Booking_System.SubFlight.API.dto.SubFlightCreateRequestDto;
import com.Flight_Booking_System.SubFlight.API.dto.SubFlightCreateResponseDto;
import com.Flight_Booking_System.SubFlight.API.model.*;
import com.Flight_Booking_System.SubFlight.API.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class SubFlightService {
    AirportService airportService;
    AircraftService aircraftService;
    FlightService flightService;
    AirLineService airLineService;
    SeatService seatService;
    MappingUtility mappingUtility;
    DatabaseService databaseService;
    @Autowired
    public SubFlightService(AirportService airportService,
                            AircraftService aircraftService,
                            FlightService flightService,
                            AirLineService airLineService,
                            SeatService seatService,
                            MappingUtility mappingUtility,
                            DatabaseService databaseService){
        this.airportService=airportService;
        this.aircraftService=aircraftService;
        this.flightService=flightService;
        this.airLineService=airLineService;
        this.seatService=seatService;
        this.mappingUtility=mappingUtility;
        this.databaseService=databaseService;

    }
    public SubFlightCreateResponseDto createSubFlight(SubFlightCreateRequestDto subFlightCreateRequestDto){

        /**
         * Get Airport by code
         */
        Airport originAirport=airportService.getAirportById(subFlightCreateRequestDto.getOriginAirportId());
        Airport destinationAirport=airportService.getAirportById(subFlightCreateRequestDto.getDestinationAirportId());

        /**
         * I need to aircraft So I fetch the aircraft in aircraft api
         */

        Aircraft aircraft=aircraftService.getAircraftById(subFlightCreateRequestDto.getAircraftId());

        /**
         * If I need to flight So I fetch the flight in flight api
         */
        Flight flight=flightService.getFlightByID(subFlightCreateRequestDto.getFlightId());

        /**
         * If I need to Airline
         * So I get airline in airline api by airlineID
         */

        Airline airline=airLineService.getAirlineById(subFlightCreateRequestDto.getAirlineId());

        SubFlight subFlight=mappingUtility.mapSubFlightToSubflightRequestDto(subFlightCreateRequestDto,originAirport,destinationAirport,aircraft,flight,airline);

        //call the dataBase Api
        subFlight=databaseService.createSubflight(subFlight,originAirport.getAirportId(),
                destinationAirport.getAirportId(),airline.getAirlineId(),aircraft.getAircraftId(),
                flight.getFlightId());
        /**
         * "I want to send a message to the admin
         * that a new subflight has been added to your portal."
         */
        

        //make the response Dto
         SubFlightCreateResponseDto subFlightCreateResponseDto=mappingUtility.mapSubFlightToSubFlightCreateResponseDto(subFlight);

        return subFlightCreateResponseDto;
    }
}
