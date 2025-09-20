package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.SubFlightApiConnector;
import com.FBS.API.Flight_Api.models.SubFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubFlightService {
    SubFlightApiConnector subFlightApiConnector;
    @Autowired
    public SubFlightService(SubFlightApiConnector subFlightApiConnector){
        this.subFlightApiConnector=subFlightApiConnector;
    }
    public List<SubFlight> getAllSubFlight(){
        List<SubFlight> subFlights=subFlightApiConnector.getAllSubFlights();
        return subFlights;
    }
}
