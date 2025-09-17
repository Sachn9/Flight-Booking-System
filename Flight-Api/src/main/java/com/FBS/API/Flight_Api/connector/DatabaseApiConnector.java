package com.FBS.API.Flight_Api.connector;

import com.FBS.API.Flight_Api.models.Flight;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseApiConnector {
    @Value("${database.api.url}")
    String databaseApiUrl;

    public Flight createFlightEndPoint(Flight flight){
        String url=databaseApiUrl +"/create";
        RequestEntity requestEntity= RequestEntity.post(url).body(flight);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity< Flight> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity, Flight.class);

        return responseEntity.getBody();
    }
}
