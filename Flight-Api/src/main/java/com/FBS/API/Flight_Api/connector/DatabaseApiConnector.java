package com.FBS.API.Flight_Api.connector;

import com.FBS.API.Flight_Api.models.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
public class DatabaseApiConnector {
    @Value("${database.api.url}")
    String databaseApiUrl;

    public Flight createFlightEndPoint(Flight flight, UUID originId, UUID destinationId, UUID airlineId, UUID aircraftId){
        String url=databaseApiUrl +"/flight/create/" + originId + "/" + destinationId + "/" + airlineId + "/" + aircraftId;
        RequestEntity<Flight> requestEntity= RequestEntity.post(url).body(flight);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity< Flight> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity, Flight.class);

        return responseEntity.getBody();
    }

    public Flight getFlightById(UUID flightId){
        String url = databaseApiUrl + "/flight/" + flightId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Flight> response = restTemplate.exchange(url,HttpMethod.GET,null,Flight.class);
        return response.getBody();
    }

    public List<Flight> getAllFlights(){
        // Create URL
        String url = databaseApiUrl + "/all";

        // Call API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Flight>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Flight>>() {}
        );

        return responseEntity.getBody();
    }

    //Update flight
    public Flight updateFlightEndPoint(Flight flight,UUID flightId){
        String url = databaseApiUrl + "/flight/" + flightId;
        RequestEntity<Flight> request = RequestEntity.put(url).body(flight);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Flight> response = restTemplate.exchange(url, HttpMethod.PUT, request, Flight.class);
        return response.getBody();
    }

    //Delete flight
    public void deleteFlight(UUID flightId){
        String url = databaseApiUrl + "/flight/" + flightId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
    }
}
