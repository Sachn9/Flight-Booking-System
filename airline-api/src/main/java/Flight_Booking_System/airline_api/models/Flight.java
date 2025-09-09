package Flight_Booking_System.airline_api.models;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Flight {
    private UUID flightId;

    private Airport originAirport;

    private Airport destinationAirport;

    private ZonedDateTime departure;
    private ZonedDateTime arrival;

    private Double price;
    private String status;

    private Airline airline;

    private Aircraft aircraft;

    private List<Seat> seats;

    private List<Booking> bookings;

    private List<FeedBack> feedbacks;

    private List<WaitList> waitlists;
}
