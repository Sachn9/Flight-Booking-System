package com.Flight_Booking_System.SubFlight.API.connector;

import com.Flight_Booking_System.SubFlight.API.model.SubFlight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class DatabaseApiConnector {
    @Value("${database.api.url}")
    String databaseApiUrl;

    public SubFlight createSubFlightEndPoint(SubFlight subflight, UUID originId, UUID destinationId, UUID airlineId, UUID aircraftId,UUID flightId){
        String url=databaseApiUrl +"/subflight/create/" + originId + "/" + destinationId + "/" + airlineId + "/" + aircraftId + "/" + flightId;

        RequestEntity<SubFlight> requestEntity= RequestEntity.post(url).body(subflight);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity< SubFlight> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity, SubFlight.class);

        return responseEntity.getBody();
    }
}
