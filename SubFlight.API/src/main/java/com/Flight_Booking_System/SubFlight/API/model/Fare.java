package com.Flight_Booking_System.SubFlight.API.model;

import com.Flight_Booking_System.SubFlight.API.enums.SeatClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fare {
    private UUID fareId;

    private SeatClass seatClass;

    private Double basePrice;
    private Double tax;
    private String currency;

}
