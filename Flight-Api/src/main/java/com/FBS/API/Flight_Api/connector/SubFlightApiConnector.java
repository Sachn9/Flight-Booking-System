package com.FBS.API.Flight_Api.connector;

import com.FBS.API.Flight_Api.models.Flight;
import com.FBS.API.Flight_Api.models.SubFlight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SubFlightApiConnector{
    @Value("${subFlight.api.url}")
    String subFlightApiUrl;
    public List<SubFlight> getAllSubFlights(){
        String url=subFlightApiUrl + "/all";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<SubFlight>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SubFlight>>() {}
        );

        return responseEntity.getBody();

    }
}
