package com.Flight_Booking_System.SubFlight.API.connector;

import com.Flight_Booking_System.SubFlight.API.model.Airport;
import com.Flight_Booking_System.SubFlight.API.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class FlightApiConnector {
    @Value("${flight.api.url}")
    String flightApiUrl;

    public Flight getFlightEndPoint(UUID flightId){
        String url=flightApiUrl +"/get" + flightId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Flight> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,Flight.class);
        return responseEntity.getBody();
    }
}
