package com.Flight_Booking_System.SubFlight.API.model;

import com.Flight_Booking_System.SubFlight.API.enums.SeatClass;
import com.Flight_Booking_System.SubFlight.API.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {
    private UUID seatId;

    private String seatNumber;

    private SeatClass seatClass;

    private String seatType;

    private Fare fare;

    private SeatStatus seatStatus;

    private Flight flight;

}