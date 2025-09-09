package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.BookingStatus;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Booking {

    private String bookingId;

    private ZonedDateTime bookingTime;
    private String pnrNumber;

    private BookingStatus bookingStatus;

    private Customer customer;

    private Flight flight;

    private Seat seat;

    private Payment payment;
}
