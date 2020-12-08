package com.adi.persistence.gateways.interfaces;

import com.adi.persistence.model.AirlineLocations;

import java.util.ArrayList;
import java.util.List;

public interface LocationRepositoryGateway {

    AirlineLocations save(AirlineLocations airlineLocations);

    List<AirlineLocations> getDistinctByAirlineId(Long airlineId);

    AirlineLocations getByAirlineIdAndLocationName(Long airlineId, String locationName);

}
