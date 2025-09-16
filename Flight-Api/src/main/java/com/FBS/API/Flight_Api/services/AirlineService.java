package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.AirLineApiConnector;
import com.FBS.API.Flight_Api.exception.AirlineNotFoundException;
import com.FBS.API.Flight_Api.models.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AirlineService {

    AirLineApiConnector airLineApiConnector;
    @Autowired
    public AirlineService(AirLineApiConnector airLineApiConnector){
        this.airLineApiConnector=airLineApiConnector;
    }
    public Airline getAirLineById(UUID airlineId){
        Airline airline=airLineApiConnector.getAirlineDetails(airlineId);
        if (airline == null) {
            throw new AirlineNotFoundException("Airline with ID " + airlineId + " not found.");
        }
        return airline;

    }
}
