package Flight_Booking_System.airline_api.models;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class FeedBack {
    private UUID feedbackId;
    private Integer rating;
    private String comments;
    private ZonedDateTime createdAt;
    private Customer customer;
    private Flight flight;
}
