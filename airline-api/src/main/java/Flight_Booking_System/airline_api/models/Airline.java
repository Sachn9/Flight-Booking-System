package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airline {

    private UUID airlineId;

    private String airlineName;
    private String officialName;
    private String address;
    private String contactNumber;
    private String email;
    private String website;
    private String status;
    private EmployeeRole admin;
    private List<Aircraft> airCrafts;
    private List<Employee> employees;
    private List<Flight> flights;
}
