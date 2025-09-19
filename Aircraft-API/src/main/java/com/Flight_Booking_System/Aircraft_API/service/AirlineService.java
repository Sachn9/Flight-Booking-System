package com.Flight_Booking_System.Aircraft_API.service;

import com.Flight_Booking_System.Aircraft_API.connector.AirLineApiConnector;
import com.Flight_Booking_System.Aircraft_API.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirlineService{
    AirLineApiConnector airLineApiConnector;
    @Autowired
    public AirlineService(AirLineApiConnector airLineApiConnector){
        this.airLineApiConnector=airLineApiConnector;
    }
    public Airline getAirlineDetails(UUID airlineId){
        Airline airline=airLineApiConnector.getAirlineDetails(airlineId);
        return airline;
    }
}
