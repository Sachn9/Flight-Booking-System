package com.Flight_Booking_System.Aircraft_API.service;

import com.Flight_Booking_System.Aircraft_API.connector.DataBaseApiConnector;
import com.Flight_Booking_System.Aircraft_API.dto.AircraftDetailsDTO;
import com.Flight_Booking_System.Aircraft_API.model.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DataBaseService {
    DataBaseApiConnector dataBaseApiConnector;
    @Autowired
    public DataBaseService (DataBaseApiConnector dataBaseApiConnector){
        this.dataBaseApiConnector=dataBaseApiConnector;
    }
    public Aircraft getAircraft(UUID aircraftId){
        Aircraft aircraft=dataBaseApiConnector.callGetAirCraftById(aircraftId);
        return aircraft;
    }

    public Aircraft updateAircraft(UUID aircraftId,Aircraft aircraft){
        Aircraft aircraft1=dataBaseApiConnector.updateAircraftEndPoint(aircraftId,aircraft);
        return aircraft1;
    }
}
