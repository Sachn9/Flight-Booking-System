package com.Flight_Booking_System.SubFlight.API.service;

import com.Flight_Booking_System.SubFlight.API.connector.AirportApiConnector;
import com.Flight_Booking_System.SubFlight.API.exception.AirPortNotFoundException;
import com.Flight_Booking_System.SubFlight.API.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirportService {
    AirportApiConnector airportApiConnector;
    @Autowired
    public AirportService(AirportApiConnector airportApiConnector){
        this.airportApiConnector=airportApiConnector;
    }
    public Airport getAirportById(UUID airportId){
        Airport airport=airportApiConnector.getAirportEndPoint(airportId);

        if(airport==null){
            throw new AirPortNotFoundException("Airline with ID " + airportId + " not found.");
        }
        return airport;
    }
}
