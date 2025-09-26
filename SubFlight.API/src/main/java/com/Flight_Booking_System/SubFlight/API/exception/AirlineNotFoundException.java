package com.Flight_Booking_System.SubFlight.API.exception;

public class AirlineNotFoundException extends RuntimeException {
    public AirlineNotFoundException(String message) {
        super(message);
    }
}
