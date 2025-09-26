package com.Flight_Booking_System.SubFlight.API.exception;

public class AircraftNotFoundException extends RuntimeException{
    public AircraftNotFoundException(String message){
        super(message);
    }

}
