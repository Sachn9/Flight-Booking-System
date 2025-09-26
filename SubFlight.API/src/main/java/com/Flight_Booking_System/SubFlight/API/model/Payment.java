package com.Flight_Booking_System.SubFlight.API.model;

import com.Flight_Booking_System.SubFlight.API.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    private UUID paymentId;

    private Double amount;
    private String method;

    private PaymentStatus paymentStatus;

    private String txnReference;

    private Booking booking;

}

