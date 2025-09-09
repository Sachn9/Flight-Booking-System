package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.EmployeeRole;
import lombok.Data;

import java.util.UUID;

@Data
public class Employee {
    private UUID employeeId;

    private String name;
    private String email;
    private EmployeeRole employeeRole;
    private String status;
    private Airline airline;
}
