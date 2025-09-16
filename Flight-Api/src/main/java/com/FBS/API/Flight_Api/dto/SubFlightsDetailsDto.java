package com.FBS.API.Flight_Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubFlightsDetailsDto {
    private UUID subFlightId;
    private UUID originAirportId;
    private UUID destinationAirportId;
    private String departure;
    private String arrival;
}