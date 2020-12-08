package com.adi.services.interfaces;

import com.adi.dataModel.interfaces.NewAirlineAircraftDataModel;
import com.adi.dataModel.interfaces.NewAirlineDataModel;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineAircrafts;

import java.util.List;

public interface AirlineManagementService {
    Airline addNewAirline(NewAirlineDataModel newAirline);
    List<String> getAirlinesWithCurrentBudget();
}
