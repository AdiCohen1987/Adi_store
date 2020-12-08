package com.adi.services.interfaces;

import com.adi.dataModel.interfaces.NewAirlineDataModel;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineLocations;

import java.util.List;

public interface LocationService {

    AirlineLocations addLocation(AirlineLocations airlineLocation, Long airlineIid);

    List<AirlineLocations> getAllLocationsByAirline(Long airlineId);
}
