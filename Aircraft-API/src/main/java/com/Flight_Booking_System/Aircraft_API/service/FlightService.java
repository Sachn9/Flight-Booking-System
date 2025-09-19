package com.Flight_Booking_System.Aircraft_API.service;

import com.Flight_Booking_System.Aircraft_API.connector.FlightApiConnector;
import com.Flight_Booking_System.Aircraft_API.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlightService {
    FlightApiConnector flightApiConnector;
    @Autowired
    public FlightService(FlightApiConnector flightApiConnector){
        this.flightApiConnector=flightApiConnector;
    }
    public List<Flight> getFlightDetails(List<UUID> flightId){
        List<Flight> flight=flightApiConnector.getFlightDetails(flightId);
        return flight;
    }
}
