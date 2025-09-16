package com.FBS.API.Flight_Api.utility;

import com.FBS.API.Flight_Api.dto.FlightDetailsDto;
import com.FBS.API.Flight_Api.dto.SubFlightsDetailsDto;
import com.FBS.API.Flight_Api.models.Airline;
import com.FBS.API.Flight_Api.models.Flight;
import com.FBS.API.Flight_Api.models.SubFlight;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingUtility {

    public Flight mappingFlightModelToFlightDetailsDto(FlightDetailsDto flightDetailsDto,
                                                       Airline airline){
        Flight flight=Flight.builder()
                .flightName(flightDetailsDto.getFlightName())
                .status(flightDetailsDto.getStatus())
                .airline(airline)
                .subFlights(null)
                .build();
        return flight;

    }




}
