package com.flightbookingsystem.database_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID subFlightId;

    private String originAirport;
    private String destinationAirport;
    private ZonedDateTime departure;
    private ZonedDateTime arrival;

    private UUID flightId; // Reference to main Flight

    @ManyToOne
    private Aircraft aircraft;
}
