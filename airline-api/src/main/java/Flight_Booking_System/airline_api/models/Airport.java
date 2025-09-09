package Flight_Booking_System.airline_api.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Airport {
    private UUID airportId;

    private String airportCode;
    private String name;
    private String city;
    private String country;
}
