package com.flightbookingsystem.database_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID configId;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;    // Ya SubFlight, depending on level

    private String seatType;       // "Window", "Aisle", "Middle"
    private String seatClass;      // "Economy", "Business", "First"
    private Double price;          // Price for this combination

    private String additionalServices;  // Optional: e.g., "ExtraBaggage"


}
