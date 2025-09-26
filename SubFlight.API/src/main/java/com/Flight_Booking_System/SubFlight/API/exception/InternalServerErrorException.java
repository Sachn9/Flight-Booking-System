package com.Flight_Booking_System.SubFlight.API.exception;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException(String message){
        super(message);
    }
}
