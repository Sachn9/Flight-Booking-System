package com.Flight_Booking_System.SubFlight.API.dto;

import com.Flight_Booking_System.SubFlight.API.enums.SubFlightStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubFlightCreateResponseDto {
    private UUID subFlightId;

    private String originAirportCode;
    private String destinationAirportCode;

    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private double durationInHours;

    private SubFlightStatus status;   // e.g. SCHEDULED, DELAYED, CANCELLED

    private String aircraftModel;     // e.g. Airbus A320, Boeing 737
    private int totalSeats;
    private int availableSeats;
}

