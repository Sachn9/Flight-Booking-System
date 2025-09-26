package com.Flight_Booking_System.SubFlight.API.exception;

public class AirPortNotFoundException extends RuntimeException{
    public AirPortNotFoundException(String message) {
        super(message);
    }
}
