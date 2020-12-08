package com.adi.persistence.gateway.interfaces;

import com.adi.persistence.model.AirlineLocations;

import java.util.List;

public interface LocationRepositoryGateway {

    AirlineLocations save(AirlineLocations airlineLocations);

    List<AirlineLocations> getDistinctByAirlineId(Long airlineId);
}
