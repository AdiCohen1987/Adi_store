package com.adi.services.interfaces;

import com.adi.persistence.model.Airline;

import java.util.List;

public interface AirlineManagementService {
    Airline addNewAirline(Airline newAirline);
    List<String> getAirlinesWithCurrentBudget();

}
