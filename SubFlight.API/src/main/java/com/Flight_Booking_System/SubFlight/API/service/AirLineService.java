package com.Flight_Booking_System.SubFlight.API.service;

import com.Flight_Booking_System.SubFlight.API.connector.AirlineApiConnector;
import com.Flight_Booking_System.SubFlight.API.exception.AirlineNotFoundException;
import com.Flight_Booking_System.SubFlight.API.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirLineService {
    AirlineApiConnector airlineApiConnector;
    @Autowired
    public AirLineService(AirlineApiConnector airlineApiConnector){
        this.airlineApiConnector=airlineApiConnector;
    }

    public Airline getAirlineById(UUID airlineId){
        Airline airline=airlineApiConnector.getAirlineDetails(airlineId);
        if (airline == null) {
            throw new AirlineNotFoundException("Airline with ID " + airlineId + " not found.");
        }
        return airline;
    }
}
