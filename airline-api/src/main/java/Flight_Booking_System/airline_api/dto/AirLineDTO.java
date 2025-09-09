package Flight_Booking_System.airline_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirLineDTO {

    private String name;
    private String officialName;
    private String address;
    private String contactNumber;
    private String email;
    private String website;
    private String status;
}
