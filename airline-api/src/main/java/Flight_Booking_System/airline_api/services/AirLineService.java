package Flight_Booking_System.airline_api.services;

import Flight_Booking_System.airline_api.dto.AirLineDTO;
import Flight_Booking_System.airline_api.enums.EmployeeRole;
import Flight_Booking_System.airline_api.models.Airline;
import Flight_Booking_System.airline_api.models.Employee;
import Flight_Booking_System.airline_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirLineService {
    MappingUtility mappingUtility;
    @Autowired
    public AirLineService(MappingUtility mappingUtility){
        this.mappingUtility=mappingUtility;
    }

    public AirLineDTO registerToAirLine(AirLineDTO airLineDTO){
        Airline airline=mappingUtility.mapToAirlineToAirLineDto(airLineDTO, EmployeeRole.ADMIN);

    }
}
