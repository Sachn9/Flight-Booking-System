package com.Flight_Booking_System.SubFlight.API.dto;

import com.Flight_Booking_System.SubFlight.API.model.Airline;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubFlightCreateRequestDto {
    private UUID originAirportId;
    private UUID destinationAirportId;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private UUID airlineId;
    private UUID aircraftId;
    private UUID flightId;
}
