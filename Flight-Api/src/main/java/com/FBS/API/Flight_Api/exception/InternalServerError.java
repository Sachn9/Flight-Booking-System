package com.FBS.API.Flight_Api.exception;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String message) {
        super(message);
    }
}
