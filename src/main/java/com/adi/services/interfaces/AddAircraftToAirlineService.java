package com.adi.services.interfaces;

import com.adi.dataModel.interfaces.NewAirlineAircraftDataModel;
import com.adi.persistence.model.AirlineAircrafts;

public interface AddAircraftToAirlineService {
    AirlineAircrafts addAircraftToAirline(NewAirlineAircraftDataModel airlineAircraftDataModel, Long airlineId);
}
