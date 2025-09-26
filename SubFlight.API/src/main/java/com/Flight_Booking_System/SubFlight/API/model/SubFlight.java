package com.Flight_Booking_System.SubFlight.API.model;

import com.Flight_Booking_System.SubFlight.API.enums.SubFlightStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubFlight {
    private UUID subFlightId;

    private Airport originAirport;
    private Airport destinationAirport;

    private ZonedDateTime departure;
    private ZonedDateTime arrival;

    private double durationInHours;

    private SubFlightStatus status; // Enum: SCHEDULED, DELAYED, CANCELLED, COMPLETED

    private Flight flight; // Reference to main Flight

    private Aircraft aircraft;

    private Airline airline;

    private List<Seat> seats;

    private List<Booking> bookings;

    private List<FeedBack> feedbacks;

    private List<WaitList> waitlists;

    private List<PriceConfiguration> pricingConfigurations;
}
