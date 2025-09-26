package com.Flight_Booking_System.SubFlight.API.service;

import com.Flight_Booking_System.SubFlight.API.connector.DatabaseApiConnector;
import com.Flight_Booking_System.SubFlight.API.model.SubFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DatabaseService{
    DatabaseApiConnector databaseApiConnector;
    @Autowired
    public DatabaseService(DatabaseApiConnector databaseApiConnector){
        this.databaseApiConnector=databaseApiConnector;
    }
    public SubFlight createSubflight(SubFlight subFlight, UUID originId, UUID destinationId, UUID airlineId, UUID aircraftId,UUID flightId){
        SubFlight subFlight1=databaseApiConnector.createSubFlightEndPoint(subFlight,originId,destinationId,airlineId,aircraftId,flightId);
        return  subFlight1;
    }
}
