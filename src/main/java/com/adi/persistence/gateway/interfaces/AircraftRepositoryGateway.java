package com.adi.persistence.gateway.interfaces;

import com.adi.persistence.model.AirlineAircrafts;

public interface AircraftRepositoryGateway {

    AirlineAircrafts findById(Long aircraftId);

    AirlineAircrafts save(AirlineAircrafts updatedAircraft);
}
