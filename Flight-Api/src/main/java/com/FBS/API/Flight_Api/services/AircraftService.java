package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.AircraftConnector;
import com.FBS.API.Flight_Api.exception.AircraftNotFoundException;
import com.FBS.API.Flight_Api.exception.AirlineNotFoundException;
import com.FBS.API.Flight_Api.models.Aircraft;
import com.FBS.API.Flight_Api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AircraftService {

    AircraftConnector aircraftConnector;
    @Autowired
    public AircraftService(AircraftConnector aircraftConnector){
        this.aircraftConnector=aircraftConnector;
    }

    public Aircraft getAircraftById(UUID aircraftId){
        Aircraft aircraft=aircraftConnector.getAircraftEndPoint(aircraftId);
        if (aircraft == null) {
            throw new AircraftNotFoundException("Airline with ID " + aircraftId + " not found.");
        }
        return aircraft;
    }

}
