package com.Flight_Booking_System.Aircraft_API.controler;

import com.Flight_Booking_System.Aircraft_API.dto.AircraftDetailsDTO;
import com.Flight_Booking_System.Aircraft_API.model.Aircraft;
import com.Flight_Booking_System.Aircraft_API.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aircraft")
public class AircraftController {

    AircraftService aircraftService;
    @Autowired
    public AircraftController(AircraftService aircraftService){
        this.aircraftService=aircraftService;
    }

    @PostMapping("/register")
    public Aircraft aircraftRegistration(@RequestBody AircraftDetailsDTO aircraftDetailsDTO){
        Aircraft airCraft=aircraftService.airCraftRegistration(aircraftDetailsDTO);
        return airCraft;

    }
}
