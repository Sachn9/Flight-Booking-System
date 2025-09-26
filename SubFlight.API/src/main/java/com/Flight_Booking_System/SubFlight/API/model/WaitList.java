package com.Flight_Booking_System.SubFlight.API.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaitList {
    private UUID waitlistId;

    private Integer position;
    private String status;

    private Customer customer;

    private Flight flight;
}