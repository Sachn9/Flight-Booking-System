package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.PaymentStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class Payment {
    private UUID paymentId;

    private Double amount;
    private String method;

    private PaymentStatus paymentStatus;

    private String txnReference;

    private Booking booking;
}
