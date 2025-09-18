package com.FBS.API.Flight_Api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequestDto {
    private String flightName;
    private UUID originAirportId;
    private UUID destinationAirportId;
    private ZonedDateTime departure;
    private ZonedDateTime arrival;
    private String status;
    private UUID airlineId;
    private UUID aircraftId;
}
