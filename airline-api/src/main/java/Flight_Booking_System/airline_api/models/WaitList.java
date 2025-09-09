package Flight_Booking_System.airline_api.models;

import lombok.Data;

import java.util.UUID;

@Data
public class WaitList {

    private UUID waitlistId;
    private Integer position;
    private String status;
    private Customer customer;
    private Flight flight;
}
