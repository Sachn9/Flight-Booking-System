package com.FBS.API.Flight_Api.connector;

import com.FBS.API.Flight_Api.models.Airline;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class AirLineApiConnector {

    @Value("${airline.api.url}")
    String airlineApiUrl;

    public Airline getAirlineDetails(UUID airlineId) {
        //create url
        String url = airlineApiUrl + "/airlines/getAirline?airlineId=" + airlineId;

        //call api
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Airline> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Airline.class
        );

        return responseEntity.getBody();


    }
}

