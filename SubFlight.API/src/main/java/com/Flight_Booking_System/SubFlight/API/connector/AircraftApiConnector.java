package com.Flight_Booking_System.SubFlight.API.connector;

import com.Flight_Booking_System.SubFlight.API.model.Aircraft;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class AircraftApiConnector{
    @Value("${aircraft.api.url}")
    String aircraftUrl;

    public Aircraft getAircraftEndPoint(UUID aircraftId){
        String url= aircraftUrl +"/get/aircraftById" + aircraftId;

        //call api
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Aircraft> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Aircraft.class
        );

        return responseEntity.getBody();

    }
}
