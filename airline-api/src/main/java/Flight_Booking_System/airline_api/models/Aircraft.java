package Flight_Booking_System.airline_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    private UUID aircraftId;

    private String aircraftNumber;
    private String type;
    private Integer capacity;
    private String configuration;

    private Airline airline;

    private List<Flight> flights;
}
