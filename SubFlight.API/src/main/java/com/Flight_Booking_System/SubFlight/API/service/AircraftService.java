package com.Flight_Booking_System.SubFlight.API.service;

import com.Flight_Booking_System.SubFlight.API.connector.AircraftApiConnector;
import com.Flight_Booking_System.SubFlight.API.connector.AirportApiConnector;
import com.Flight_Booking_System.SubFlight.API.exception.AircraftNotFoundException;
import com.Flight_Booking_System.SubFlight.API.model.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AircraftService {
    AircraftApiConnector aircraftApiConnector;
    @Autowired
    public AircraftService(AircraftApiConnector aircraftApiConnector){
        this.aircraftApiConnector=aircraftApiConnector;
    }
    public Aircraft getAircraftById(UUID aircraftId){
        Aircraft aircraft=aircraftApiConnector.getAircraftEndPoint(aircraftId);

        if(aircraft==null){
            throw new AircraftNotFoundException("Airline with ID " + aircraftId + " not found.");
        }
        return aircraft;
    }
}
