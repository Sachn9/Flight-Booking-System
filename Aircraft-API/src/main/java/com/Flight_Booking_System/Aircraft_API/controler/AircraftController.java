package com.Flight_Booking_System.Aircraft_API.controler;

import com.Flight_Booking_System.Aircraft_API.connector.AirLineApiConnector;
import com.Flight_Booking_System.Aircraft_API.connector.FlightApiConnector;
import com.Flight_Booking_System.Aircraft_API.dto.AircraftDetailsDTO;
import com.Flight_Booking_System.Aircraft_API.exception.AircraftDoesNotExist;
import com.Flight_Booking_System.Aircraft_API.exception.InvalidOperationException;
import com.Flight_Booking_System.Aircraft_API.model.Aircraft;
import com.Flight_Booking_System.Aircraft_API.model.Airline;
import com.Flight_Booking_System.Aircraft_API.model.Flight;
import com.Flight_Booking_System.Aircraft_API.service.AircraftService;
import com.Flight_Booking_System.Aircraft_API.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/aircraft")
public class AircraftController {

    AircraftService aircraftService;
    @Autowired
    public AircraftController(AircraftService aircraftService){
        this.aircraftService=aircraftService;
    }

    /**
     * Create new aircraft
     * @param aircraftDetailsDTO
     * @param airlineID
     * @param flightID
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity aircraftRegistration(@RequestBody AircraftDetailsDTO aircraftDetailsDTO,
                                         @RequestParam UUID airlineID,
                                         @RequestParam List<UUID> flightID){
        try{
            Aircraft aircraft=aircraftService.airCraftRegistration(aircraftDetailsDTO,airlineID,flightID);
            return new ResponseEntity(aircraft,HttpStatus.CREATED);
        }catch (InvalidOperationException invalidOperationException){
            return new ResponseEntity<>(invalidOperationException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * If I want to get aircraft
     * Then we can search by aircraftId
     * @param aircraftId
     * @return
     */
    @GetMapping("/get/airCraftById/{aircraftId}")
    public ResponseEntity getAirCraftById(@PathVariable UUID aircraftId){

        try{
            Aircraft aircraft=aircraftService.getAirCraftsById(aircraftId);
            return new ResponseEntity<>(aircraft, HttpStatus.OK);
        }catch (InvalidOperationException invalidOperationException){
            return new ResponseEntity<>(invalidOperationException.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    /**
     * if I want to that all aircraft search
     * Then I use get all function
     * @return
     */
    @GetMapping("get/all/aircraft")
    public ResponseEntity getAllAirCrafts() {
        try {
            List<Aircraft> aircraftList = aircraftService.getAllAirCrafts();
            return new ResponseEntity<>(aircraftList, HttpStatus.OK);

        } catch (AircraftDoesNotExist aircraftDoesNotExist) {
            return new ResponseEntity<>(aircraftDoesNotExist.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * If I do  update any particular aircraft
     * Then we can do update aircraft by ID
     */

    @PutMapping("/update/{aircraftId}")
    public ResponseEntity updateAircraft(@PathVariable UUID aircraftId,
                                         @RequestBody AircraftDetailsDTO aircraftDetailsDTO){
        try {
            Aircraft aircraft = aircraftService.updateAircraft(aircraftId, aircraftDetailsDTO);
            return new ResponseEntity<>(aircraft,HttpStatus.OK);
        }catch(InvalidOperationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Get all flights inside the aircraft
     */
    @GetMapping("/flights/{aircraftId}")
    public ResponseEntity getAllFlightsInAnAircraft(@PathVariable UUID aircraftId){
        try {
            List<Flight> flights = aircraftService.getAllFlightsInAnAircraft(aircraftId);
            return new ResponseEntity(flights,HttpStatus.OK);
        }catch (InvalidOperationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
