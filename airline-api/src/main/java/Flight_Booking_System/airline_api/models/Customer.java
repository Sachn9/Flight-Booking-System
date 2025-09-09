package Flight_Booking_System.airline_api.models;

import Flight_Booking_System.airline_api.enums.Role;
import lombok.Data;

import javax.management.Notification;
import java.util.List;
import java.util.UUID;

@Data
public class Customer {

    private UUID customerId;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;

    private Double walletBalance;
    private Integer loyaltyPoints;

    private Role role;

    private List<Booking> bookings;

    private List<Notification> notifications;

    private List<FeedBack> feedbacks;

    private List<WaitList> waitlists;
}
