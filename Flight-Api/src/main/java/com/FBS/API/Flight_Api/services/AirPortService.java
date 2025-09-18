package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.AirportApiConnector;
import com.FBS.API.Flight_Api.exception.AirlineNotFoundException;
import com.FBS.API.Flight_Api.exception.AirportNotFoundException;
import com.FBS.API.Flight_Api.models.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirPortService {

    AirportApiConnector airportApiConnector;
    @Autowired
    public AirPortService(AirportApiConnector airportApiConnector){
        this.airportApiConnector=airportApiConnector;
    }
    public Airport getAirportById(UUID airportId){
        Airport airport=airportApiConnector.getAirportEndPoint(airportId);

        if (airport == null) {
            throw new AirportNotFoundException("Airline with ID " + airportId + " not found.");
        }
        return airport;
    }
}
