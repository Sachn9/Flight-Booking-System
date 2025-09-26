package com.Flight_Booking_System.SubFlight.API.service;

import com.Flight_Booking_System.SubFlight.API.connector.FlightApiConnector;
import com.Flight_Booking_System.SubFlight.API.exception.FlightNotFoundException;
import com.Flight_Booking_System.SubFlight.API.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightService {
    FlightApiConnector flightApiConnector;
    @Autowired
    public FlightService(FlightApiConnector flightApiConnector){
        this.flightApiConnector=flightApiConnector;
    }

    public Flight getFlightByID(UUID flightId){
        Flight flight=flightApiConnector.getFlightEndPoint(flightId);
        if(flight==null){
            throw new FlightNotFoundException("Flight with ID " + flightId + " not found.");
        }
        return flight;
    }
}
