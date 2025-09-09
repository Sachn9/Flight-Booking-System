package Flight_Booking_System.airline_api.utility;

import Flight_Booking_System.airline_api.dto.AirLineDTO;
import Flight_Booking_System.airline_api.enums.EmployeeRole;
import Flight_Booking_System.airline_api.models.Airline;
import Flight_Booking_System.airline_api.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class MappingUtility{

    public Airline mapToAirlineToAirLineDto(AirLineDTO airLineDTO, EmployeeRole admin){
        Airline airline=Airline.builder()
                .airlineName(airLineDTO.getName())
                .officialName(airLineDTO.getOfficialName())
                .address(airLineDTO.getAddress())
                .contactNumber(airLineDTO.getContactNumber())
                .email(airLineDTO.getEmail())
                .website(airLineDTO.getWebsite())
                .admin(admin)
                .status(airLineDTO.getStatus())
                .build();
        return airline;
    }

    public
}
