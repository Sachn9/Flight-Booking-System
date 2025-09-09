package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.SeatClass;
import lombok.Data;

import java.util.UUID;

@Data
public class Fare {

    private UUID fareId;

    private SeatClass seatClass;

    private Double basePrice;
    private Double tax;
    private String currency;
}
