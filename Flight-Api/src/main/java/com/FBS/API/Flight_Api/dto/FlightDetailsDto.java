package com.FBS.API.Flight_Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetailsDto {
        private String flightName;
        private String status;
        private UUID airlineId;
}
