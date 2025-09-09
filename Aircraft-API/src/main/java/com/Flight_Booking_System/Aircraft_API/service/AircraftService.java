package com.Flight_Booking_System.Aircraft_API.service;

import com.Flight_Booking_System.Aircraft_API.dto.AircraftDetailsDTO;
import com.Flight_Booking_System.Aircraft_API.model.Aircraft;
import com.Flight_Booking_System.Aircraft_API.model.Airline;
import com.Flight_Booking_System.Aircraft_API.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    MappingUtility mappingUtility;
    @Autowired
    public AircraftService(MappingUtility mappingUtility){
        this.mappingUtility=mappingUtility;
    }

    public Aircraft airCraftRegistration(AircraftDetailsDTO aircraftDetailsDTO){
        Aircraft aircraft=mappingUtility.mapAircraftToAircraftDetailsDTO(aircraftDetailsDTO, Airline.)
    }
}
