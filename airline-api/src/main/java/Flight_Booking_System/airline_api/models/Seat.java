package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.SeatClass;
import Flight_Booking_System.airline_api.enums.SeatStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class Seat {

    private UUID seatId;

    private String seatNumber;

    private SeatClass seatClass;

    private String seatType;

    private Fare fare;

    private SeatStatus seatStatus;

    private Flight flight;

    private Booking booking;
}
