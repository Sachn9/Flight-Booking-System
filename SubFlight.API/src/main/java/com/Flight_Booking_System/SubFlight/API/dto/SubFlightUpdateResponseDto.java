package com.Flight_Booking_System.SubFlight.API.dto;

import com.Flight_Booking_System.SubFlight.API.enums.SubFlightStatus;
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
public class SubFlightUpdateResponseDto {
    private UUID subFlightId;

    private String originAirportCode;     // Origin Airport Code (DEL, DXB, JFK etc.)
    private String destinationAirportCode;

    private ZonedDateTime departure;
    private ZonedDateTime arrival;

    private double durationInHours;

    private SubFlightStatus status;

    private String aircraftModel;         // Aircraft detail (Boeing 777, Airbus A320)

    private int totalSeats;               // Total seats in this subflight
    private int availableSeats;           // How many seats are free

    private double baseFare;              // Starting fare (Economy class min price)
}