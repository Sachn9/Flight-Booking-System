package com.FBS.API.Flight_Api.utility;

import com.FBS.API.Flight_Api.dto.FlightRequestDto;
import com.FBS.API.Flight_Api.dto.FlightResponseDto;
import com.FBS.API.Flight_Api.enums.FlightStatus;
import com.FBS.API.Flight_Api.models.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.FBS.API.Flight_Api.enums.FlightStatus.SCHEDULED;

@Component
public class MappingUtility {

    /**
     * Maps FlightRequestDto to Flight entity
     */
    public Flight mapFlightRequestToFlight(FlightRequestDto dto,
                             Airport originAirport, 
                             Airport destinationAirport,
                             Airline airline,
                             Aircraft aircraft) {
        return Flight.builder()
                .flightName(dto.getFlightName())
                .originAirport(originAirport)
                .destinationAirport(destinationAirport)
                .departure(dto.getDeparture())
                .arrival(dto.getArrival())
                .status(SCHEDULED)
                .airline(airline)
                .aircraft(aircraft)
                .build();
    }


}
