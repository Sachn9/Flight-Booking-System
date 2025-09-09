package Flight_Booking_System.airline_api.controllers;

import Flight_Booking_System.airline_api.dto.AirLineDTO;
import Flight_Booking_System.airline_api.services.AirLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlineController {

    AirLineService airLineService;
    @Autowired
    public AirlineController(AirLineService airLineService){
        this.airLineService=airLineService;
    }

    @PostMapping("/register")
    public ResponseEntity registrationToAirline(@RequestBody AirLineDTO airLineDTO){
        AirLineDTO airLine=airLineService.registerToAirLine(airLineDTO);
        
    }

}
