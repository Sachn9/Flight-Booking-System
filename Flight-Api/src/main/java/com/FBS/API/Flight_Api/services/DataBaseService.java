package com.FBS.API.Flight_Api.services;

import com.FBS.API.Flight_Api.connector.DatabaseApiConnector;
import com.FBS.API.Flight_Api.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseService {
    DatabaseApiConnector databaseApiConnector;
    @Autowired
    public DataBaseService(DatabaseApiConnector databaseApiConnector){
        this.databaseApiConnector=databaseApiConnector;
    }

    public Flight createFlight(Flight flight){
        return databaseApiConnector.createFlightEndPoint(flight);
    }

}
