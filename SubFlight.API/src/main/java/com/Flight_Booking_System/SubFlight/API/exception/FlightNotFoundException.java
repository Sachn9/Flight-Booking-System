package com.Flight_Booking_System.SubFlight.API.exception;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String message){
        super(message);
    }
}
