package com.Flight_Booking_System.SubFlight.API.utility;

import com.Flight_Booking_System.SubFlight.API.dto.SubFlightCreateRequestDto;
import com.Flight_Booking_System.SubFlight.API.dto.SubFlightCreateResponseDto;
import com.Flight_Booking_System.SubFlight.API.enums.SubFlightStatus;
import com.Flight_Booking_System.SubFlight.API.model.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZonedDateTime;

@Component
public class MappingUtility{
    public SubFlight mapSubFlightToSubflightRequestDto(SubFlightCreateRequestDto subFlightCreateRequestDto,
                                                       Airport originAirport, Airport destinationAirport,
                                                       Aircraft aircraft, Flight flight, Airline airline){

        ZonedDateTime dep=subFlightCreateRequestDto.getDepartureTime();
        ZonedDateTime arr=subFlightCreateRequestDto.getArrivalTime();
        double durationInHours = Duration.between(dep, arr).toMinutes() / 60.0;

        SubFlight subFlight=SubFlight.builder()
                .originAirport(originAirport)
                .destinationAirport(destinationAirport)
                .departure(dep)//It can wrong I will fix after;
                .arrival(arr)
                .durationInHours(durationInHours)
                .status(SubFlightStatus.SCHEDULED)
                .flight(flight)
                .aircraft(aircraft)
                .airline(airline)
                .build();
        return subFlight;

    }

    //map SubFlightCreateResponseDto

    public SubFlightCreateResponseDto mapSubFlightToSubFlightCreateResponseDto(SubFlight subFlight){
        SubFlightCreateResponseDto subFlightCreateResponseDto=SubFlightCreateResponseDto.builder()
                .subFlightId(subFlight.getSubFlightId())
                .originAirportCode(subFlight.getOriginAirport().getAirportCode())
                .destinationAirportCode(subFlight.getDestinationAirport().getAirportCode())
                .arrivalTime(subFlight.getArrival())
                .departureTime(subFlight.getDeparture())
                .durationInHours(subFlight.getDurationInHours())
                .status(subFlight.getStatus())
                .aircraftModel(subFlight.getAircraft().getAircraftNumber())
                .totalSeats(subFlight.getAircraft().getCapacity())
                .availableSeats(subFlight.getSeats().hashCode())
                .build();
        return subFlightCreateResponseDto;

    }
}
