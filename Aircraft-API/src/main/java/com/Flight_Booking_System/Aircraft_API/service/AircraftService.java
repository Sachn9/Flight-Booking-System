package com.Flight_Booking_System.Aircraft_API.service;

import com.Flight_Booking_System.Aircraft_API.connector.DataBaseApiConnector;
import com.Flight_Booking_System.Aircraft_API.dto.AircraftDetailsDTO;
import com.Flight_Booking_System.Aircraft_API.exception.AirLineNotFoundException;
import com.Flight_Booking_System.Aircraft_API.exception.AircraftDoesNotExist;
import com.Flight_Booking_System.Aircraft_API.exception.InvalidOperationException;
import com.Flight_Booking_System.Aircraft_API.model.Aircraft;
import com.Flight_Booking_System.Aircraft_API.model.Airline;
import com.Flight_Booking_System.Aircraft_API.model.Flight;
import com.Flight_Booking_System.Aircraft_API.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AircraftService {

    MappingUtility mappingUtility;
    DataBaseApiConnector dataBaseApiConnector;
    DataBaseService dataBaseService;
    AirlineService airlineService;
    FlightService flightService;
    @Autowired
    public AircraftService(MappingUtility mappingUtility,
                           DataBaseApiConnector dataBaseApiConnector,
                           DataBaseService dataBaseService,
                           AirlineService airlineService,
                           FlightService flightService){
        this.mappingUtility=mappingUtility;
        this.dataBaseApiConnector=dataBaseApiConnector;
        this.dataBaseService=dataBaseService;
        this.airlineService=airlineService;
        this.flightService=flightService;
    }

    public Aircraft airCraftRegistration(AircraftDetailsDTO aircraftDetailsDTO, UUID airlineId, List<UUID> flightId){
        Airline airline=airlineService.getAirlineDetails(airlineId);
        if(airline==null){
            throw new AirLineNotFoundException("Airline with ID " + airlineId + " not found.");
        }

        List<Flight> flights=flightService.getFlightDetails(flightId);
        if(flights==null || flights.isEmpty()){
            throw new InvalidOperationException("No Flights found in the database");
        }

        Aircraft aircraft=mappingUtility.mapAircraftToAircraftDetailsDTO(aircraftDetailsDTO, airline,flights);
        return dataBaseApiConnector.callGetCreateAirCraftEndPoint(aircraft);

    }

    public Aircraft getAirCraftsById(UUID aircraftId){
        Aircraft aircraft=dataBaseApiConnector.callGetAirCraftById(aircraftId);
        if(aircraft ==  null){
            throw new InvalidOperationException(String.format("Aircraft Id does not exist in database",aircraftId.toString()));
        }
        return aircraft;
    }

    public List<Aircraft> getAllAirCrafts() {
        List<Aircraft> aircraftList = dataBaseApiConnector.callGetAllAirCraftsEndPoint();

        if (aircraftList == null || aircraftList.isEmpty()) {
            throw new InvalidOperationException("No AirCrafts found in the database");
        }

        return aircraftList;
    }

    //Update aircraft
    public Aircraft updateAircraft(UUID aircraftId,AircraftDetailsDTO aircraftDetailsDTO){
        Aircraft aircraft=dataBaseService.getAircraft(aircraftId);
        if(aircraft==null){
            throw new AircraftDoesNotExist(String.format("Aircraft Id does not exist in database",aircraftId.toString()));
        }
        List<Flight> flights=aircraft.getFlights();
        if(flights==null || flights.isEmpty()){
            throw new InvalidOperationException("No Flights found in the database");
        }
        Airline airline=aircraft.getAirline();
        aircraft=mappingUtility.mapAircraftToAircraftDetailsDTO(aircraftDetailsDTO,airline,flights);
        aircraft=dataBaseService.updateAircraft(aircraft.getAircraftId(),aircraft);
        return aircraft;
    }

    //get all flights in an aircraft
    public List<Flight> getAllFlightsInAnAircraft(UUID aircraftId){
        Aircraft aircraft=this.getAirCraftsById(aircraftId);
        List<Flight> flights=aircraft.getFlights();
        return flights;
    }
}
