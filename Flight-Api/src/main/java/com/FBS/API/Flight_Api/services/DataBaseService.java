package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.DatabaseApiConnector;
import com.FBS.API.Flight_Api.exception.FlightNotFoundException;
import com.FBS.API.Flight_Api.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DataBaseService {
    DatabaseApiConnector databaseApiConnector;
    @Autowired
    public DataBaseService(DatabaseApiConnector databaseApiConnector){
        this.databaseApiConnector=databaseApiConnector;
    }

    public Flight createFlight(Flight flight, UUID originId, UUID destinationId, UUID airlineId, UUID aircraftId){

        return databaseApiConnector.createFlightEndPoint(flight,originId,destinationId,airlineId,aircraftId);
    }


    public Flight getFlightById(UUID flightId){
        Flight flight=databaseApiConnector.getFlightById(flightId);
        if(flight==null){
            throw new FlightNotFoundException("Flight with id" + flightId + "Not found");
        }else{
            return flight;
        }
    }

    public List<Flight> getAllFlights(){
        List<Flight> flights=databaseApiConnector.getAllFlights();
        if(flights == null){
            throw new FlightNotFoundException(("Flights Not Found"));
        }else {
            return flights;
        }

    }

    public Flight flightUpdatedById(Flight flight,UUID flightId){
        return databaseApiConnector.updateFlightEndPoint(flight,flightId);
    }


    //delete flight
    public void deleteFlight(Flight flight){
        databaseApiConnector.deleteFlight(flight.getFlightId());
    }
}
