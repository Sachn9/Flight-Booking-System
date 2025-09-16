package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.dto.FlightDetailsDto;
import com.FBS.API.Flight_Api.dto.SubFlightsDetailsDto;
import com.FBS.API.Flight_Api.models.Aircraft;
import com.FBS.API.Flight_Api.models.Airline;
import com.FBS.API.Flight_Api.models.Flight;
import com.FBS.API.Flight_Api.models.SubFlight;
import com.FBS.API.Flight_Api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.MappedByteBuffer;
import java.util.List;

@Service
public class FlightService {

    AirlineService airlineService;
    MappingUtility mappingUtility;
    @Autowired
    public FlightService(AirlineService airlineService,
                         MappingUtility mappingUtility){
        this.airlineService=airlineService;
        this.mappingUtility=mappingUtility;
    }

    public Flight createFlight(FlightDetailsDto flightDetailsDto){

        //get to airline by airlineId
        Airline airline=airlineService.getAirLineById(flightDetailsDto.getAirlineId());
        Flight flight=mappingUtility.mappingFlightModelToFlightDetailsDto(flightDetailsDto,airline);
        //get aircraft for in airline





    }
}
