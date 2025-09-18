package com.FBS.API.Flight_Api.exception;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String message){
        super(message);
    }
}
