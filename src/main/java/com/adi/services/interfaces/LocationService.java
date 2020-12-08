package com.adi.services.interfaces;

import com.adi.dataModel.interfaces.DestinationsToHomeBaseDataModel;
import com.adi.persistence.model.AirlineLocations;

import java.util.List;

public interface LocationService {

    AirlineLocations addLocation(AirlineLocations airlineLocation, Long airlineIid);

    List<AirlineLocations> getAllLocationsByAirline(Long airlineId);

    List<DestinationsToHomeBaseDataModel> getDestinationsToHomeBase(Long airlineId);

    List<String> getAvailableDestinations(Long airlineId);
}
