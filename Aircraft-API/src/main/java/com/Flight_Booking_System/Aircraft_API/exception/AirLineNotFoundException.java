package com.Flight_Booking_System.Aircraft_API.exception;

public class AirLineNotFoundException extends RuntimeException {
    public AirLineNotFoundException(String message) {
        super(message);
    }
}
