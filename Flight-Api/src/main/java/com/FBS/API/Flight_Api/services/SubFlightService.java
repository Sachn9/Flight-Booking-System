package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.SubFlightApiConnector;
import com.FBS.API.Flight_Api.models.SubFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubFlightService {
    SubFlightApiConnector subFlightApiConnector;
    @Autowired
    public SubFlightService(SubFlightApiConnector subFlightApiConnector){
        this.subFlightApiConnector=subFlightApiConnector;
    }

    /**
     * Retrieves all subFlights for a specific flight ID
     * @param flightId The ID of the flight to get subFlights for
     * @return List of subFlights for the given flight ID, or empty list if none found
     */
    public List<SubFlight> getSubFlightsByFlightId(UUID flightId) {
        if (flightId == null) {
            return List.of();
        }
        
        List<SubFlight> allSubFlights = subFlightApiConnector.getAllSubFlights();
        if (allSubFlights == null) {
            return List.of();
        }
        
        return allSubFlights.stream()
                .filter(subFlight -> subFlight != null 
                    && subFlight.getFlight() != null 
                    && flightId.equals(subFlight.getFlight().getFlightId()))
                .collect(Collectors.toList());
    }
}
